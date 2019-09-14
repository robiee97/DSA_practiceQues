import java.util.*;

public class bidirectional {

    public static void main(String args[]) {
        solve();

    }

    public static void solve() {
        for (int i = 0; i < 7; i++) {
            addVertex(i);
        }
        addEdges(0, 1, 10);
        addEdges(0, 3, 40);
        addEdges(1, 2, 10);
        addEdges(2, 3, 10);
        addEdges(3, 4, 2);
        addEdges(4, 5, 2);
        addEdges(4, 6, 8);
        addEdges(5, 6, 3);

        display();
        System.out.println(noOfEdges);
        System.out.println(totalNoOfEdges());
        removeEdge(3, 4);
        removeVertex(3);
    }

    public static class Edge {

        int v1 = 0;
        int v2 = 0;
        int weight = 0;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
    }

    private static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    private static int noOfEdges = 0;

    // addVertex
    public static void addVertex(int v1) {
        if (graph.size() == v1) {
            graph.add(new ArrayList<>());
        }
    }

    // addEdges
    public static void addEdges(int v1, int v2, int weight) {
        if (v1 < graph.size() && v2 < graph.size()) {
            graph.get(v1).add(new Edge(v1, v2, weight));
            graph.get(v2).add(new Edge(v2, v1, weight));
            noOfEdges++;
        }
    }

    // total no of edges
    public static int totalNoOfEdges() {
        int count = 0;
        for (int i = 0; i < graph.size(); i++) {
            count += graph.get(i).size();
        }
        return count / 2;
    }

    // remove edges
    public static void removeEdge(int v1, int v2) {
        int idx1 = getIdx(v1, v2);
        if (idx1 != -1) {
            graph.get(v1).remove(idx1);
        }
        int idx2 = getIdx(v2, v1);
        if (idx2 != -1) {
            graph.get(v2).remove(idx2);
        }
    }
    //part of remove edges
    public static int getIdx(int v1, int v2) {
        for (int i = 0; i < graph.get(v1).size(); i++) {
            Edge e = graph.get(v1).get(i);
            if (e.v2 == v2) {
                return i;
            }
        }
        return -1;
    }

    // remove vertex
    public static void removeVertex(int v1) {
        for (int i = 0; i < graph.get(v1).size(); i++) {
            Edge e = graph.get(v1).get(i);
            int idx = getIdx(e.v2, e.v1);
            graph.get(e.v2).remove(idx);
        }
        graph.get(v1).remove(v1);
    }

    // contains
    public static boolean contains(int v1, int v2) {
        if (v1 < graph.size() && v2 < graph.size() && getIdx(v1, v2) != -1) {
            return true;
        }
        return false;
    }

    // display
    public static void display() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < graph.size(); i++) {
            for (Edge e : graph.get(i)) {
                sb.append("(" + e.v1 + "," + e.v2 + ")" + " @ " + e.weight);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    // ATOB path
    public static void hasPath() {
        boolean[] isVisited = new boolean[graph.size()];
        System.out.println(hasPath(0, 6, isVisited, ""));
    }

    public static boolean hasPath(int src, int desti, boolean[] isVisited, String ans) {
        if (src == desti) {
            System.out.print(res + " - >");
            return true;
        }
        if (isVisited[src]) {
            for (Edge e : graph.get(src)) {
                if (isVisited[e.v2])
                    continue;
                boolean res = hasPath(e.v2, desti, isVisited, ans + src);

                if (res) {
                    return true;
                }
            }

        }
        return false;
    }
    // ATOB ALL paths
    // ATOB SHORTEST paths

}