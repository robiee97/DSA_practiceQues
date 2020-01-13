#include <bits/stdc++.h>
using namespace std;

vector<int> countsort(vector<int> &arr)
{
	int n = arr.size();
	int r = 10;
	vector<int> fm(r, 0);

	for (int val : arr)
	{
		fm[val]++;
	}

	for (int i = 1; i < arr.size(); i++)
	{
		fm[i] += fm[i - 1];
	}

	vector<int> output(n, 0);

	for (int i = arr.size() - 1; i >= 0; i--)
	{
		int val = arr[i];
		fm[val]--;
		output[fm[val]] = val;
	}
	return output;
}

vector<int> csForRadixSort(vector<int> arr, int div)
{
	int n = arr.size();
	int r = 10;
	vector<int> fm(r, 0);

	for (int val : arr)
	{
		val = val / div % 10;
		fm[val]++;
	}
	for (int i = 1; i < arr.size(); i++)
	{
		fm[i] += fm[i - 1];
	}
	vector<int> output(n, 0);
	for (int i = arr.size() - 1; i >= 0; i--)
	{
		int val = arr[i];
		val = val / div % 10;
		fm[val]--;
		output[fm[val]] = arr[i];
	}
	return output;
}
vector<int> radixsort(vector<int> arr)
{
	int mx = 0;
	for (int i : arr)
	{
		mx = max(mx, i);
	}
	int div = 1;
	while (mx / div > 0)
	{
		arr = csForRadixSort(arr, div);
		div = div * 10;
	}
	return arr;
}

int main()
{
	// vector<int> arr={2,3,9,4,7,2,1,9,3,4,7,8,2,1,3,4,7,2,3,1};
	// countsort(arr);
	// vector<int> arr = {321, 990, 6, 2842, 185, 71, 809, 14, 73, 25, 7, 3, 72, 32, 8};
	// vector<int> sa = radixsort(arr);
	// for(int i:sa){
	// 	cout<<i<<" ";
	// }
}
