#include <iostream>
#include <vector>
#include <string>
using namespace std;

int targetSum(vector<int> &arr, int vidx, int target, string ans)
{
    if (vidx == arr.size() || target == 0)
    {
        int rval = 0;
        if (target == 0)
        {
            for (int i : ans)
                cout << i << endl;
            rval = 1;
        }
        return rval;
    }

    int count = 0;
    count += targetSum(arr, vidx + 1, target, ans);
    ans.push_back(arr[vidx]);                                                                // not contributing
    count += targetSum(arr, vidx + 1, target - arr[vidx], ans + to_string(arr[vidx]) + " "); // contributing
    ans.push_back(arr[vidx]);
    return count;
}

int equili(vector<int> &arr, int vidx, int set1sum, string set1, int set2sum, string set2)
{
    if (vidx == arr.size()-1)
    {
        if(set1sum == set2sum){
            cout << set1 << " = " << set2;
            return 1;
        }
    return 0;
    }

    int count = 0;
    count += equili(arr, vidx + 1, set1sum + arr[vidx], set1 + to_string(arr[vidx]), set2sum, set2);
    count += equili(arr, vidx + 1, set1sum, set1, set2sum + arr[vidx], set2 + to_string(arr[vidx]));
    return count;
}

int main()
{
    vector<int> arr{1,2,3,4,5,6,7,8,9,0};
    equili(arr, 0, 0, 0, 0, 0);
    return 0;
}