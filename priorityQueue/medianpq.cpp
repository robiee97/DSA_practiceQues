#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class medianpq
{
private:
    priority_queue<int> left; 
    priority_queue<int, vector<int>, greater<int>> right; //min heap
    void handleBal()
    {
        if (right.size() - left.size() == 2)
        {
            int val = right.top();
            right.pop();
            left.push(val);
        }
        if (left.size() - right.size() == 2)
        {
            int val = left.top();
            left.pop();
            right.push(val);
        }
    }

public:
    void push(int val)
    {
        if (right.size() > 0 && val > right.top())
        {
            right.push(val);
        }
        else
        {
            left.push(val);
        }
        handleBal();
    }
    void pop()
    {
        if (left.size() >= right.size())
        {
            left.pop();
        }
        else
        {
            right.pop();
        }
    }
    int top()
    {
        if (left.size() >= right.size())
        {
            return left.top();
        }
        else
        {
            return right.top();
        }
    }
};

class Point
{
public:
    int li;
    int di;
    int val;

    Point(int li, int di, int val)
    {
        this->li = li;
        this->di = di;
        this->val = val;
    }

    bool operator>(const Point &other) const
    {
        return this->val > other.val;
    }
};

void kMergeSortList(vector<vector<int>> &list)
{
    priority_queue<Point, vector<Point>, greater<Point>> pq;
    for (int i = 0; i < list.size(); i++)
    {
        Point p(i, 0, list[i][0]);
        pq.push(p);
    }
    while (pq.size() > 0)
    {
        Point r = pq.top();
        pq.pop();
        cout << r.val << " ";

        r.di++;
        if (r.di < list[r.li].size())
        {
            r.val = list[r.li][r.di];
            pq.push(r);
        }
    }
}

void almostSortedList(vector<int> &list, int k)
{
    priority_queue<int, vector<int>, greater<int>> pq;

    for (int i = 0; i <= k; i++)
    {
        pq.push(list[i]);
    }
    for (int i = k + 1; i < list.size(); i++)
    {
        cout << pq.top() << " ";
        pq.pop();
        pq.push(list[i]);
    }

    while (pq.size() > 0)
    {
        cout << pq.top() << " ";
        pq.pop();
    }
}

int main(int argc, char **argv)
{
    // medianpq pq;

    // pq.push(20);
    // pq.push(5);
    // pq.push(3);
    // pq.push(17);
    // pq.push(8);

    // cout<<pq.top()<<endl;
    // pq.pop();
    // cout<<pq.top()<<endl;

    // vector<vector<int>> list{
    //     {2, 9, 19, 35},
    //     {1, 5, 7, 12},
    //     {6, 14, 49, 54, 66, 77},
    //     {4, 20}};
    // kMergeSortList(list);

    vector<int> list{5, 14, 2, 8, 15, 25, 35, 20, 40, 50, 42};
    almostSortedList(list, 2);
}