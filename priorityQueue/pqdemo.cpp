#include <iostream>
#include <queue>
#include <vector>

using namespace std;

void printksmallest(vector<int> &nums, int k)
{
    priority_queue<int> pq; //max heap

    for (int i = 0; i < k; i++)
    {
        pq.push(nums[i]);
    }

    for (int i = k; i < nums.size(); i++)
    {
        if (nums[i] < pq.top())
        {
            pq.pop();
            pq.push(nums[i]);
        }
    }
    while (pq.size() > 0)
    {
        int val = pq.top();
        pq.pop();
        cout << val;
    }
}
void downheapify(vector<int> &pq, int idx, int ve)
{
    int lci = 2 * idx + 1;
    int rci = lci + 1;
    int hpi = idx;
    if (lci <= ve && pq[lci] > pq[hpi])
    {
        hpi = lci;
    }
    if (rci <= ve && pq[rci] > pq[hpi])
    {
        hpi = rci;
    }
    if (hpi != idx)
    {
        swap(pq[idx], pq[hpi]);
        downheapify(pq, hpi, ve);
    }
}
void heapSort(vector<int> &arr)
{
    for (int i = arr.size() / 2 - 1; i >= 0; i--)
    {
        downheapify(arr, i, arr.size() - 1);
    }
    for (int i = 1; i <= arr.size() - 1; i++)
    {
        swap(arr[0], arr[arr.size() - i]);
        downheapify(arr, 0, arr.size() - i - 1);
    }
}

int main(int argv, char **argc)
{
    vector<int> arr{2, 9, 3, 8, 17, 6, 4, 12, 7, 15, 10, 5};
    // printksmallest(arr, 4);
    heapSort(arr);

    for (int i = 0; i < arr.size(); i++)
    {
        cout << arr[i] << " ";
    }
}