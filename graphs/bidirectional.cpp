#include <iostream>
#include <vector>
#include <string>

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
class Mypair
{
public:
    int wsf = 0;
    string psf = "";
    Mypair(int wsf, string psf)
    {
        this->wsf = wsf;
        this->psf = psf;
    }
};
class MyEpair
{
public:
    int wsf = 0;
    string psf = "";
    int noOfE = 0;
    MyEpair(int wsf, string psf, int noOfE)
    {
        this->wsf = wsf;
        this->psf = psf;
        this->noOfE = noOfE;
    }
};

vector<vector<Edge *>> graph;
//getIdx
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
//addVertex
void addVertex(int v1)
{
    if (graph.size() == v1)
    {
        vector<Edge *> innergraph;
        graph.push_back(innergraph);
    }
}
//rmVertex
void removeVertex(int v1)
{
    for (Edge *e : graph[v1])
    {
        int idx = getIdx(e->v2, v1);
        graph[e->v2].erase(graph[e->v2].begin() + idx);
    }
    graph.erase(graph.begin() + v1);
}

//addEdges
void addEdges(int v1, int v2, int wt)
{
    if (v1 < graph.size() && v2 < graph.size())
    {

        graph[v1].push_back(new Edge(v1, v2, wt));
        graph[v2].push_back(new Edge(v2, v1, wt));
    }
}
//rmEdge
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

void display()
{
    string sb = "";
    for (int i = 0; i < graph.size(); i++)
    {
        for (Edge *e : graph[i])
        {
            sb += "(" + to_string(e->v1) + "," + to_string(e->v2) + ")" + " @" + to_string(e->wt) + " ";
        }
        sb += "\n";
    }
    cout << sb << endl;
}
void solve()
{
    for (int i = 0; i < 7; i++)
    {
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
    vector<bool> isVisited([graph.size()], false);
    Mypair *p = minwtPath(0, 6, isVisited);
    cout << p->wsf << p->psf;
}

//sw
Mypair *minwtPath(int src, int desti, vector<bool> isVisited)
{
    if (src == desti)
    {
        Mypair *p = new Mypair(0, to_string(src));
        return p;
    }
    Mypair *myAns = new Mypair(10000, "");

    isVisited[src] = true;
    for (Edge *e : graph[src])
    {
        if (isVisited[e->v2])
            continue;

        Mypair *recAns = minwtPath(e->v2, desti, isVisited);
        if (recAns->wsf + e->wt < myAns->wsf)
        {
            myAns->wsf = recAns->wsf + e->wt;
            myAns->psf = to_string(src) + recAns->psf;
        }
    }

    isVisited[src] = false;
    return myAns;
}
//sp
MyEpair *shortestPath(int src, int desti, vector<bool> isVisited)
{
    if (src == desti)
    {
        MyEpair *p = new MyEpair(0, to_string(src), 0);
        return p;
    }
    MyEpair *myAns = new MyEpair(0, "", 1000000);

    isVisited[src] = true;
    for (Edge *e : graph[src])
    {
        if (isVisited[e->v2])
            continue;

        MyEpair *recAns = shortestPath(e->v2, desti, isVisited);
        if (recAns->noOfE + 1 < myAns->noOfE)
        {
            myAns->wsf = recAns->wsf + e->wt;
            myAns->psf = to_string(src) + recAns->psf;
            myAns->noOfE = recAns->noOfE + 1;
        }
    }

    isVisited[src] = false;
    return myAns;
}

int main()
{

    solve();

    return 0;
}