#include <iostream>
#include <vector>
#include <string>
#include <climits>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;
class Edge
{
public:
    int nbr;
    int wt;

    Edge(int nbr, int wt)
    {
        this->nbr = nbr;
        this->wt = wt;
    }
};
vector<vector<Edge>> graph;
vector<vector<Edge>> dag;

void addEdge(vector<vector<Edge>> &g, int v1, int v2, int wt)
{
    Edge e1(v2, wt);
    g[v1].push_back(e1);

    Edge e2(v1, wt);
    g[v2].push_back(e2);
}

void addEdgeDir(vector<vector<Edge>> &g, int v1, int v2, int wt)
{
    Edge e1(v2, wt);
    g[v1].push_back(e1);
}

void display(vector<vector<Edge>> &g)
{
    for (int v = 0; v < g.size(); v++)
    {
        cout << v << "->";

        for (int e = 0; e < g[v].size(); e++)
        {
            Edge ne = g[v][e];
            cout << ne.nbr << "-" << ne.wt << ",";
        }
        cout << "." << endl;
    }
}

bool haspath(int s, int d, vector<bool> &isv)
{
    if (s == d)
    {
        return true;
    }
    isv[s] = true;
    for (int n = 0; n < graph[s].size(); n++)
    {
        Edge ne = graph[s][n];
        if (!isv[ne.nbr])
        {
            bool ans = haspath(ne.nbr, d, isv);
            if (ans)
            {
                return true;
            }
        }
    }
    return false;
}
int sd = INT_MAX;
string sdp;
int ld = INT_MIN;
string ldp;

int cd = INT_MAX;
string cp;
int fd = INT_MIN;
string fp;

void printallPaths(int s, int d, vector<bool> &isv, string &psf, int dsf, int factor)
{
    if (s == d)
    {
        cout << psf + to_string(d) << "@" << dsf << endl;
        if (dsf < sd)
        {
            sd = dsf;
            sdp = psf + to_string(d);
        }
        if (dsf > ld)
        {
            ld = dsf;
            ldp = psf + to_string(d);
        }
        if (dsf > factor)
        {
            cd = min(cd, dsf);
            cp = psf + to_string(d);
        }
        if (dsf < factor)
        {
            fd = max(fd, dsf);
            fp = psf + to_string(d);
        }
        return;
    }
    isv[s] = true;
    for (int n = 0; n < graph[s].size(); n++)
    {
        Edge ne = graph[s][n];
        if (!isv[ne.nbr])
        {
            psf += to_string(s);
            printallPaths(ne.nbr, d, isv, psf, dsf + ne.wt, factor);
            psf.erase(psf.length() - 1, 1);
        }
    }
    isv[s] = false;
}
void hamiltonianPnC(int s, vector<bool> &isv, int csf, string psf, int os)
{
    if (csf == graph.size() - 1)
    {

        psf = psf + to_string(s);
        cout << psf;

        for (int n = 0; n < graph[s].size(); n++)
        {
            Edge ne = graph[s][n];
            if (ne.nbr == os)
            {
                cout << "*" << endl;
                return;
            }
        }
        cout << "." << endl;
        return;
    }

    isv[s] = true;
    for (int n = 0; n < graph[s].size(); n++)
    {
        Edge ne = graph[s][n];
        if (!isv[ne.nbr])
        {
            hamiltonianPnC(ne.nbr, isv, csf + 1, psf + to_string(s), os);
        }
    }
    isv[s] = false;
}

bool bfs(int s, int d)
{
    vector<bool> isV(graph.size(), false);
    queue<int> q;

    q.push(s);
    while (q.size() > 0)
    {
        int rem = q.front();
        q.pop();

        if (isV[rem] == true)
        {
            continue;
        }
        isV[rem] = true;
        if (rem == d)
        {
            return true;
        }

        for (int n = 0; n < graph[rem].size(); n++)
        {
            Edge ne = graph[rem][n];
            if (isV[ne.nbr] == false)
            {
                q.push(ne.nbr);
            }
        }
    }
    return false;
}
string gscc(int root, vector<bool> &isv)
{
    string comp = "";
    queue<int> q;

    q.push(root);
    while (q.size() > 0)
    {
        int rem = q.front();
        q.pop();

        if (isv[rem] == true)
        {
            continue;
        }
        isv[rem] = true;
        comp += to_string(rem);

        for (int n = 0; n < graph[rem].size(); n++)
        {
            Edge ne = graph[rem][n];
            if (isv[ne.nbr] == false)
            {
                q.push(ne.nbr);
            }
        }
    }
    return comp;
}

