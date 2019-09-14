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
    list<Node *> stack;
    Node *root = NULL;
    for (int i = 0; i < arr.size(); i++)
    {
        if (arr[i] == -1)
        {
            stack.pop_front();
        }
        else
        {
            Node *node = new Node(arr[i]);
            if (stack.size() == 0)
            {
                root = node;
            }
            else
            {
                stack.front().child.push_front(node);
            }
            stack.push_front(node);
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
    vector<int> arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
    Node *ans = gtree(arr);
    cout << findEle(ans, 10);
    cout << MinNo(ans);
    cout << MaxNo(ans);
    return 0;
}
// push_front(),push_back(),pop_back(),pop_front(),.front(),.back()