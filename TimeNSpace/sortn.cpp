#include<bits/stdc++.h>
using namespace std;

void countsort(vector<int> &arr){
	int n = arr.size();
	int r = 10;
	vector<int> fm(r,0);

	for(int val : arr){
		fm[val]++;
	}

	for(int i = 1; i < arr.size(); i++){
		fm[i] += fm[i - 1];
	}

	vector<int> output(n,0);

	for(int i = arr.size() - 1; i >= 0; i--){
		int val=arr[i];
		fm[val]--;
		output[fm[val]]=val;
	}
	
	for(int i : output){
		cout<< i << " ";  
	}
}
int main(){
	vector<int> arr={2,3,9,4,7,2,1,9,3,4,7,8,2,1,3,4,7,2,3,1};
	countsort(arr);
}
