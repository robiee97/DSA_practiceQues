import java.util.*;

public class prims {

    public static class Edge {
        int v1 = 0;
        int v2 = 0;
        int wt = 0;

        public Edge(int v1, int v2, int wt) {
            this.v1 = v1;
            this.v2 = v2;
            this.wt = wt;
        }
    }

    public static void main(String args[]) {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            graph.add(new ArrayList<>());
        }
        addEdges(graph, 0, 1, 10);
        addEdges(graph, 0, 3, 40);
        addEdges(graph, 1, 2, 10);
        addEdges(graph, 2, 3, 10);
        addEdges(graph, 3, 4, 2);
        addEdges(graph, 4, 5, 2);
        addEdges(graph, 4, 6, 8);
        addEdges(graph, 5, 6, 3);
        // removeEdge(3,4);
        // removeVertex(3);
        display(graph);
    }

    public static void addEdges(ArrayList<ArrayList<Edge>> graph, int v1, int v2, int weight) {
        // if (v1 < graph.size() && v2 < graph.size()) {
        graph.get(v1).add(new Edge(v1, v2, weight));
        graph.get(v2).add(new Edge(v2, v1, weight));
        // noOfEdges++;
        // }
    }

    public static void primsAlgo(ArrayList<ArrayList<Edge>> graph) {
        public static class PrimPair implements Comparable<PrimPair> {
            int vtx = 0;
            int avtx = -1;
            int wt = 0;

            public PrimPair(int vtx, int avtx, int wt) {
                this.vtx = vtx;
                this.avtx = avtx;
                this.wt = wt;

            }

            @Override
            public int compareTo(PrimPair o) {
                return this.wt - o.wt;
            }
        }

        ArrayList<ArrayList<PrimPair>> primsGraph = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            primsGraph.add(new ArrayList<>());
        }

        PriorityQueue<PrimPair> pq = new PriorityQueue<>();
        boolean isvisited[] = new boolean[graph.size()];

        pq.add(new PrimPair(0, -1, 0));

        while (!pq.isEmpty()) {
            PrimPair rpair = pq.remove();

            if (isvisited[rpair.vtx])
                continue;

            if (rpair.avtx == -1) {
                addEdge(primsGraph, rpair.vtx, rpair.avtx, rpair.wt);
            }

            isvisited[rpair.vtx] = true;
            for (Edge e : graph.get(rpair.vtx)) {
                if (!isvisited[e.v2]) {
                    pq.add(new PrimPair(e.v2, rpair.vtx, e.wt));
                }
            }
        }
        System.out.println();
        display(primsGraph);
    }

    public static void display(ArrayList<ArrayList<Edge>> graph) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < graph.size(); i++) {
            for (Edge e : graph.get(i)) {
                sb.append("(" + e.v1 + "," + e.v2 + ")" + " @" + e.weight + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void topoSort(ArrayList<ArrayList<Edge>> graph) {
        boolean[] isV = new boolean[graph.size()];
        ArrayList<Integer> topoOder = new ArrayList<>();
        for (int i = 0; i < isV.length; i++) {
            if (!isV[i]) {
                topoSort(graph, i, isV, topoOder);
            }
        }
        Collection.reverse(topoOder);
        System.out.println(topoOder);
    }

    public static void topoSort(ArrayList<ArrayList<Edge>> graph, int vtx, boolean[] isV,
            ArrayList<Integer> topoOrder) {

        isV[vtx] = true;
        for (Edge e : graph.get(vtx)) {
            if (!isV[e.v2]) {
                topoSort(graph, e.v2, isV, topoOrder);
            }
        }
        topoOrder.add(vtx);
    }

}
