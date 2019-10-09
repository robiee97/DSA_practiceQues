#include <iostream>
#include <vector>
#include <string>
#include <list>

using namespace std;
class Edge
{
public:
    int v1;
    int v2;
    int wt;

    Edge(int v1, int v2, int wt)
    {
        this->v1 = v1;
        this->v2 = v2;
        this->wt = wt;
    }
};
class Mypr
{
public:
    int wsf = 0;
    string psf = "";
    Mypr(int wsf, string psf)
    {
        this->wsf = wsf;
        this->psf = psf;
    }
};

class Mypr2
{
public:
    int wsf = 0;
    string psf = "";
    int noOfEdges = 0;
    Mypr2(int wsf, string psf, int noOfEdges)
    {
        this->wsf = wsf;
        this->psf = psf;
        this->noOfEdges = noOfEdges;
    }
};
class BFSPair
{
public:
    int vtx = 0;
    int wsf = 0;
    string psf = "";
    int noofE = 0;
    BFSPair(int vtx, int wsf, string psf, int noofE)
    {
        this->vtx = vtx;
        this->wsf = wsf;
        this->psf = psf;
        this->noofE = noofE;
    }
};

vector<vector<Edge *>> graph;

int getIdx(int v1, int v2)
{
    for (int i = 0; i < graph[v1].size(); i++)
    {
        if (graph[v1][i]->v2 == v2)
        {
            return i;
        }
    }
    return -1;
}
void addVertex(int v1)
{
    if (graph.size() == v1)
    {
        vector<Edge *> inGraph;
        graph.push_back(inGraph);
    }
}
void addEdge(int v1, int v2, int wt)
{
    if (v1 < graph.size() && v2 < graph.size())
    {
        graph[v1].push_back(new Edge(v1, v2, wt));
        graph[v2].push_back(new Edge(v2, v1, wt));
    }
}
void removeEdge(int v1, int v2)
{
    int idx1 = getIdx(v1, v2);
    if (idx1 != -1)
    {
        graph[v1].erase(graph[v1].begin() + idx1);
    }
    int idx2 = getIdx(v2, v1);
    if (idx2 != -1)
    {
        graph[v2].erase(graph[v2].begin() + idx2);
    }
}

void removeVertex(int v1, int v2)
{
    for (Edge *e : graph[v1])
    {
        int idx = getIdx(e->v2, v2);
        graph[e->v2].erase(graph[e->v2].begin() + idx);
    }
    graph[v1].erase(graph[v1].begin() + v1);
}

void hasPath()
{
    vector<bool> isVisited(graph.size());
    hasPath(0, 6, isVisited);
}
bool hasPath(int src, int dest, vector<bool> isVisited)
{
    if (src == dest)
    {
        cout << src;
        return true;
    }
    isVisited[src] = true;
    for (Edge *e : graph[src])
    {
        if (isVisited[e->v2])
            continue;

        bool ans = hasPath(e->v2, dest, isVisited);
        if (ans)
        {
            return true;
        }
    }
    return false;
}

int allPaths(int src, int dest, vector<bool> isVisited)
{
    if (src == dest)
    {
        cout << src;
        return 1;
    }
    int count = 0;
    isVisited[src] = true;
    for (Edge *e : graph[src])
    {
        if (isVisited[e->v2])
            continue;
        count += hasPath(e->v2, dest, isVisited);
    }

    isVisited[src] = false;
    return count;
}
Mypr *minWtPath(int src, int dest, vector<bool> isVisited)
{
    if (src == dest)
    {
        Mypr *base = new Mypr(0, to_string(src));
        return base;
    }
    Mypr *myAns = new Mypr(1000, "");
    isVisited[src] = true;
    for (Edge *e : graph[src])
    {
        if (isVisited[e->v2])
            continue;
        Mypr *recAns = minWtPath(e->v2, dest, isVisited);
        if (recAns->wsf + e->wt < myAns->wsf)
        {
            myAns->wsf = recAns->wsf + e->wt;
            myAns->psf = to_string(src) + recAns->psf;
        }
    }
    isVisited[src] = false;
    return myAns;
}
Mypr2 *shortestPath(int src, int dest, vector<bool> isVisited)
{
    if (src == dest)
    {
        Mypr2 *base = new Mypr2(0, to_string(src), 0);
        return base;
    }
    Mypr2 *myAns = new Mypr2(0, "", 1000);
    isVisited[src] = true;
    for (Edge *e : graph[src])
    {
        if (isVisited[e->v2])
            continue;
        Mypr2 *recAns = shortestPath(e->v2, dest, isVisited);
        if (recAns->noOfEdges + 1 < myAns->noOfEdges)
        {
            myAns->wsf = recAns->wsf + e->wt;
            myAns->psf = to_string(src) + recAns->psf;
            myAns->noOfEdges = recAns->noOfEdges + 1;
        }
    }
    isVisited[src] = false;
}

void BFS(int src, int desti, vector<bool> &isVisited)
{

    list<BFSPair> que;
    BFSPair p(0, 0, "", 0);
    que.push_back(p);

    BFSPair rpair = que.front();
    que.pop_front();

    if (isVisited[rpair.vtx])
    {
        cout << "cycle" << rpair.vtx << "via" << rpair.psf;
    }

    isVisited[rpair.vtx] = true;

    if (rpair.vtx == desti)
    {
        cout << "destination";
        // return;
    }

    for (Edge *e : graph[rpair.vtx])
    {
        if (!isVisited[e->v2])
        {
            que.push_back(BFSPair(e->v2, rpair.wsf + e->wt, rpair.psf + to_string(e->v2), rpair.noofE + 1));
        }
    }
}

void BFTcomp()
{
    int comp = 0;
    vector<bool> isVisited(graph.size(), false);

    for (int i = 0; i < graph.size(); i++)
    {
        if (!isVisited[i])
        {
            BFS(i, 6, isVisited);
            cout << endl;
            comp++;
        }
    }
    cout << comp;
}

void DFSrec(int src, vector<bool> &isVisited, string psf)
{
    isVisited[src] = true;
    cout << src << " via " << psf;

    for (Edge *e : graph[src])
    {
        if (!isVisited[e->v2])
        {
            DFSrec(e->v2, isVisited, psf + to_string(e->v2));
        }
    }
    isVisited[src] = false;
}
void DFTcomp()
{
    int comp = 0;
    string psf = "";
    vector<bool> isVisited(graph.size(), false);

    for (int i = 0; i < graph.size(); i++)
    {
        if (!isVisited[i])
        {
            DFSrec(i, isVisited, psf);
            cout << endl;
            comp++;
        }
    }
    cout << comp;
}
void display()
{
}
void solve()
{
    for (int i = 0; i < 7; i++)
    {
        addVertex(i);
    }
    addEdge(0, 0, 0);
    addEdge(0, 0, 0);
    addEdge(0, 0, 0);
    addEdge(0, 0, 0);
    addEdge(0, 0, 0);
    addEdge(0, 0, 0);
    addEdge(0, 0, 0);
    addEdge(0, 0, 0);
    addEdge(0, 0, 0);
    addEdge(0, 0, 0);
    addEdge(0, 0, 0);

    display();
    hasPath();
    // minWtPath();
}

int main()
{
    solve();
    return 0;
}