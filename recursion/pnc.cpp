#include <iostream>
#include <string>
#include <vector>

using namespace std;

int coinChangePer(vector<int> &arr, int tar, string ans)
{
    if (tar == 0)
    {
        cout << ans << endl;
        return 1;
    }
    int count = 0;
    for (int i = 0; i < arr.size(); i++)
    {
        if (tar - arr[i] >= 0)
        {
            count += coinChangePer(arr, tar - arr[i], ans + to_string(arr[i]) + " ");
        }
    }
    return count;
}

int coinChangeComb(vector<int> &arr, int idx, int tar, string ans)
{
    if (idx == arr.size() || tar == 0)
    {
        if (tar == 0)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count = 0;
    for (int i = idx; i < arr.size(); i++)
    {
        if (tar - arr[i] >= 0)
        {
            count += coinChangeComb(arr, i, tar - arr[i], ans + to_string(arr[i]) + " ");
        }
    }
    return count;
}
int coinChangeComb2(vector<int> &arr, int idx, int tar, string ans)
{
    if (idx == arr.size() || tar == 0)
    {
        if (tar == 0)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count = 0;
    for (int i = idx; i < arr.size(); i++)
    {
        if (tar - arr[i] >= 0)
        {
            count += coinChangeComb2(arr, i + 1, tar - arr[i], ans + to_string(arr[i]) + " ");
        }
    }
    return count;
}

int coinChangePer2(vector<int> &arr, vector<bool> mark, int tar, string ans)
{
    if (tar == 0)
    {
        cout << ans << endl;
        return 1;
    }
    int count = 0;
    for (int i = 0; i < arr.size(); i++)
    {
        if (tar - arr[i] >= 0 && mark[i] == false)
        {
            mark[i] = true;
            count += coinChangePer2(arr, mark, tar - arr[i], ans + to_string(arr[i]) + " ");
            mark[i] = false;
        }
    }
    return count;
}

int coinChangeComb3(vector<int> &arr, int idx, int tar, string ans)
{
    if (idx == arr.size() || tar == 0)
    {
        if (tar == 0)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count = 0;
    if (tar - arr[idx] >= 0)
    {
        count += coinChangeComb3(arr, idx + 1, tar - arr[idx], ans + to_string(arr[idx]) + " "); //for no repeatition
        count += coinChangeComb3(arr, idx + 1, tar, ans);
    }

    return count;
}

int coinChangePer3(vector<int> &arr, int idx, int tar, string ans)
{
    if (tar == 0 || idx == arr.size())
    {
        if (tar == 0)
        {
            cout << ans << endl;
            return 1;
        }
    }
    int count = 0;
    if (tar - arr[idx] >= 0)
    {
        count += coinChangePer3(arr, 0, tar - arr[idx], ans + to_string(arr[idx]) + " ");
        count += coinChangePer3(arr, idx + 1, tar, ans);
    }
    return count;
}
int main()
{

    vector<int> arr = {2, 3, 5};
    coinChangePer(arr, 10, "");
    coinChangeComb(arr, 0, 10, "");
    vector<bool> mark(arr.size(), false);
    coinChangePer2(arr, mark, 10, "");
    coinChangeComb3(arr, 0, 10, "");
    coinChangePer3(arr, 0, 10, "");
    return 0;
}
