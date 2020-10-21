import java.util.*;

public class pracGraph {
    public static void main(String args[]) {
        solve();
    }

    private static void solve() {
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
        // removeEdge(3,4);
        removeVertex(3);
        display();
        System.out.println(noOfEdges);
        System.out.println(totalNoOfEdges());
        rottenOranges();
        Dijkstra(0);
    }

    // -------class for edges
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

    // -----------class for storing ans of min wt
    public static class MyPr {
        int wsf = 0;
        String psf = "";
        // int noOfE = 0;

        public MyPr(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
            // this.noOfE = noOfE;
        }
    }

    // -----------class for storing ans of shortest path
    public static class MyPr2 {
        int wsf = 0;
        String psf = "";
        int noOfE = 0;

        public MyPr2(int wsf, String psf, int noOfE) {
            this.wsf = wsf;
            this.psf = psf;
            this.noOfE = noOfE;
        }
    }

    private static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    // private static int noOfEdges = 0;

    // ----------------addVertex
    public static void addVertex(int v1) {
        if (graph.size() == v1) {
            graph.add(new ArrayList<>());
        }
    }

    // ----------------addEdges
    public static void addEdges(int v1, int v2, int weight) {
        if (v1 < graph.size() && v2 < graph.size()) {
            graph.get(v1).add(new Edge(v1, v2, weight));
            graph.get(v2).add(new Edge(v2, v1, weight));
            // noOfEdges++;
        }
    }

