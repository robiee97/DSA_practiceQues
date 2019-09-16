#include <iostream>
#include <stack>
#include <vector>
#include <cmath>
using namespace std;

bool hasDupBrack(string &exp)
{
    stack<char> st;
    for (int i = 0; i < exp.size(); i++)
    {
        if (exp[i] == ')')
        {
            if (st.top() == '(')
            {
                return true;
            }
            else
            {
                while (st.top() != '(')
                {
                    st.pop();
                    st.pop();
                }
            }
        }
        else
        {
            st.push(exp[i]);
        }
    }
    return false;
}

bool balancedBrackets(string &exp)
{

    stack<char> st;
    for (int i = 0; i < exp.size(); i++)
    {
        if (exp[i] == '(' || exp[i] == '{' || exp[i] == '[')
        {
            st.push(exp[i]);
        }
        else if (exp[i] == ')')
        {
            if (st.size() == 0 || st.top() != '(')
            {
                return false;
            }
            else
            {
                st.pop();
            }
        }
        else if (exp[i] == '}')
        {
            if (st.size() == 0 || st.top() != '{')
            {
                return false;
            }
            else
            {
                st.pop();
            }
        }
        else if (exp[i] == ']')
        {
            if (st.size() == 0 || st.top() != '[')
            {
                return false;
            }
            else
            {
                st.pop();
            }
        }
    }
    if (st.size() > 0)
    {
        return false;
    }
    else
    {
        return true;
    }
}

vector<int> nge1(vector<int> &arr)
{
    vector<int> res(arr.size());
    stack<int> st;
    for (int i = 0; i < arr.size(); i++)
    {
        while (st.size() > 0 && arr[st.top()] < arr[i])
        {
            res[st.top()] = arr[i];
            st.pop();
        }
        st.push(i);
    }
    while (st.size() > 0)
    {
        res[st.top()] = -1;
        st.pop();
    }
    return res;
}

vector<int> nge2(vector<int> &arr)
{
    vector<int> res(arr.size());
    stack<int> st;
    res[arr.size() - 1] = -1;
    st.push(arr[arr.size() - 1]);

    for (int i = arr.size() - 2; i >= 0; i--)
    {
        while (st.size() > 0 && arr[i] > st.top())
            st.pop();

        res[i] = st.size() == 0 ? -1 : st.top();
        st.push(arr[i]);
    }

    return res;
}

int LAH(vector<int> &arr)
{
    vector<int> rb(arr.size());
    vector<int> lb(arr.size());

    stack<int> st;
    for (int i = 0; i < arr.size(); i++)
    {
        while (st.size() > 0 && arr[st.top()] > arr[i])
        {
            rb[st.top()] = i;
            st.pop();
        }
        st.push(i);
    }
    while (st.size() > 0)
    {
        rb[st.top()] = arr.size();
        st.pop();
    }
    for (int i = arr.size() - 1; i >= 0; i--)
    {
        while (st.size() > 0 && arr[st.top()] > arr[i])
        {
            lb[st.top()] = i;
            st.pop();
        }
        st.push(i);
    }
    while (st.size() > 0)
    {
        lb[st.top()] = -1;
        st.pop();
    }
    int max = 0;
    for (int i = 0; i < arr.size(); i++)
    {
        int width = rb[i] - lb[i] - 1;
        int area = arr[i] * width;

        if (area > max)
        {
            max = area;
        }
    }
    return max;
}

vector<int> maxInSW(vector<int> &arr, int k)
{
    vector<int> nge(arr.size());
    stack<int> st;
    for (int i = 0; i < arr.size(); i++)
    {
        while (st.size() > 0 && arr[st.top()] < arr[i])
        {
            nge[st.top()] = i;
            st.pop();
        }
        st.push(i);
    }
    while (st.size() > 0)
    {
        nge[st.top()] = arr.size();
        st.pop();
    }

    int i = 0;
    int j = 0;

    vector<int> res(arr.size() - k + 1);
    while (i < res.size())
    {
        if (i > j)
        {
            j = i;
        }

        while (nge[j] < i + k)
        {
            j = nge[j];
        }
        res[i] = arr[j];
        i++;
    }
    return res;
}

void didiid(string str)
{
    int val = 1;
    stack<int> st;
    for (int i = 0; i <= str.length(); i++)
    {
        st.push(val++);
        if (i == str.length() || str[i] == 'i')
        {
            // st.push(val++);
            while (st.size() > 0)
            {
                int c = st.top();
                cout << c << " ";
                st.pop();
            }
        }
    }
}

int getpriority(char op)
{
    switch (op)
    {
    case '+':
    case '-':
        return 1;
        break;

    case '*':
    case '/':
    case '%':
        return 2;
        break;

    case '^':
        return 3;
        break;

    default:
        break;
    }
}
int getvalue(int v1, int v2, char op)
{
    switch (op)
    {
    case '+':
        return v1 + v2;
        break;

    case '-':
        return v1 - v2;
        break;

    case '*':
        return v1 * v2;
        break;

    case '/':
        return v1 / v2;
        break;

    case '%':
        return v1 % v2;
        break;

    case '^':
        return pow(v1, v2);
        break;

    default:
        break;
    }
}

int infix123(string exp)
{

    stack<char> os;
    stack<int> vs;

    for (int i = 0; i < exp.length(); i++)
    {
        char ch = exp[i];
        if (ch >= '0' && ch <= '9')
        {
            vs.push(ch - 48);
        }
        else if (ch == '(')
        {
            os.push(ch);
        }
        else if (ch == ')')
        {
            while (os.top() != '(')
            {
                int v2 = vs.top();
                vs.pop();
                int v1 = vs.top();
                vs.pop();
                char op = os.top();
                os.pop();
                int res = getvalue(v1, v2, op);
                vs.push(res);
            }
            os.pop();
        }
        else
        {
            while (os.size() > 0 && os.top() != '(' && getpriority(os.top()) >= getpriority(ch))
            {
                int v2 = vs.top();
                vs.pop();
                int v1 = vs.top();
                vs.pop();
                char op = os.top();
                os.pop();
                int res = getvalue(v1, v2, op);
                vs.push(res);
            }
            os.push(ch);
        }
    }
    while (os.size() != 0)
    {
        int v2 = vs.top();
        vs.pop();
        int v1 = vs.top();
        vs.pop();
        char op = os.top();
        os.pop();
        int res = getvalue(v1, v2, op);
        vs.push(res);
    }
    return vs.top();
}

int main(int argc, char **argv)
{
    // string exp = "(a+((b+c+(d+e))))";
    // cout << hasDupBrack(exp) << endl;
    // string exp = "[a+{b+c+(d+e)}]";
    // cout << balancedBrackets(exp) << endl;
    // vector<int> arr{5,9,8,3,2,7,16,4,14,19,3};
    // vector<int> res=nge1(arr);
    // for(int i=0;i<res.size();i++){
    //     cout<<res[i]<<" ";
    // }
    // vector<int> arr{6, 2, 5, 4, 5, 1, 6};
    // cout << LAH(arr);

    // vector<int> arr{5, 9, 3, 1, 8, 6, 7, 2, 11, 4, 17, 9};
    // vector<int> res = maxInSW(arr, 5);

    // for (int i = 0; i < res.size(); i++)
    // {
    //     cout << res[i] << " ";
    // }
    // string arr="";
    // string arr = "dddddddd";
    // didiid(arr);

    string exp = "8+3^(4/(3-2))";
    cout << infix123(exp);
}