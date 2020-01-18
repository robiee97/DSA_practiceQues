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
vector<vector<Edge>> astronautG;

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
string gscc(vector<vector<Edge>> &g, int root, vector<bool> &isv)
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

        for (int n = 0; n < g[rem].size(); n++)
        {
            Edge ne = g[rem][n];
            if (isv[ne.nbr] == false)
            {
                q.push(ne.nbr);
            }
        }
    }
    return comp;
}

vector<string> gcc(vector<vector<Edge>> &g)
{
    vector<bool> isv(g.size(), false);
    vector<string> ans;

    for (int i = 0; i < g.size(); i++)
    {
        if (isv[i] == false)
        {
            string myAns = gscc(g, i, isv);
            ans.push_back(myAns);
        }
    }
    return ans;
}
bool isConnected(vector<vector<Edge>> &g)
{
    vector<bool> isv(g.size(), false);
    int counter = 0;
    for (int i = 0; i < g.size(); i++)
    {
        if (isv[i] == false)
        {
            gscc(g, i, isv);
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

void astronaut(int n, vector<int> &v1, vector<int> &v2)
{
    for (int v = 0; v < n; v++)
    {
        astronautG.push_back(vector<Edge>());
    }

    for (int i = 0; i < v1.size(); i++)
    {
        addEdge(astronautG, v1[i], v2[i], 1);
    }

    int teams = 0;
    vector<string> nations = gcc(astronautG);

    for (int n1 = 0; n1 < nations.size(); n1++)
    {
        for (int n2 = n1 + 1; n2 < nations.size(); n2++)
        {
            teams += nations[n1].size() * nations[n2].size();
        }
    }
    cout << teams << " ";
}

bool isSafeForIs(vector<vector<int>> &mat, int i, int j)
{
    if (i < 0 || i >= mat.size() || j < 0 || j >= mat[0].size())
    {
        return false;
    }
    else if (mat[i][j] == -1)
    {
        return false;
    }
    else if (mat[i][j] > 0)
    {
        return false;
    }
    else
    {
        return true;
    }
}
class Ihelper
{
public:
    int i;
    int j;
    Ihelper(int i, int j)
    {
        this->i = i;
        this->j = j;
    }
};
void getIslandComp(vector<vector<int>> &mat, int i, int j, int count)
{
    queue<Ihelper> q;
    q.push(Ihelper(i, j));

    while (q.size() > 0)
    {
        Ihelper rem = q.front();
        q.pop();

        if (mat[rem.i][rem.j] > 0)
        {
            continue;
        }
        else
        {
            mat[rem.i][rem.j] = count + 1;
        }

        if (isSafeForIs(mat, rem.i + 1, rem.j))
        {
            q.push(Ihelper(rem.i + 1, rem.j));
        }
        if (isSafeForIs(mat, rem.i - 1, rem.j))
        {
            q.push(Ihelper(rem.i - 1, rem.j));
        }
        if (isSafeForIs(mat, rem.i, rem.j + 1))
        {
            q.push(Ihelper(rem.i, rem.j + 1));
        }
        if (isSafeForIs(mat, rem.i, rem.j - 1))
        {
            q.push(Ihelper(rem.i, rem.j - 1));
        }
    }
}
void island(vector<vector<int>> &mat)
{
    int count = 0;
    for (int i = 0; i < mat.size(); i++)
    {
        for (int j = 0; j < mat[0].size(); j++)
        {
            if (mat[i][j] == 0)
            {
                getIslandComp(mat, i, j, count);
                count++;
            }
        }
    }
    for (int i = 0; i < mat.size(); i++)
    {
        for (int j = 0; j < mat[0].size(); j++)
        {
            if (mat[i][j] == -1)
            {
                cout << "X ";
            }
            else
            {
                cout << mat[i][j] << " ";
            }
        }
        cout << endl;
    }
    cout << count;
}

bool isValLoc(vector<vector<int>> &city, int i, int j)
{
    if (i < 0 || i >= city.size() || j < 0 || j >= city[0].size())
    {
        return false;
    }
    else if (city[i][j] == -1)
    {
        return false;
    }
    else if (city[i][j] >= 0)
    {
        return false;
    }
    else
    {
        return true;
    }
}
class fireHelper
{
public:
    int i;
    int j;
    int t;
    fireHelper(int i, int j, int t)
    {
        this->i = i;
        this->j = j;
        this->t = t;
    }
};
void fireCity(vector<vector<int>> &city)
{
    queue<fireHelper> q;
    for (int i = 0; i < city.size(); i++)
    {
        for (int j = 0; j < city.size(); j++)
        {
            if (city[i][j] == 0)
            {
                q.push(fireHelper(i, j, 0));
            }
        }
    }

    while (q.size() > 0)
    {
        fireHelper rem = q.front();
        q.pop();

        if (city[rem.i][rem.j] > 0)
        {
            continue;
        }
        else
        {
            city[rem.i][rem.j] = rem.t;
        }

        cout << rem.i << rem.j << " Burns @ " << rem.t << endl;

        if (isValLoc(city, rem.i + 1, rem.j))
        {
            q.push(fireHelper(rem.i + 1, rem.j, rem.t + 1));
        }

        if (isValLoc(city, rem.i - 1, rem.j))
        {
            q.push(fireHelper(rem.i - 1, rem.j, rem.t + 1));
        }

        if (isValLoc(city, rem.i, rem.j + 1))
        {
            q.push(fireHelper(rem.i, rem.j + 1, rem.t + 1));
        }

        if (isValLoc(city, rem.i, rem.j - 1))
        {
            q.push(fireHelper(rem.i, rem.j - 1, rem.t + 1));
        }
    }
    for (int i = 0; i < city.size(); i++)
    {
        for (int j = 0; j < city[0].size(); j++)
        {
            cout << city[i][j] << "\t";
        }
        cout << endl;
    }
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

class BEdge
{
public:
    int v1;
    int v2;
    int wt;

    BEdge(int v1, int v2, int wt)
    {
        this->v1 = v1;
        this->v2 = v2;
        this->wt = wt;
    }
};

void bellmanFord(vector<vector<Edge>> &graph)
{
    vector<BEdge> resG(graph.size(), BEdge(0, 0, 0));
    for (int v = 0; v < graph.size(); v++)
    {
        for (int e = 0; e < graph[v].size(); e++)
        {
            Edge ne = graph[v][e];
            BEdge p(v, ne.nbr, ne.wt);
            resG.push_back(p);
        }
    }
    vector<int> res(graph.size(), INT_MAX);
    res[0] = 0;

    for (int i = 0; i < graph.size() - 1; i++) // Passes |V-1| times
    {
        for (int j = 0; j < resG.size(); j++) // for each edge
        {
            BEdge be = resG[j];
            if (res[be.v1] != INT_MAX && res[be.v1] + be.wt < res[be.v2]) // relaxation condn.
            {
                res[be.v2] = res[be.v1] + be.wt; // relaxing
            }
        }
    }
    for (int j = 0; j < resG.size(); j++) //if one more time it relaxes than |V-1|
    {
        BEdge ce = resG[j];
        if (res[ce.v1] != INT_MAX && res[ce.v1] + ce.wt < res[ce.v2]) // we have to abort the process
        {
            cout << "NEGATIVE CYCLE"; // bcz its in negative cycle
            return;
        }
    }
    for (int i : res)
    {
        cout << i << " ";
    }
}

void floydWarshall(vector<vector<Edge>> &graph)
{
    int res[graph.size()][graph.size()];

    for (int v = 0; v < graph.size(); v++)
    {
        for (int e = 0; e < graph[v].size(); e++)
        {
            res[v][e] = INT_MAX;
        }
    }

    for (int i = 0; i < graph.size(); i++)
    {
        res[i][i] = 0;
        for (int j = 0; j < graph[i].size(); j++)
        {
            Edge ne = graph[i][j];
            res[i][ne.nbr] = ne.wt;
        }
    }

    for (int k = 0; k < graph.size(); k++)
    {
        for (int i = 0; i < graph.size(); i++)
        {
            for (int j = 0; j < graph.size(); j++)
            {
                if (i == j || k == i || k == j)
                {
                    continue;
                }
                else if (res[i][j] == INT_MAX || res[k][j] == INT_MAX)
                {
                    continue;
                }
                else
                {
                    if (res[i][k] + res[k][j] < res[i][j])
                    {
                        res[i][j] = res[i][k] + res[k][j];
                    }
                }
            }
        }
    }
    for (int i = 0; i < graph.size(); i++)
    {
        for (int j = 0; j < graph.size(); j++)
        {
            if (res[i][j] == INT_MAX)
            {
                cout << "X ";
            }
            cout << res[i][j] << " ";
        }
        cout << endl;
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
    // cout<<gscc(graph,0,isv);
    // vector<string> comp = gcc(graph);
    // for(string s:comp){
    //     cout<<s<<", ";
    // }
    // cout<<isConnected();
    // cout<<isCyclic();
    // int n = 10;
    // vector<int> v1{9, 5, 2, 3, 6, 1};
    // vector<int> v2{4, 3, 0, 7, 8, 4};
    // astronaut(n, v1, v2);
    
    // vector<vector<int>> isl = {
    //         {0,  0, -1,  0,  0},
    //         {0, -1, -1, -1, -1},
    //         {-1, 0,  0,  0,  0},
    //         {0, -1,  0, -1,  0},
    //         {0, -1, -1, -1,  0}
    //     };
    // island(isl);

    // vector<vector<int>> city = {
    //     {-2, -2, 0, -2, -2, -2},
    //     {-2, -1, -1, -2, -1, -1},
    //     {-2, -2, -1, -2, -2, -2},
    //     {-2, -2, -2, -2, -1, -1},
    //     {-2, -1, -1, 0, -2, -2}};
    // fireCity(city);

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

    // for (int i = 0; i < 4; i++)
    // {
    //     graph.push_back(vector<Edge>());
    // }
    // addEdge(graph, 0, 1, 2);
    // addEdge(graph, 0, 2, 4);
    // addEdge(graph, 0, 3, 8);
    // addEdge(graph, 1, 2, 1);
    // addEdge(graph, 1, 3, 5);
    // addEdge(graph, 2, 3, 1);

    // bellmanFord(graph);
    // floydWarshall(graph);
}