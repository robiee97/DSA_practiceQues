import java.util.*;

public class genericTree {

    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        int[] arr2 = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        Node ans = gTree(arr);
        Node ans2 = gTree(arr2);

        // display(ans);
        // System.out.println(find(ans, 30));
        // System.out.println(Min(ans));
        // System.out.println(Max(ans));
        // System.out.println(sizeOfTree(ans));
        // System.out.println(heightOfTree(ans));
        // System.out.println(lca(ans, 50, 60));
        // removeLeaf(ans);
        // levelorder(ans);
        // levelorder2(ans);
        // levelorder3(ans);
        // levelorder4(ans);
        // levelorder5ZigZag(ans);

        // multimove(ans);
        // kthCall(ans);
        // linearize(ans);
        // display(ans);
        // Node tail=linearizeEff(ans);
        // mirror(ans);
        // display(ans);

        // System.out.println(isIsomorphic(ans, ans2));
        // System.out.println(isMirror(ans, ans2));
        // System.out.println(isSymmetric(ans));
    }

    // -----------------node of tree
    public static class Node {
        int data = 0;
        ArrayList<Node> child = new ArrayList<>();

        public Node(int data) {
            this.data = data;
        }
    }

    // ----------------gtree
    public static Node gTree(int[] arr) {

        LinkedList<Node> st = new LinkedList<>();
        Node root = null;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.removeFirst();
            } else {
                Node node = new Node(arr[i]);
                if (st.size() == 0) {
                    root = node;
                } else {
                    st.getFirst().child.add(node);
                }
                st.addFirst(node);
            }

        }
        return root;
    }

    // -------------------find ele
    public static boolean find(Node root, int ele) {
        if (root.data == ele) {
            return true;
        }
        for (Node n : root.child) {
            boolean ans = find(n, ele);
            if (ans) {
                return true;
            }
        }
        return false;
    }

    // ---------------min node
    public static int Min(Node root) {
        int minOverAll = root.data;
        for (Node n : root.child) {
            int recAns = Min(n);
            minOverAll = Math.min(minOverAll, recAns);
        }
        return minOverAll;
    }

    // ---------------max node
    public static int Max(Node root) {
        int maxOverAll = root.data;
        for (Node n : root.child) {
            int recAns = Max(n);
            maxOverAll = Math.max(maxOverAll, recAns);
        }
        return maxOverAll;
    }

    public static int sizeOfTree(Node root) {
        int count = 0;
        for (Node n : root.child) {
            count += sizeOfTree(n);
        }
        return count + 1;
    }

    public static int heightOfTree(Node root) {
        int c = 0;
        for (Node n : root.child) {
            int ans = heightOfTree(n);
            c = Math.max(c, ans);
        }
        return c + 1;
    }

    public static ArrayList<Integer> pathFromNode(int ele, Node root) {
        if (root.data == ele) {
            ArrayList<Integer> base = new ArrayList<>();
            base.add(ele);
            return base;
        }

        for (Node n : root.child) {
            ArrayList<Integer> ans = pathFromNode(ele, n);
            if (ans.size() > 0) {
                ans.add(root.data);
                return ans;
            }
        }
        return new ArrayList<>();
    }

    public static int lca(Node root, int a, int b) {
        if (find(root, a) && find(root, b)) {
            ArrayList<Integer> one = pathFromNode(a, root);
            ArrayList<Integer> two = pathFromNode(b, root);

            for (int i = one.size() - 1, j = two.size() - 1; i >= 0 && j >= 0; i--, j--) {
                if (one.get(i) != two.get(j)) {
                    return one.get(i + 1);
                }
                if (i == 0) {
                    one.get(i);
                }
                if (j == 0) {
                    two.get(j);
                }
            }

        }
        return -1;
    }

    public static void removeLeaf(Node root) {
        for (int i = root.child.size() - 1; i >= 0; i--) {
            Node n = root.child.get(i);
            if (n.child.size() == 0) {
                root.child.remove(n);
            } else {
                removeLeaf(n);
            }
        }
    }

    public static void levelorder(Node root) {
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);
        while (!que.isEmpty()) {
            Node rnode = que.removeFirst();
            System.out.print(rnode.data + " ");
            for (Node n : rnode.child) {
                que.addLast(n);
            }
        }
    }

    public static void levelorder2(Node root) {
        LinkedList<Node> que1 = new LinkedList<>();
        LinkedList<Node> que2 = new LinkedList<>();

        que1.addLast(root);

        while (!que1.isEmpty()) {
            Node rnode = que1.removeFirst();
            System.out.print(rnode.data + " ");
            for (Node n : rnode.child) {
                que2.addLast(n);
            }
            if (que1.size() == 0) {
                System.out.println();
                LinkedList<Node> temp = que1;
                que1 = que2;
                que2 = temp;
            }
        }
    }

    public static void levelorder3(Node root) {
        LinkedList<Node> que = new LinkedList<>();

        que.addLast(root);
        que.addLast(null);

        while (que.size() > 1) {
            Node rnode = que.removeFirst();
            System.out.print(rnode.data + " ");
            for (Node n : rnode.child) {
                que.addLast(n);
            }
            if (que.getFirst() == null) {
                System.out.println();
                que.removeFirst();
                que.addLast(null);
            }

        }
    }

    public static void levelorder4(Node root) {
        LinkedList<Node> que = new LinkedList<>();

        que.addLast(root);

        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                Node rnode = que.removeFirst();
                System.out.print(rnode.data + " ");
                for (Node n : rnode.child) {
                    que.addLast(n);
                }
            }
            System.out.println();
        }

    }

    public static void levelorder5ZigZag(Node root) {
        LinkedList<Node> st1 = new LinkedList<>();
        LinkedList<Node> st2 = new LinkedList<>();
        boolean flag = false;
        st1.addFirst(root);

        while (!st1.isEmpty()) {
            Node rnode = st1.removeFirst();
            System.out.print(rnode.data + " ");

            if (flag) {
                for (int i = rnode.child.size() - 1; i >= 0; i--) {
                    st2.addFirst(rnode.child.get(i));
                }
            } else {
                for (Node n : rnode.child) {
                    st2.addFirst(n);
                }
            }
            if (st1.size() == 0) {
                System.out.println();
                LinkedList<Node> temp = st1;
                st1 = st2;
                st2 = temp;
                flag = !flag;
            }
        }
    }

    public static class HMPair {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        boolean find = false;

        int prev = -1;
        int succ = -1;
        int pred = -1;
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;

    }

    public static void multimove(Node root, int data, HMPair pair) {
        if (pair.find == false && root.data == data) {
            pair.find = true;
            pair.pred = pair.prev;
        }

        if (pair.find == true && pair.prev == data) {
            pair.succ = root.data;
        }

        pair.max = Math.max(pair.max, root.data);
        pair.min = Math.min(pair.min, root.data);

        pair.prev = root.data;

        if (root.data < data) {
            pair.floor = Math.max(root.data, pair.floor);
        }
        if (root.data > data) {
            pair.ceil = Math.min(root.data, pair.ceil);
        }

        for (Node n : root.child) {
            multimove(n, data, pair);
        }

    }

    public static void multimove(Node root) {
        HMPair pair = new HMPair();
        multimove(root, 80, pair);
        // System.out.println(pair.pred);
        // System.out.println(pair.succ);
        // System.out.println(pair.floor);
        // System.out.println(pair.ceil);

    }

    public static void kThLargest(Node root, HMPair pair, int k) {
        int largest = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            multimove(root, largest, pair);
            largest = pair.floor;
            pair.floor = Integer.MIN_VALUE;
        }
        System.out.println(largest);
    }

    public static void kThsmallest(Node root, HMPair pair, int k) {
        int smallest = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            multimove(root, smallest, pair);
            smallest = pair.ceil;
            pair.ceil = Integer.MAX_VALUE;
        }
        System.out.println(smallest);
    }

    public static void kthCall(Node root) {
        HMPair pair = new HMPair();
        kThLargest(root, pair, 2);
        kThsmallest(root, pair, 2);
    }

    public static void mirror(Node root) {
        for (Node child : root.child) {
            mirror(child);
        }
        Collections.reverse(root.child);
    }

    public static boolean isMirror(Node firstTree, Node secondTree) {
        if (firstTree.child.size() != secondTree.child.size()) {
            return false;
        }
        int left = 0;
        int right = firstTree.child.size() - 1;

        while (left < firstTree.child.size()) {
            Node lcf = firstTree.child.get(left);
            Node rcs = secondTree.child.get(right);

            boolean isMC = isMirror(lcf, rcs);
            if (isMC == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSymmetric(Node root) {
        return isMirror(root, root);
    }

    public static void linearize(Node node) {
        for (Node child : node.child) {
            linearize(child);
        }

        while (node.child.size() > 1) {
            Node sl = node.child.get(node.child.size() - 2);
            Node l = node.child.remove(node.child.size() - 1);

            Node slkiTail = getTail(sl);
            slkiTail.child.add(l);
        }
    }

    public static Node getTail(Node node) {
        Node tail = node;
        while (tail.child.size() == 1) {
            tail = tail.child.get(0);
        }
        return tail;
    }

    public static Node linearizeEff(Node node) {
        if (node.child.size() == 0) {
            return node;
        }

        Node otail = linearizeEff(node.child.get(node.child.size() - 1));

        while (node.child.size() > 1) {
            Node sl = node.child.get(node.child.size() - 2);
            Node l = node.child.get(node.child.size() - 1);

            Node slkitail = linearizeEff(sl);
            node.child.remove(l);

            slkitail.child.add(l);
        }
        return otail;
    }

    public static boolean isIsomorphic(Node firstTree, Node secondTree) {
        if (firstTree.child.size() == secondTree.child.size()) {
            for (int i = 0; i < firstTree.child.size(); i++) {
                Node fC = firstTree.child.get(i);
                Node sC = secondTree.child.get(i);

                boolean isCI = isIsomorphic(fC, sC);
                if (isCI == false) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    // ----------------display
    public static void display(Node root) {
        System.out.print(root.data + " -> ");
        for (Node child : root.child) {
            System.out.print(child.data + " ");
        }
        System.out.println(".");

        for (Node child : root.child) {
            display(child);
        }
    }

}