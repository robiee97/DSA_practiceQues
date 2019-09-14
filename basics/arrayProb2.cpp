#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main()
{
    vector<int> arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int tar = 12;
    sort(arr.begin(), arr.end());

    int left = 0;
    int right = arr.size() - 1;

    while (left < right)
    {
        int sum = arr[left] + arr[right];
        if (sum == tar)
        {
            cout << "(" << arr[left] << "," << arr[right] << ")";
            left++;
            while (left < right && arr[left] == arr[left - 1])
            {
                left++;
            }
            right--;
            while (left < right && arr[right] == arr[right + 1])
            {
                right--;
            }
        }
        else if (sum < tar)
        {
            left++;
        }
        else
        {
            right++;
        }
    }
    return 0;
}