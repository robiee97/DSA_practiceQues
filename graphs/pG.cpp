#include <iostream>
#include <vector>
#include <string>
#include <climits>
#include <cmath>
#include <queue>

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

void addEdge(int v1, int v2, int wt)
{
    Edge e1(v2, wt);
    graph[v1].push_back(e1);

    Edge e2(v1, wt);
    graph[v2].push_back(e2);
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

void display()
{
    for (int v = 0; v < graph.size(); v++)
    {
        cout << v << "->";

        for (int e = 0; e < graph[v].size(); e++)
        {
            Edge ne = graph[v][e];
            cout << ne.nbr << "-" << ne.wt << ",";
        }
        cout << "." << endl;
    }
}

int main(int argc, char **argv)
{
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());

    addEdge(0, 1, 10);
    addEdge(1, 2, 10);
    addEdge(2, 3, 10);
    addEdge(0, 3, 40);
    addEdge(3, 4, 2);
    addEdge(4, 5, 3);
    addEdge(5, 6, 3);
    addEdge(4, 6, 8);
    // addEdge(2, 5, 5);
    // display();
    vector<bool> isv(7, false);
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
}