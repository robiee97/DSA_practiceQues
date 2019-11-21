import java.util.*;

public class binaryTree {

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

    public static Node construct(int[] arr) {
        Stack<Node> stack = new Stack<>();
        Node root = null;
        for (int val : arr) {
            if (val == -1) {
                stack.pop();
            } else {
                Node node = new Node();
                node.data = val;
                if (stack.isEmpty()) {
                    root = node;
                } else {
                    if (stack.peek().left == null) {
                        stack.peek().left = node;
                    } else {
                        stack.peek().right = node;
                    }
                }
                stack.push(node);
            }
        }
        return root;
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

    public static int sizeOfGT(Node node) {
        if (node == null) {
            return 0;
        }

        int count1 = sizeOfGT(node.left);
        int count2 = sizeOfGT(node.right);

        return count1 + count2 + 1;
    }

    public static int maxEle(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int recAnsL = maxEle(node.left);
        int recAnsR = maxEle(node.right);

        return Math.max(node.data, Math.max(recAnsL, recAnsR));
    }

    public static int height(Node node) {
        if (node == null) {
            return 0;
        }
        int count1 = 0;
        int count2 = 0;
        count1 = height(node.left);
        count2 = height(node.right);

        return Math.max(count1, count2) + 1;
    }

    public static boolean find(Node node, int ele) {
        if (node == null) {
            return false;
        }

        if (node.data == ele) {
            return true;
        }

        boolean ans1 = find(node.left, ele);
        if (ans1) {
            return true;
        }

        boolean ans2 = find(node.right, ele);
        if (ans2) {
            return true;
        }
        return false;
    }

    public static void levelOrder(Node node) {
        LinkedList<Node> que = new LinkedList<>();

        que.addLast(node);

        while (!que.isEmpty()) {
            Node rNode = que.removeFirst();
            System.out.println(rNode.data);

            if (rNode.left != null) {
                que.addLast(rNode.left);
            }
            if (rNode.right != null) {
                que.addLast(rNode.right);
            }
        }
        System.out.print(".");

    }

    public static ArrayList<Integer> root2NodePath(Node node, int ele) {
        if (node == null) {
            return new ArrayList<>();
        }

        if (node.data == ele) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }

        ArrayList<Integer> ans1 = root2NodePath(node.left, ele);
        if (ans1.size() > 0) {
            ans1.add(node.left.data);
            return ans1;
        }

        ArrayList<Integer> ans2 = root2NodePath(node.right, ele);
        if (ans2.size() > 0) {
            ans2.add(node.right.data);
            return ans2;
        }
        return new ArrayList<>();
    }

    public static void mirror(Node node) {
        if (node == null) {
            return;
        }
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        mirror(node.left);
        mirror(node.right);
    }

