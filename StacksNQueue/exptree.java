import java.util.*;

public class exptree {
    public static void main(String[] args) {
        String exp = "8+4-2^(3+9/3)";
        Node root = eT(exp);
        display(root);
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

    public static class Node {
        char data;
        Node left;
        Node right;

        public Node() {
        }

        public Node(char data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static int getpriority(char op) {
        if (op == '+' || op == '-')
            return 1;
        else if (op == '*' || op == '/' || op == '%')
            return 2;
        else
            return 3;
    }

    public static Node eT(String exp) {
        Stack<Node> os = new Stack<>();
        Stack<Node> vs = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(' || ch == ')') {
                continue;
            } else if (ch >= '0' && ch <= '9') {
                Node nn = new Node(ch, null, null);
                vs.push(nn);
            } else {
                while (os.size() > 0 && getpriority(os.peek().data) >= getpriority(ch)) {
                    Node v2 = vs.peek();
                    vs.pop();
                    Node v1 = vs.peek();
                    vs.pop();
                    Node op = os.peek();
                    os.pop();
                    op.left = v1;
                    op.right = v2;
                    vs.push(op);
                }
                Node nn = new Node(ch, null, null);
                os.push(nn);
            }
        }
        while (os.size() != 0) {
            Node v2 = vs.peek();
            vs.pop();
            Node v1 = vs.peek();
            vs.pop();
            Node op = os.peek();
            os.pop();
            op.left = v1;
            op.right = v2;
            vs.push(op);
        }
        return vs.peek();
    }
}