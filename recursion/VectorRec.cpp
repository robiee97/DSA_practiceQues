#include <iostream>
#include <vector>
#include <string>
using namespace std;

vector<string> Maze(int sr, int sc, int er, int ec)
{
    if (sr == er && sc == ec)
    {
        vector<string> base;
        base.push_back("");
        return base;
    }
    vector<string> myAns;

    if (sc + 1 <= ec)
    {
        vector<string> horizontal = Maze(sr, sc + 1, er, ec);
        for (string smallAns : horizontal)
        {
            string realAns = "H" + smallAns;
            myAns.push_back(realAns);
        }
    }

    if (sr + 1 <= er)
    {
        vector<string> vertical = Maze(sr + 1, sc, er, ec);
        for (string smallAns : vertical)
        {
            string realAns = "V" + smallAns;
            myAns.push_back(realAns);
        }
    }
    return myAns;
}

vector<string> steps(int si, int ei)
{
    if (si == ei)
    {
        vector<string> base;
        base.push_back("");
        return base;
    }

    vector<string> myAns;

    for (int i = 1; i <= 6 && si + i <= ei; i++)
    {
        vector<string> smallAns = steps(si + i, ei);
        for (string s : smallAns)
        {
            myAns.push_back(to_string(i) + s);
            // counter++;
        }
    }
    return myAns;
}

string getCode(int digit)
{
    string arr[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wx", "yz", "*+#"};
    return arr[digit];
}

vector<string> keypad(int num)
{
    if (num == 0)
    {
        vector<string> base;
        base.push_back("");
        return base;
    }

    int digit = num % 10;
    num /= 10;
    vector<string> myAns;
    vector<string> smallAns = keypad(num);
    string s = getCode(digit);
    for (int i = 0; i < s.length(); i++)
    {
        for (string str : smallAns)
        {
            myAns.push_back(str + s[i]);
        }
    }
    return myAns;
}
int main()
{

    // vector<string> ans = Maze(0, 0, 2, 2);

    // for (string s : ans)
    // {
    //     cout << s << " ";
    // }

    // vector<string> ans=steps(0,10);
    // for(string s:ans){
    //     cout<<s<<" ";
    // }
    // cout<<ans.size();

    int no = 123;
    vector<string> ans = keypad(no);
    for (string s : ans)
    {
        cout << s << " ";
    }
    return 0;
}