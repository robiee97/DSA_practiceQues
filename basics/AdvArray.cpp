#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void equiliArr(vector<int> &arr)
{
    int sum = 0;
    for (int i : arr)
    {
        sum += i;
    }
    sum -= arr[0];
    int leftSum = arr[0];
    for (int i = 1; i < arr.size() - 1; i++)
    {
        sum -= arr[i];
        if (leftSum == sum)
        {
            cout << "equil attained at " << i;
        }
        else
        {
            leftSum += arr[i];
        }
    }
}

void maximumWaterCapacity(vector<int> &arr)
{
    int maxAns = 0;
    int left = 0;
    int right = arr.size() - 1;
    while (left < right)
    {
        int width = right - left;
        int height = arr[left];
        if (arr[left] < arr[right])
        {
            height = arr[left];
            left++;
        }
        else
        {
            height = arr[right];
            right--;
        }
        int potentialAns = height * width;
        maxAns = max(maxAns, potentialAns);
    }
    cout << maxAns;
}
int main(int args, char **argv)
{
    // vector<int> arr={-7,1,5,2,-4,3,0};
    // equiliArr(arr);
    vector<int> arr = {3, 1, 2, 4, 5};
    maximumWaterCapacity(arr);
    return 0;
}