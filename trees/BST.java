import java.util.*;

public class BST {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left != null ? node.left.data + "->" : ".->";
        str += node.data;
        str += node.right != null ? "<-" + node.right.data : "<-.";

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static Node construct(int[] sa, int lo, int hi) {

        if (lo > hi) {
            return null;
        }
        int mid = (lo + hi) / 2;
        Node node = new Node();
        node.data = sa[mid];
        node.left = construct(sa, lo, mid - 1);
        node.right = construct(sa, mid + 1, hi);
        return node;
    }

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        } else if (node.data > data) {
            return find(node.left, data);
        } else {
            return find(node.right, data);
        }
    }

    public static int Maxele(Node node) {
        if (node.right == null) {
            return node.data;
        } else {
            return Maxele(node.right);
        }
    }

    public static int Minele(Node node) {
        if (node.left == null) {
            return node.data;
        } else {
            return Minele(node.left);
        }
    }

    public static Node add(Node node, int data) {
        if (node == null) {
            return new Node(data, null, null);
        }
        if (data < node.data) {
            node.left = add(node.left, data);
        } else if (data > node.data) {
            node.right = add(node.right, data);
        } else {
            //
        }
        return node;
    }

    public static Node remove(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.data) {
            node.left = remove(node.left, data);
        } else if (data > node.data) {
            node.right = remove(node.right, data);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null && node.right != null || node.left != null && node.right == null) {
                if (node.left == null) {
                    return node.right;
                } else {
                    return node.left;
                }
            } else {
                // left max
                int lmax = Maxele(node.left);
                node.data = lmax;
                node.left = remove(node.left, lmax);
            }
        }
        return node;
    }

    static int sum = 0;

    public static void sog(Node node) {
        if (node == null) {
            return;
        }
        sog(node.right);
        int o = node.data;
        node.data = sum;
        sum += o;
        sog(node.left);
    }

    static ArrayList<Integer> ans = new ArrayList<>();

    public static void sumPair(Node node, int tar) {
        if (node == null) {
            return;
        }
        sumPair(node.left, tar);
        ans.add(node.data);
        sumPair(node.right, tar);

    }

    public static void sumPair2(Node node, int tar, Node root) {
        if (node == null) {
            return;
        }
        int comp = tar - node.data;
        if (comp > root.data && find(root, comp)) {
            System.out.println(node.data + "," + comp);
        }

        sumPair2(node.left, tar, root);
        sumPair2(node.right, tar, root);
    }

    public static class pair {
        Node node;
        int state = 0;

        public pair() {

        }

        public pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void sumPair3(Node root, int tar) {
        Stack<pair> stack1 = new Stack<>();
        stack1.push(new pair(root, 0));
        Stack<pair> stack2 = new Stack<>();
        stack2.push(new pair(root, 0));

        int lv = 0;
        int rv = 0;
        boolean ml = true;
        boolean mr = true;

        while (true) {
            while (ml && stack1.size() > 0) {
                pair tp = new pair();
                tp = stack1.peek();

                if (tp.node == null) {
                    stack1.pop();
                    continue;
                }

                if (tp.state == 0) {
                    // pre.add(tp.node.data);
                    tp.state++;
                    stack1.push(new pair(tp.node.left, 0));
                    // add left
                } else if (tp.state == 1) {
                    // in.add(tp.node.data);
                    tp.state++;
                    lv = tp.node.data;
                    stack1.push(new pair(tp.node.right, 0));
                    // add right
                    break;
                } else if (tp.state == 2) {
                    // post.add(tp.node.data);
                    stack1.pop();
                }

            }
            while (mr && stack2.size() > 0) {
                pair tp = new pair();
                tp = stack2.peek();

                if (tp.node == null) {
                    stack2.pop();
                    continue;
                }

                if (tp.state == 0) {
                    // pre.add(tp.node.data);
                    tp.state++;
                    stack2.push(new pair(tp.node.right, 0));
                    // add left
                } else if (tp.state == 1) {
                    // in.add(tp.node.data);
                    tp.state++;
                    rv = tp.node.data;
                    stack2.push(new pair(tp.node.left, 0));
                    // add right
                    break;
                } else if (tp.state == 2) {
                    // post.add(tp.node.data);
                    stack2.pop();
                }

            }
            if (lv > rv) {
                break;
            } else if (lv + rv < tar) {
                ml = true;
                mr = false;
            } else if (lv + rv > tar) {
                mr = true;
                ml = false;
            } else {
                System.out.println(lv + " " + rv);
                ml = true;
                mr = true;
            }
        }
    }

    public static void main(String[] args) {
        // int[] sa = { 12, 25, 37, 50, 62, 75, 87 };
        int[] sa = { 10, 20, 30, 50, 60, 70, 80 };

        Node root = construct(sa, 0, sa.length - 1);
        add(root, 25);
        add(root, 35);
        add(root, 55);
        add(root, 65);
        display(root);
        // add(root, 30);
        // remove(root, 75);
        // sog(root);
        // display(root);
        // int tar = 105;
        // sumPair(root, tar);
        // System.out.println(ans);
        // solve(90, 0, ans.size() - 1);
        // int lo = 0;
        // int hi = ans.size() - 1;
        // while (lo < hi) {
        // int res = ans.get(lo) + ans.get(hi);
        // if (res < tar) {
        // lo++;
        // } else if (res > tar) {
        // hi--;
        // } else {
        // System.out.println(ans.get(lo) + "." + ans.get(hi));
        // lo++;
        // hi--;
        // }
        // }

        sumPair3(root, 105);
        // sumPair2(root, 90, root);

        // System.out.println(find(root, 87));
        // System.out.println(Maxele(root));
        // System.out.println(Minele(root));
    }

}