    // ----------------display
    public static void display() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < graph.size(); i++) {
            for (Edge e : graph.get(i)) {
                sb.append("(" + e.v1 + "," + e.v2 + ")" + " @" + e.weight + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    // ----method for totalNoOfEdges
    public static int totalNoOfEdges() {
        int count = 0;
        for (int i = 0; i < graph.size(); i++) {
            count += graph.get(i).size();
        }
        return count / 2;
    }

    // -------------to removeEdge
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

    // ------------to getIdx
    public static int getIdx(int v1, int v2) {
        for (int i = 0; i < graph.get(v1).size(); i++) {
            Edge e = graph.get(v1).get(i);
            if (e.v2 == v2) {
                return i;
            }

        }
        return -1;
    }

    // -------------to removeVertex
    public static void removeVertex(int v1) {
        for (int i = 0; i < graph.get(v1).size(); i++) {
            Edge e = graph.get(v1).get(i);
            int idx = getIdx(e.v2, v1);
            graph.get(e.v2).remove(idx);
        }
        graph.get(v1).remove(v1);
    }

    // -----------print a path
    public static void haspath() {
        boolean[] isVisited = new boolean[graph.size()];
        System.out.println(haspath(0, 6, isVisited, ""));
    }

    public static boolean haspath(int src, int desti, boolean[] isVisited, String ans) {
        if (src == desti) {
            System.out.print(ans + " - > ");
            return true;
        }
        isVisited[src] = true;
        for (Edge e : graph(src)) {
            if (isVisited[e.v2])
                continue;
            boolean res = haspath(e.v2, desti, isVisited, ans + src);
            if (res) {
                return true;
            }
        }

        return false;
    }

    // ---------------printAllPaths
    public static int printAllPaths(int src, int desti, boolean[] isVisited, String asf, int wsf) {

        if (src == desti) {
            System.out.print(asf + src + " - > " + wsf);
            return 1;
        }

        isVisited[src] = true;
        for (Edge e : graph(src)) {
            if (isVisited[e.v2])
                continue;
            count += printAllPaths(e.v2, desti, isVisited, asf + src, wsf + e.weight);
        }
        isVisited[src] = false;
        return count;
    }

    // --minWtPath
    MyPr minWtPath(int src, int dest, boolean[] isVisited) {
        if (src == dest) {
            MyPr base = new MyPr(0, src + "");
            return base;
        }

        MyPr myAns = new MyPr(10000, "");
        isVisited[src] = true;
        for (Edge e : graph.get(src)) {
            if (isVisited[src])
                continue;
            MyPr recAns = minWtPath(e.v2, dest, isVisited);
            if (recAns.wsf + e.weight < myAns.wsf) {
                myAns.wsf = recAns.wsf + e.weight;
                myAns.psf = src + recAns.psf;
            }
        }
        isVisited[src] = false;
        return myAns;
    }

    // ---shortest path
    MyPr2 shortestPath(int src, int dest, boolean[] isVisited) {
        if (src == dest) {
            MyPr2 base = new MyPr2(0, src + "", 0);
            return base;
        }

        MyPr2 myAns = new MyPr2(0, "", 1000);
        isVisited[src] = true;
        for (Edge e : graph.get(src)) {
            if (isVisited[src])
                continue;
            MyPr2 recAns = shortestPath(e.v2, dest, isVisited);
            if (recAns.noOfE + 1 < myAns.noOfE) {
                myAns.wsf = recAns.wsf + e.weight;
                myAns.psf = src + recAns.psf;
                myAns.noOfE = recAns.noOfE + 1;
            }
        }
        isVisited[src] = false;
        return myAns;
    }

    // -------class for BFSPair
    public static class BFSPair {
        int vtx = 0;
        int wsf = 0;
        String psf = "";
        int noOfEdgesInBFS = 0;

        public BFSPair(int vtx, int wsf, String psf, int noOfEdgesInBFS) {
            this.vtx = vtx;
            this.wsf = wsf;
            this.psf = psf;
            this.noOfEdgesInBFS = noOfEdgesInBFS;

        }
    }

    // -----------------Breadth first search(cycle,destination)
    public static void BFS(int src, int desti, boolean[] isvisited) {

        LinkedList<BFSPair> que = new LinkedList<>();
        que.addLast(new BFSPair(src, 0, src + "", 0));

        while (!que.isEmpty()) {
            BFSPair rpair = que.removeFirst();
            if (isvisited[rpair.vtx]) {
                System.out.println("cycle" + rpair.vtx + " via " + rpair.psf);
                continue;
            }
            isvisited[rpair.vtx] = true;

            if (rpair.vtx == desti) {
                System.out.println("desti:" + desti + " " + rpair.vtx + "via" + rpair.psf);
                // return;
            }
            System.out.println("desti:" + desti + " " + rpair.vtx + "via" + rpair.psf);

            for (Edge e : graph.get(rpair.vtx)) {
                if (!isvisited[e.v2]) {
                    que.addLast(new BFSPair(e.v2, rpair.wsf + e.weight, e.v2 + psf, noOfEdgesInBFS + 1));
                }
            }

        }

    }

    // ---components in BFS
    public static void BFTcomp() {
        boolean[] isVisited = new boolean[graph.size()];
        int comp = 0;
        for (int i = 0; i < graph.size(); i++) {
            if (!isVisited[i]) {
                BFS(i, 6, isVisited);
                System.out.println();
                comp++;
            }
        }
        System.out.println(comp);
    }

    // ---------------- DFSrec
    public static void DFSrec(int src, boolean[] isVisited, String psf) {
        isVisited[src] = true;
        System.out.println(src + "via" + psf);

        for (Edge e : graph.get(src)) {
            if (!isVisited[e.v2]) {
                DFSrec(e.v2, isVisited, e.v2 + psf);
            }
        }
        isVisited[src] = false;
    }

    // ----------------DFTcomp
    public static void DFTcomp() {
        int comp = 0;
        boolean[] isVisited = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            if (!isVisited[i]) {
                DFSrec(i, isVisited, psf);
                System.out.println();
                comp++;
            }
        }
        System.out.println(comp);
    }

    public static void noOfcycles() {
        boolean[] isVisited = new boolean[graph.size()];
        noOfcycles(0, isVisited);
    }

    // noOfcycles
    private static int noOfcycles(int src, boolean[] isVisited) {

        int cycle = 0;
        LinkrdList<BFSPair> que = new LinkedList<>();

        que.addLast(new BFSPair(src, 0, src + ""));
        while (!que.isEmpty()) {
            BFSPair rpair = que.removeFirst();

            if (isVisited[rpair.vtx]) {
                cycle++;
                continue;
            }
            for (Edge e : graph.get(rpair.vtx)) {
                if (!isVisited[e.v2]) {
                    que.addLast(new BFSPair(e.v2, rpair.wsf + e.weight, rpair.psf + e.v2));
                }
            }
        }
        return cycle;
    }

    // iscyc
    public static boolean iscyc(boolean[] isVisited) {
        int cycles = 0;
        for (int i = 0; i < graph.size(); i++) {
            if (!isVisited[i]) {
                cycles += noOfcycles(i, isVisited);
            }
        }
        return cycles > 0 ? true : false;
    }

    // // compinCycle
    public static int compinCycle(boolean[] isVisited) {
        int components = 0;
        for (int i = 0; i < graph.size(); i++) {
            if (!isVisited[i]) {
                int cycles = noOfcycles(i, isVisited);
                components++;
                System.out.println(cycles + " : " + components);
            }
        }
        return components;
    }

    // isconnected
    public static boolean isconnected(boolean[] isVisited) {
        int components = 0;
        for (int i = 0; i < graph.size(); i++) {
            if (!isVisited[i]) {
                int cycles = noOfcycles(i, isVisited);
                components++;

                System.out.println(cycles + " : " + components);
            }
        }
        return components == 1 ? true : false;
    }

    // bipitrate
    public static class bipitratePair {
        int vtx = 0;
        String color = "R";

        public bipitratePair(int vtx, String color) {
            this.vtx = vtx;
            this.color = color;
        }
    }

    public static boolean bipitrate(int src, bipitratePair[] isVisited) {
        // bipitratePair[] isVisited = new boolean[graph.size()];
        LinkrdList<bipitratePair> que = new LinkedList<>();
        que.addLast(new BFSPair(src, "R"));
        while (!que.isEmpty()) {
            bipitratePair rpair = que.removeFirst();
            if (isVisited[rpair.vtx] != null) {
                String oldC = isVisited[rpair.vtx].color;
                String newC = rpair.color;
                if (!oldC.equals(newC)) {
                    return false;
                    continue;
                }
            }
            for (Edge e : graph.get(rpair.vtx)) {
                if (isVisited[e.v2] == null) {
                    String color = rpair.color.equals("R") ? "G" : "R";
                    que.addLast(new BFSPair(e.v2, color));
                }
            }
        }
        return true;
    }

    // allbipitrate
    public static void allbipitrate() {
        bipitratePair[] isVisited = new bipitratePair[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (isVisited[i] == null) {
                System.out.println(bipitrate(i, isVisited));
            }
        }
    }

    // BAW_DFS
    public static void BAW_BFS() {
        int[][] mat = {};
        boolean[][] isVisited = new boolean[mat.length][mat[0].length];
        BAW_DFS(mat, isVisited, 0);
    }

    public static int BAW_DFS(int[][] mat, boolean[][] isVisited, int bno) {
        if (bno == mat.length * mat[0].length) {
            return 0;
        }
        int maxTime = 0;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        for (int d = 0; d < dir.length; d++) {
            int r = dir[d][0] + bno / mat[0].length;
            int c = dir[d][1] + bno % mat[0].length;

            if (r < mat.length && c < mat[0].length && r >= 0 && c >= 0 && !isVisited[r][c] && mat[r][c] == 1) {
                isVisited[r][c] = true;
                int recAns = BAW_DFS(mat, isVisited, bno + 1);
                maxTime = Math.max(recAns, maxTime) + 1;
                isVisited[r][c] = false;
            }
        }
        return maxTime;
    }

    // BAW_BFS

    public static class BAWPair {
        int r = 0;
        int c = 0;
        int time = 0;

        public BAWPair(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static int BAW_BFS(int[][] mat) {
        boolean[][] isVisited = new boolean[mat.length][mat[0].length];
        int maxTime = 0;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && isVisited[i][j] == false) {
                    LinkedList<BAWPair> que = new LinkedList<>();
                    que.addLast(new BAWPair(i, j, 0));

                    while (!que.isEmpty()) {
                        BAWPair rPair = que.removeFirst();
                        maxTime = Math.max(maxTime, rPair.time + 1);
                        for (int d = 0; d < dir.length; d++) {
                            int r = dir[d][0] + rPair.r;
                            int c = dir[d][1] + rPair.c;

                            if (r < mat.length && c < mat[0].length && r >= 0 && c >= 0 && !isVisited[r][c]
                                    && mat[r][c] == 1) {
                                isVisited[r][c] = true;
                                que.addLast(new BAWPair(r, c, rPair.time + 1));
                            }
                        }
                    }
                }
            }
        }
        return maxTime;
    }

    public static class ROPair {
        int r = 0;
        int c = 0;
        int maxTime = 0;

        public ROPair(int r, int c, int maxTime) {
            this.r = r;
            this.c = c;
            this.maxTime = maxTime;
        }
    }

    public static void rottenOranges() {
        int[][] mat = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        System.out.println(rottenOranges(mat));
    }

    public static int rottenOranges(int[][] mat) {
        int Time = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 2) {
                    LinkedList<ROPair> que = new LinkedList<>();
                    que.addLast(new ROPair(i, j, 0));

                    while (!que.isEmpty()) {
                        ROPair rPair = que.removeFirst();
                        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
                        for (int d = 0; d < dir.length; d++) {
                            int r = dir[d][0] + rPair.r;
                            int c = dir[d][1] + rPair.c;

                            if (r >= 0 && c >= 0 && r < mat.length && c < mat[0].length && mat[r][c] == 1) {
                                mat[r][c] = 2;
                                int prevTime = rPair.maxTime;
                                int currTime = prevTime + 1;
                                que.addLast(new ROPair(r, c, currTime));
                                Time = currTime;
                            }
                        }
                    }

                    for (int a = 0; a < mat.length; a++) {
                        for (int b = 0; b < mat[0].length; b++) {
                            if (mat[a][b] == 1) {
                                return -1;
                            }
                        }
                    }
                }
            }
        }
        return Time;
    }
    
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh =0;
        int time =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                   queue.add(new int[]{i,j}); 
                }
                else if(grid[i][j]==1){
                    fresh ++;
                }
            }
        }
    
        int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!queue.isEmpty() && fresh >0){
            time++;
            int len= queue.size();
            for(int i=0;i<len;i++){
                int[] rott = queue.poll();
                for(int[] dir: direction){
                    int nrow = rott[0] + dir[0];
                    int ncol = rott[1] + dir[1];

                    if(nrow<0 || nrow>= grid.length ||
                       ncol<0 || ncol>= grid[0].length ||
                       grid[nrow][ncol] == 2 || grid[nrow][ncol] == 0)
                    continue;

                    grid[nrow][ncol]=2;
                    fresh --;
                    queue.add(new int[]{nrow,ncol});
                }
            }
        }
        return fresh==0?time:-1;
    }


    private static class DijkstraPair implements Comparable<DijkstraPair> {
        int vtx = 0;
        int wsf = Integer.MAX_VALUE;
        String psf = "";
        int noE = 0;

        public DijkstraPair(int vtx, int wsf, String psf, int noE) {
            this.vtx = vtx;
            this.wsf = wsf;
            this.psf = psf;
            this.noE = noE;
        }

        @Override
        public int compareTo(DijkstraPair o) {
            return this.wsf - o.wsf;
        }
    }

    // -----------------dijkstraALGO
    public static void Dijkstra(int src) {

        PriorityQueue<DijkstraPair> pq = new PriorityQueue<>();
        DijkstraPair[] mapping = new DijkstraPair[graph.size()];
        boolean[] isVisited = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {

            DijkstraPair p = new DijkstraPair(i, Integer.MAX_VALUE, "", 0);
            if (i == src) {
                p.wsf = 0;
                p.psf = i + "";
            }
            mapping[i] = p;
            pq.add(p);
        }
        while (!pq.isEmpty()) {
            DijkstraPair rpair = pq.remove();
            isVisited[rpair.vtx] = true;
            for (Edge e : graph.get(rpair.vtx)) {
                if (isVisited[e.v2])
                    continue;
                DijkstraPair oldpair = mapping[e.v2];
                int oldwsf = oldpair.wsf;
                int newwsf = rpair.wsf + e.weight;

                if (newwsf < oldwsf) {
                    DijkstraPair p = new DijkstraPair(e.v2, newwsf, rpair.psf + e.v2, rpair.noE + 1);
                    mapping[e.v2] = p;
                    pq.remove(oldpair);
                    pq.add(p);
                }

            }
        }
    }

    private static class DP implements Comparable<DP> {
        int vtx = 0;
        int wsf = 0;
        String psf = "";
        int nE = 0;

        public DP(int vtx, int wsf, String psf, int nE) {
            this.vtx = vtx;
            this.wsf = wsf;
            this.psf = psf;
            this.nE = nE;
        }

        @Override
        public int compareTo(DP o) {
            return this.wsf - o.wsf;
        }
    }

    public static void dAlgo(int src) {
        PriorityQueue<DP> pq = new PriorityQueue<>();
        DP[] mapping = new DP[graph.size()];
        boolean[] isVisited = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            DP p = new DP(i, Integer.MAX_VALUE, "", 0);

            if (i == src) {
                p.wsf = 0;
                p.psf = i + "";
            }
            mapping[i] = p;
            pq.add(p);
        }

        while (!pq.isEmpty()) {
            DP rpair = pq.remove();
            isVisited[rpair.vtx] = true;

            for (Edge e : graph.get(rpair.vtx)) {
                if (isVisited[e.v2])
                    continue;

                DP oldpair = mapping[e.v2];
                int oldwsf = oldpair.wsf;
                int newwsf = rpair.wsf + e.weight;

                if (newwsf < oldwsf) {
                    DP p = new DP(e.v2, newwsf, rpair.psf, rpair.nE + 1);
                    mapping[e.v2] = p;
                    pq.remove(oldpair);
                    pq.add(p);
                }
            }
        }
    }

}