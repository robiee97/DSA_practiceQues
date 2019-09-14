import java.util.*;

public class trie {
    public static class Node {
        char data;
        HashMap<Character, Node> children;
        boolean eow;

        public Node(char data) {
            this.data = data;
            this.children = new HashMap<>();
            this.eow = false;
        }
    }

    public static void add(Node node, String word) {
        if (word.length() == 0) {
            node.eow = true;
            return;
        }
        char ch = word.charAt(0);
        String row = word.substring(1);
        Node child = node.children.get(ch);

        if (child == null) {
            child = new Node(ch);
            node.children.put(ch, child);
            add(child, row);
        } else {
            add(child, row);
        }
    }

    public static void remove(Node node, String word) {
        if (word.length() == 0) {
            node.eow = false;
            return;
        }
        char ch = word.charAt(0);
        String row = word.substring(1);
        Node child = node.children.get(ch);

        if (child == null) {
            return;
        } else {
            remove(child, row);
            if (child.eow == false && child.children.size() == 0) {
                child.children.remove(ch);
            }
        }
    }

    public static boolean search(Node node, String word) {
        if (word.length() == 0) {
            return node.eow;
        }
        char ch = word.charAt(0);
        String row = word.substring(1);
        Node child = node.children.get(ch);

        if (child == null) {
            return false;
        } else {
            return search(child, row);
        }
    }

    public static void display(Node node) {
        String s = node.data + " ->";
        ArrayList<Character> keys = new ArrayList<>(node.children.keySet());
        for (Character key : keys) {
            Node child = node.children.get(key);
            s += child.data + (child.eow ? "*" : "") + ",";
        }
        s += ".";

        System.out.println(s);
        for (Character key : keys) {
            Node child = node.children.get(key);
            display(child);
        }
    }

    public static void displayAllWords(Node node, String wsf) {
        if (node.eow == true) {
            System.out.println(wsf);
        }
        ArrayList<Character> keys = new ArrayList<>(node.children.keySet());
        for (Character key : keys) {
            Node child = node.children.get(key);
            displayAllWords(child, wsf + key);
        }
    }

    public static int[] getlps(String pat) {
        int j = 0;
        int i = 1;

        int[] lps = new int[pat.length()];
        lps[0] = 0;

        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(j)) {
                lps[i]=j+1;
                j++;
                i++;
            } else {
                if (j == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
        return lps;
    }

    public static void kmp(String src, String pat) {
        int[] lps = getlps(pat);
        int i = 0;
        int j = 0;
        while (i < src.length()) {
            if (src.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                if (j == pat.length()) {
                    System.out.println("found at " + (i - pat.length()));
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Node root = new Node('$');
        // add(root, "are");
        // add(root, "an");
        // add(root, "and");
        // add(root, "ant");
        // add(root, "see");
        // add(root, "seen");
        // add(root, "sea");

        // System.out.println(search(root, "as"));
        // add(root, "as");
        // System.out.println(search(root, "ask"));
        // add(root, "ask");
        // System.out.println(search(root, "ask"));

        // remove(root, "ask");
        // System.out.println(search(root, "ask"));

        // // displayAllWords(root, "");
        // display(root);
        String src = "nkasdhflkjdshfiluweaifusbdkjfahidufehiudskfjweiufhiuefkjsdbfiuefiuerhfjkeriugfrefie";
        String pat = "eiufh";
        kmp(src, pat);
    }
}