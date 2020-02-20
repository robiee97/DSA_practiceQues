#include <bits/stdc++.h>
using namespace std;

int p[10000];

string newString(string &s)
{
    string ns = "@";
    for (int i = 0; i < s.size(); i++)
    {
        ns += "#" + s.substr(i, 1);
    }
    ns += "#$";
    return ns;
}

string longestPallindromeSusbtring(string &s)
{
    string ns = newString(s);
    int c = 0;
    int r = 0;
    for (int i = 1; i < ns.size() - 1; i++)
    {
        int iM = c - (i - c);

        if (r > i)
        {
            p[i] = min(r - i, p[iM]);
        }
        while (ns[i + 1 + p[i]] == ns[i - 1 - p[i]])
        {
            p[i]++;
        }

        if (i + 1 > r)
        {
            c = i;
            r = i + p[i];
        }
    }

    int maxPal = 0;
    int centerInd = 0;

    for (int i = 1; i < ns.size() - 1; i++)
    {
        if (p[i] > maxPal)
        {
            maxPal = p[i];
            centerInd = i;
        }
    }
    cout << maxPal << "\n";
    return s.substr((centerInd - 1 - maxPal) / 2, maxPal);
}

int main(int argc, char **argv)
{
    string s = "ababababasbsbabbabbsbabbbabab";
    cout << longestPallindromeSusbtring(s);
}