vector<string> gcc()
{
    vector<bool> isv(graph.size(), false);
    vector<string> ans;

    for (int i = 0; i < graph.size(); i++)
    {
        if (isv[i] == false)
        {
            string myAns = gscc(i, isv);
            ans.push_back(myAns);
        }
    }
    return ans;
}
bool isConnected()
{
    vector<bool> isv(graph.size(), false);
    int counter = 0;
    for (int i = 0; i < graph.size(); i++)
    {
        if (isv[i] == false)
        {
            gscc(i, isv);
            counter++;
            if (counter == 2)
            {
                return false;
            }
        }
    }
    return true;
}

bool isComCyclic(int root, vector<bool> &isv)
{
    queue<int> q;
    q.push(root);
    while (q.size() > 0)
    {
        int rem = q.front();
        q.pop();
        if (isv[rem] == true)
        {
            return true;
        }
        isv[rem] = true;
        for (int n = 0; n < graph[rem].size(); n++)
        {
            Edge ne = graph[rem][n];
            if (isv[ne.nbr] == false)
            {
                q.push(ne.nbr);
            }
        }
    }
    return false;
}
bool isCyclic()
{
    vector<bool> isv(graph.size(), false);
    for (int i = 0; i < graph.size(); i++)
    {
        if (isv[i] == false)
        {
            bool isC = isComCyclic(i, isv);
            if (isC)
            {
                return true;
            }
        }
    }
    return false;
}
class BiPair
{
public:
    int v;
    int l;
};

bool isBiComp(int root, vector<int> isv)
{
    queue<BiPair> q;
    BiPair bp;
    bp.v = root;
    bp.l = 1;
    q.push(bp);

    while (q.size() > 0)
    {
        BiPair rem = q.front();
        q.pop();

        if (isv[rem.v] != 0)
        {
            int ol = isv[rem.v];
            int nl = rem.l;

            if (ol % 2 != nl % 2)
            {
                return false;
            }
        }
        isv[rem.v] = rem.l;

        for (int n = 0; n < graph[rem.v].size(); n++)
        {
            Edge ne = graph[rem.v][n];
            if (isv[ne.nbr] == 0)
            {
                BiPair np;
                np.l = rem.l + 1;
                np.v = ne.nbr;
                q.push(np);
            }
        }
    }
    return true;
}

bool isBipirtite()
{
    vector<int> isv(graph.size(), 0);
    for (int i = 0; i < graph.size(); i++)
    {
        if (isv[i] == 0)
        {
            bool ans = isBiComp(i, isv);
            if (!ans)
            {
                return false;
            }
        }
    }
    return true;
}
class Dpair
{
public:
    int v;
    int c;
    string p;

    // bool operator<(const Dpair& o) const
    // {
    //     return this->c < o.c;
    // }

    bool operator>(const Dpair &o) const
    {
        return this->c > o.c;
    }
};

void djikstra(int s)
{
    priority_queue<Dpair, vector<Dpair>, greater<Dpair>> q;
    vector<bool> isvisited(graph.size(), false);

    Dpair dp;
    dp.v = s;
    dp.c = 0;
    dp.p = "";
    q.push(dp);

    while (q.size() > 0)
    {
        Dpair rem = q.top();
        q.pop();

        if (isvisited[rem.v])
        {
            continue;
        }
        isvisited[rem.v] = true;
        cout << rem.v << " v i a " << rem.p << " @ " << rem.c << endl;

        for (int n = 0; n < graph[rem.v].size(); n++)
        {
            Edge ne = graph[rem.v][n];
            if (!isvisited[ne.nbr])
            {
                Dpair np;
                np.v = ne.nbr;
                np.c = rem.c + ne.wt;
                np.p = rem.p + to_string(ne.nbr);
                q.push(np);
            }
        }
    }
}
class PPair
{
public:
    int v;
    int av;
    int c;
    PPair()
    {
    }
    PPair(int v, int av, int c)
    {
        this->v = v;
        this->av = av;
        this->c = c;
    }

