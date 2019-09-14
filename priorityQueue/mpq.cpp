#include <iostream>
#include <vector>
using namespace std;
class mpq
{
private:
    vector<int> list;
    bool minormax;
    void upheapify(int idx)
    {
        if (idx == 0)
        {
            return;
        }
        int pi = (idx - 1) / 2;
        if (isHightPriority(idx, pi))
        {
            swap(list[idx], list[pi]);
            upheapify(pi);
        }
    }
    void downheapify(int idx)
    {
        int lci = 2 * idx + 1;
        int rci = lci + 1;
        int hpi = idx;
        if (lci < list.size() && isHightPriority(lci, hpi))
        {
            hpi = lci;
        }
        if (rci < list.size() && isHightPriority(rci, hpi))
        {
            hpi = rci;
        }
        if (hpi != idx)
        {
            swap(list[idx], list[hpi]);
            downheapify(hpi);
        }
    }
    bool isHightPriority(int i, int j)
    {
        if (minormax == true)
        {
            return list[i] < list[j];
        }
        else
        {
            return list[i] > list[j];
        }
    }

public:
    mpq(bool minormax)
    {
        this->minormax = minormax;
    }

    mpq(bool minormax,vector<int>& data){
        this->minormax = minormax;
        for(int i=0;i<data.size();i++){
            list.push_back(data[i]);
        }
        for(int i=data.size()/2-1;i>=0;i--){
            downheapify(i);
        }

    }
    void push(int val)
    {
        list.push_back(val);
        upheapify(list.size() - 1);
    }
    void pop()
    {
        swap(list[0], list[list.size() - 1]);
        list.pop_back();
        downheapify(0);
    }
    int top()
    {
        return list[0];
    }
    int size()
    {
        return list.size();
    }
};
int main(int argc, char **argv)
{
vector<int> data{10,50,40,90,60,30,20,80};
    mpq m(false,data);

    while (m.size() > 0)
    {
        cout << m.top() << " ";
        m.pop();
    }
}