import java.util.*;

public class AVL {

    public static class Node {
        int data;
        Node left;
        Node right;
        int ht = 1;
        int bal = 0;

        public Node() {
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static int getht(Node node) {
        int lh = node.left != null ? node.left.ht : 0;
        int rh = node.right != null ? node.right.ht : 0;
        return Math.max(lh, rh) + 1;
    }

    public static int getbal(Node node) {
        int lh = node.left != null ? node.left.bal : 0;
        int rh = node.right != null ? node.right.bal : 0;
        return lh - rh;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left != null ? node.left.data + "->" : ".->";
        str += node.data + "_" + node.ht + "_" + node.bal;
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
        node.ht = getht(node);
        node.bal = getbal(node);
        return node;
    }

    public static int Maxele(Node node) {
        if (node.right == null) {
            return node.data;
        } else {
            return Maxele(node.right);
        }
    }

    public static Node leftRotation(Node x) {
        Node y = x.left;
        Node t3 = y.right;

        y.right = x;
        x.left = t3;

        x.ht = getht(x);
        x.bal = getbal(x);
        y.ht = getht(y);
        x.bal = getht(y);

        return y;
    }

    public static Node rightRotation(Node x) {
        Node y = x.right;
        Node t3 = y.left;

        y.left = x;
        x.right = t3;

        x.ht = getht(x);
        x.bal = getbal(x);
        y.ht = getht(y);
        x.bal = getht(y);

        return y;

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

            node.ht = getht(node);
            node.bal = getbal(node);

            if (node.bal > 1) {
                if (node.left.bal >= 0) {
                    // ll
                    node = rightRotation(node);
                } else {
                    // lr
                    node.left = leftRotation(node.left);
                }
            } else if (node.bal < -1) {
                if (node.right.bal <= 0) {
                    // rr
                    node = leftRotation(node);
                } else {
                    // rl
                    node.right = rightRotation(node.right);
                }
            }
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
            if (node != null) {

                node.ht = getht(node);
                node.bal = getbal(node);

                if (node.bal > 1) {
                    if (node.left.bal >= 0) {
                        // ll
                        node = rightRotation(node);
                    } else {
                        // lr
                        node.left = leftRotation(node.left);
                    }
                } else if (node.bal < -1) {
                    if (node.right.bal <= 0) {
                        // rr
                        node = leftRotation(node);
                    } else {
                        // rl
                        node.right = rightRotation(node.right);
                    }
                }
            }
        }
        return node;

    }

    public static void main(String[] args) {

        int[] sa = { 10, 20, 30, 50, 60, 70, 80 };

        Node root = construct(sa, 0, sa.length - 1);
        add(root, 30);
        add(root, 28);
        add(root, 29);
        remove(root, 20);
        display(root);

    }
}