    bool operator>(const PPair &o) const
    {
        return this->c > o.c;
    }
};
void prims()
{
    vector<vector<Edge>> mst(graph.size(), vector<Edge>());
    priority_queue<PPair, vector<PPair>, greater<PPair>> q;
    vector<bool> isv(graph.size(), false);
    PPair pp(0, -1, 0);
    q.push(pp);

    while (q.size() > 0)
    {
        PPair rem = q.top();
        q.pop();

        if (isv[rem.v] == true)
        {
            continue;
        }
        isv[rem.v] = true;
        if (rem.av != -1)
        {
            addEdge(mst, rem.v, rem.av, rem.c);
        }
        for (int n = 0; n < graph[rem.v].size(); n++)
        {
            Edge ne = graph[rem.v][n];
            if (isv[ne.nbr] == false)
            {
                PPair np(ne.nbr, rem.v, ne.wt);
                q.push(np);
            }
        }
    }
    display(mst);
}

void topologicalComp(vector<bool> &isv, stack<int> &st, int v)
{
    isv[v] = true;
    for (int n = 0; n < dag[v].size(); n++)
    {
        Edge ne = dag[v][n];
        if (isv[ne.nbr] == false)
        {
            topologicalComp(isv, st, ne.nbr);
        }
    }
    st.push(v);
}

void topologicalSort()
{
    vector<bool> isv(dag.size(), false);
    stack<int> st;
    for (int v = 0; v < dag.size(); v++)
    {
        if (isv[v] == false)
        {
            topologicalComp(isv, st, v);
        }
    }
    while (st.size() > 0)
    {
        cout << st.top() << " ";
        st.pop();
    }
}

int main(int argc, char **argv)
{
    // graph.push_back(vector<Edge>());
    // graph.push_back(vector<Edge>());
    // graph.push_back(vector<Edge>());
    // graph.push_back(vector<Edge>());
    // graph.push_back(vector<Edge>());
    // graph.push_back(vector<Edge>());
    // graph.push_back(vector<Edge>());

    // addEdge(graph, 0, 1, 10);
    // addEdge(graph, 1, 2, 10);
    // addEdge(graph, 2, 3, 10);
    // addEdge(graph, 0, 3, 40);
    // addEdge(graph, 3, 4, 2);
    // addEdge(graph, 4, 5, 3);
    // addEdge(graph, 5, 6, 3);
    // addEdge(graph, 4, 6, 8);
    // addEdge(2, 5, 5);
    // display();
    // vector<bool> isv(7, false);
    // cout<<haspath(0,6,isv);
    // string s;
    // printallPaths(0, 6, isv, s, 0, 45);
    // cout<<"Smallest path "<<sd<<" @ "<<sdp<<endl;
    // cout<<"largest path "<<ld<<" @ "<<ldp<<endl;
    // cout<<"ceil path "<<cd<<" @ "<<cp<<endl;
    // cout<<"floor path "<<fd<<" @ "<<fp<<endl;
    // hamiltonianPnC(0,isv,0,"",0);
    // cout<<bfs(0,6);
    // cout<<gscc(0,isv);
    // vector<string> comp = gcc();
    // for(string s:comp){
    //     cout<<s<<", ";
    // }
    // cout<<isConnected();
    // cout<<isCyclic();
    // cout<<isBipirtite();
    // djikstra(0);
    // prims();

    // dag.push_back(vector<Edge>());
    // dag.push_back(vector<Edge>());
    // dag.push_back(vector<Edge>());
    // dag.push_back(vector<Edge>());
    // dag.push_back(vector<Edge>());
    // dag.push_back(vector<Edge>());
    // dag.push_back(vector<Edge>());

    // addEdgeDir(dag,0,1,1);
    // addEdgeDir(dag,1,2,1);
    // addEdgeDir(dag,2,3,1);
    // addEdgeDir(dag,0,4,1);
    // addEdgeDir(dag,4,3,1);
    // addEdgeDir(dag,5,4,1);
    // addEdgeDir(dag,5,6,1);
    // addEdgeDir(dag,6,3,1);
    // topologicalSort();
}