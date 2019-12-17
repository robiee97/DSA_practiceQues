import java.util.*;

public class kruskalsAlgo {
    public static class Edge {
        int nbr;
        int wt;

        public Edge(int nbr, int wt) {
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static class KEdge implements Comparable<KEdge> {
        int v1;
        int v2;
        int wt;

        public KEdge(int v1, int v2, int wt) {
            this.v1 = v1;
            this.v2 = v2;
            this.wt = wt;
        }

        public int compareTo(KEdge other) {
            return this.wt - other.wt;
        }
    }

    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    public static void addEdge(ArrayList<ArrayList<Edge>> g, int v1, int v2, int wt) {
        Edge e1 = new Edge(v2, wt);
        g.get(v1).add(e1);

        Edge e2 = new Edge(v1, wt);
        g.get(v2).add(e2);
    }

    public static void display(ArrayList<ArrayList<Edge>> g) {
        for (int v = 0; v < g.size(); v++) {
            System.out.print(v + " -> ");
            for (int n = 0; n < g.get(v).size(); n++) {
                Edge ne = g.get(v).get(n);
                System.out.print("[" + ne.nbr + "," + ne.wt + "] ");
            }
            System.out.println();
        }
    }

    public static void kruskals(ArrayList<ArrayList<Edge>> g) {
        ArrayList<ArrayList<Edge>> mst = new ArrayList<>();
        int[] pa = new int[g.size()];
        int[] ra = new int[g.size()];

        for (int v = 0; v < g.size(); v++) {
            pa[v] = v;
            ra[v] = 1;

            mst.add(new ArrayList<>());
        }

        PriorityQueue<KEdge> pq = new PriorityQueue<>();
        for (int v = 0; v < g.size(); v++) {
            for (int n = 0; n < g.get(v).size(); n++) {
                Edge ne = g.get(v).get(n);
                if (v < ne.nbr) {
                    KEdge ke = new KEdge(v, ne.nbr, ne.wt);
                    pq.add(ke);
                }
            }
        }

        while (pq.size() > 0) {
            KEdge rem = pq.remove();
            int v1 = rem.v1;
            int v2 = rem.v2;

            int v1sl = find(pa, v1);
            int v2sl = find(pa, v2);

            if (v1sl != v2sl) {
                // add edge to mst btw v1 v2
                addEdge(mst, v1, v2, rem.wt);
                // merger of v1sl v2sl
                merge(pa, ra, v1sl, v2sl);
            }
        }
        display(mst);
    }

    public static int find(int[] pa, int v) {
        if (pa[v] == v) {
            return v;
        } else {
            return find(pa, pa[v]);
        }
    }

    public static void merge(int[] pa, int[] ra, int v1sl, int v2sl) {
        if (ra[v1sl] < ra[v2sl]) {
            pa[v1sl] = v2sl;
        } else if (ra[v1sl] > ra[v2sl]) {
            pa[v2sl] = v1sl;
        } else {
            pa[v1sl] = v2sl;
            ra[v2sl]++;
        }
    }

    public static void main(String[] args) {
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>());

        addEdge(graph, 0, 1, 20);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 0, 3, 40);
        addEdge(graph, 2, 3, 20);
        addEdge(graph, 2, 5, 5);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 3);
        addEdge(graph, 5, 6, 3);
        addEdge(graph, 4, 6, 8);

        // display(graph);
        kruskals(graph);
    }
}