    public static void removeLeafNode(Node node) {
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                node.left = null;
            } else {
                removeLeafNode(node.left);
            }
        }
        if (node.right != null) {
            if (node.right.left == null && node.right.right == null) {
                node.right = null;
            } else {
                removeLeafNode(node.right);
            }
        }
    }

    public static Node removeNodeR1(Node node) {
        if (node == null) {
            return null;
        } else if (node.left == null && node.right == null) {
            return null;
        } else {
            node.left = removeNodeR1(node.left);
            node.right = removeNodeR1(node.right);
        }
        return node;
    }

    public static void pir(Node node, int hi, int lo, String psf, int ssf) {
        if (node == null) {
            return;
        }
        if (ssf >= lo && ssf <= hi) {
            psf += " " + node.data;
            ssf += node.data;
            if (ssf >= lo && ssf <= hi)
                System.out.println(psf + " " + ssf);
            return;
        }

        pir(node.left, hi, lo, psf + " " + node.data, ssf + node.data);
        pir(node.right, hi, lo, psf + " " + node.data, ssf + node.data);

    }

    public static Node transToLD(Node node) {
        if (node == null) {
            return null;
        }
        node.left = transToLD(node.left);
        node.right = transToLD(node.right);
        node.left = new Node(node.data, node.left, null);
        return node;
    }

    public static Node transformLD(Node node) {
        if (node == null) {
            return null;
        }
        node.left = transformLD(node.left.left);
        node.right = transformLD(node.right);
        // node.left= new Node(node.data,node.left,null);
        return node;
    }

    // traverse pre,post,in
    // pre -- NodeLR, euler left, recursion deep, root first
    public static void pre(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        pre(node.left);
        pre(node.right);

    }

    // post -- LRNode, euler right, recursion up, root last
    public static void post(Node node) {
        if (node == null) {
            return;
        }
        post(node.left);
        post(node.right);
        System.out.print(node.data + " ");
    }

    // in -- LNodeR, euler middle, root middle
    public static void in(Node node) {
        if (node == null) {
            return;
        }
        in(node.left);
        System.out.print(node.data + " ");
        in(node.right);
    }

    public static Node construct2(int[] pre, int psi, int pei, int[] in, int isi, int iei) {
        if (psi > pei || isi > iei) {
            return null;
        }
        Node node = new Node();
        node.data = pre[psi];
        int x = -1;
        for (x = isi; x <= iei; x++) {
            if (pre[psi] == in[x]) {
                break;
            }
        }
        int lhs = x - isi;

        node.left = construct2(pre, psi + 1, psi + lhs, in, isi, x - 1);
        node.right = construct2(pre, psi + lhs + 1, pei, in, x + 1, iei);

        return node;
    }

    public static Node construct3(int[] post, int psi, int pei, int[] in, int isi, int iei) {
        if (psi > pei || isi > iei) {
            return null;
        }
        Node node = new Node();
        node.data = post[pei];

        int x = -1;
        for (x = isi; x <= iei; x++) {
            if (post[pei] == in[x]) {
                break;
            }
        }
        int lhs = x - isi;
        node.left = construct3(post, psi, psi + lhs - 1, in, isi, x - 1);
        node.right = construct3(post, psi + lhs, pei - 1, in, x + 1, iei);

        return node;
    }

    public static Node construct4(int[] post, int posi, int poei, int[] pre, int prsi, int prei) {
        if (posi > poei || prsi > prei) {
            return null;
        }
        Node node = new Node();
        node.data = pre[prsi];

        int x = -1;
        for (x = posi; x <= poei; x++) {
            if (pre[prsi + 1] == post[x]) {
                break;
            }
        }
        int lhs = x - posi;
        node.left = construct4(post, posi, x, pre, prsi + 1, prsi + lhs - 1);
        node.right = construct4(post, x + 1, poei - 1, pre, prsi + lhs, prei);

        return node;
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

    public static void iterativeDFTraversal(Node root) {
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();

        Stack<pair> stack = new Stack<>();

        stack.push(new pair(root, 0));

        while (stack.size() > 0) {
            pair tp = new pair();
            tp = stack.peek();

            if (tp.node == null) {
                stack.pop();
                continue;
            }

            if (tp.state == 0) {
                pre.add(tp.node.data);
                tp.state++;

                stack.push(new pair(tp.node.left, 0));
                // add left
            } else if (tp.state == 1) {
                in.add(tp.node.data);
                tp.state++;

                stack.push(new pair(tp.node.right, 0));
                // add right
            } else if (tp.state == 2) {
                post.add(tp.node.data);
                tp.state++;

                stack.pop();
            }

        }
        System.out.println("pre->" + pre);
        System.out.println("in->" + in);
        System.out.println("post->" + post);

    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        int f = lh + rh + 2;

        int ld = diameter(root.left);
        int rd = diameter(root.right);

        return Math.max(f, Math.max(ld, rd));
    }

    public static class dpair {
        int h;
        int d;
    }

    public static dpair diameter2(Node node) {
        if (node == null) {
            dpair bdp = new dpair();
            bdp.h = -1;
            bdp.d = 0;
            return bdp;
        }

        dpair ld = diameter2(node.left);
        dpair rd = diameter2(node.right);
        dpair mp = new dpair();

        mp.h = Math.max(ld.h, rd.h) + 1;
        mp.d = Math.max(ld.h + rd.h + 2, Math.max(ld.d, rd.d));
        return mp;
    }

    public static class BalPair {
        boolean isbal;
        int ht;
    }

    public static BalPair isBalanceTree(Node node) {
        if (node == null) {
            BalPair bp = new BalPair();
            bp.isbal = true;
            bp.ht = 0;
            return bp;
        }
        BalPair lb = isBalanceTree(node.left);
        BalPair rb = isBalanceTree(node.right);
        BalPair mp = new BalPair();

        mp.isbal = lb.isbal && rb.isbal && Math.abs(lb.ht - rb.ht) <= 1;
        mp.ht = Math.max(lb.ht, rb.ht) + 1;

        return mp;
    }

    public static class BSTPair {
        boolean isBST;
        int max;
        int min;
    }

    public static BSTPair isBST(Node node) {
        if (node == null) {

            BSTPair bp = new BSTPair();
            bp.max = Integer.MIN_VALUE;
            bp.min = Integer.MAX_VALUE;
            bp.isBST = true;
            return bp;
        }

        BSTPair lp = isBST(node.left);
        BSTPair rp = isBST(node.right);
        BSTPair mp = new BSTPair();

        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
        mp.isBST = lp.isBST && rp.isBST && node.data > lp.max && node.data < rp.min;

        return mp;
    }

    public static class BSTPair2 {
        boolean isBST;
        int max;
        int min;
        Node lbstroot;
        int lbstsize;
    }

    public static BSTPair2 LargestBST(Node node) {
        if (node == null) {

            BSTPair2 bp = new BSTPair2();
            bp.max = Integer.MIN_VALUE;
            bp.min = Integer.MAX_VALUE;
            bp.isBST = true;

            bp.lbstroot = null;
            bp.lbstsize = 0;
            return bp;
        }

        BSTPair2 lp = LargestBST(node.left);
        BSTPair2 rp = LargestBST(node.right);
        BSTPair2 mp = new BSTPair2();

        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
        mp.isBST = lp.isBST && rp.isBST && node.data > lp.max && node.data < rp.min;

        if (mp.isBST) {
            mp.lbstroot = node;
            mp.lbstsize = lp.lbstsize + rp.lbstsize + 1;
        } else {
            if (lp.lbstsize > rp.lbstsize) {
                mp.lbstroot = lp.lbstroot;
                mp.lbstsize = lp.lbstsize;
            } else {
                mp.lbstroot = rp.lbstroot;
                mp.lbstsize = rp.lbstsize;
            }
        }
        return mp;
    }

    public static ArrayList<Node> root2NodePath2(Node node, int ele) {
        if (node == null) {
            return new ArrayList<>();
        }

        if (node.data == ele) {
            ArrayList<Node> list = new ArrayList<>();
            list.add(node);
            return list;
        }

        ArrayList<Node> ans1 = root2NodePath2(node.left, ele);
        if (ans1.size() > 0) {
            ans1.add(node.left);
            return ans1;
        }

        ArrayList<Node> ans2 = root2NodePath2(node.right, ele);
        if (ans2.size() > 0) {
            ans2.add(node.right);
            return ans2;
        }
        return new ArrayList<>();
    }

    public static void kfardown(Node tnode, Node block, int k) {

        if (tnode == null || tnode == block || k < 0) {
            return;
        }
        if (k == 0) {
            System.out.println(tnode.data);
        }
        kfardown(tnode.left, block, k - 1);
        kfardown(tnode.right, block, k - 1);
    }

    public static void kfar(Node node, int data, int k) {
        ArrayList<Node> rootNodePath = root2NodePath2(node, data);
        kfardown(rootNodePath.get(0), null, k);
        for (int i = 1; i < rootNodePath.size(); i++) {
            kfardown(rootNodePath.get(i), rootNodePath.get(i - 1), k - i);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1,
        70,-1, -1, 87, -1, -1, -1 };
        Node root = construct(arr);
        // int[] pre = { 50, 25, 12, 37, 30, 75, 62, 70, 87 };
        // int[] in = { 12, 25, 30, 37, 50, 62, 70, 75, 87 };
        // Node root = construct2(pre, 0, pre.length - 1, in, 0, in.length - 1);
        // display(root);

        // ---------------------bT inputs-----------------//
        // int[] post = { 12, 30, 37, 25, 70, 62, 87, 75, 50 };
        // int[] in = { 12, 25, 30, 37, 50, 62, 70, 75, 87 };
        // Node root = construct3(post, 0, post.length - 1, in, 0, in.length - 1);
        // Node root = construct4(post, 0, post.length - 1, pre, 0, pre.length - 1);

        // --------------------bST----------------------//
        // int[] post = { 12, 37, 25, 62, 87, 75, 50 };
        // int[] in = { 12, 25, 37, 50, 62, 75, 87 };
        // Node root = construct3(post, 0, post.length - 1, in, 0, in.length - 1);

        // display(root);
        // mirror(root);
        // System.out.println();
        // display(root);

        // BalPair p = isBalanceTree(root);
        // System.out.println(p.isbal+" "+p.ht);
        // iterativeDFTraversal(root);

        // BSTPair p = isBST(root);
        // System.out.println(p.isBST);

        // BSTPair2 p= LargestBST(root);
        // System.out.println(p.lbstsize+" "+p.lbstroot.data);

        // ----------------------kfar inputs-----------//
        // int[] post = { 80, 90, 40, 100, 110, 50, 20, 120, 130, 60, 140, 150, 70, 30,
        // 10 };
        // int[] in = { 80, 40, 90, 20, 100, 50, 110, 10, 120, 60, 130, 30, 140, 70, 150
        // };
        // Node root = construct3(post, 0, post.length - 1, in, 0, in.length - 1);

        // display(root);
        // System.out.println();
        // kfar(root, 10, 3);
        // ========================================================================================//
        // System.out.println(diameter(root));
        // System.out.println(root.data);
        // System.out.println(root.left);
        // System.out.println(root.right);
        // display(root);
        // System.out.println(sizeOfGT(root));
        // System.out.println(maxEle(root));
        // System.out.println(height(root));
        // System.out.println(find(root, 40));
        // System.out.println(root2NodePath(root, 70));
        // removeLeafNode(root);
        // System.out.println();
        // display(root);
        Node ans = removeNodeR1(root);
        // System.out.println();
        display(ans);
        // pir(root, 250, 150, "", 0);
        // Node ans = transformLD(root);
        // display(ans);
        // Node ans = transToLD(root);
        // display(ans);
    }
}