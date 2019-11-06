#include <iostream>
#include <list>
#include <vector>

using namespace std;

class Node
{
    
public:
    int data = 0;
    vector<Node *> child;
    Node(int data)
    {
        this->data = data;
    }
};

Node* gtree(vector<int> &arr)
{
    list<Node *> st;
    Node *root = NULL;
    for (int i = 0; i < arr.size(); i++)
    {
        if (arr[i] == -1)
        {
            st.pop_front();
        }
        else
        {
            Node *node = new Node(arr[i]);
            if (st.size() == 0)
            {
                root = node;
            }
            else
            {
                st.front()->child.push_back(node);
            }
            st.push_front(node);
        }
    }
    return root;
}

bool findEle(Node *root, int ele)
{
    if (root->data == ele)
    {
        return true;
    }
    for (Node *n : root->child)
    {
        bool ans = findEle(n, ele);
        if (ans)
        {
            return true;
        }
    }
    return false;
}

int MinNo(Node *root)
{
    int minO = root->data;
    for (Node *n : root->child)
    {
        int recAns = MinNo(n);
        minO = min(minO, recAns);
    }
    return minO;
}

int MaxNo(Node *root)
{
    int maxO = root->data;
    for (Node *n : root->child)
    {
        int recAns = MaxNo(n);
        maxO = max(maxO, recAns);
    }
    return maxO;
}

int main()
{
    vector<int> arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 150, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
    Node *ans = gtree(arr);
    cout << findEle(ans, 70)<<endl;
    cout << MinNo(ans)<<endl;
    cout << MaxNo(ans)<<endl;
    return 0;
}
// push_front(),push_back(),pop_back(),pop_front(),.front(),.back()