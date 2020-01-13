#include<bits/stdc++.h>
using namespace std;
int part(vector<int>&arr,int lo,int hi){
	int pivot=arr[hi];

	int i=0;
	int j=0;

	while(i<=hi){
		if(arr[i]>pivot){
			i++;
		}
		else {
			swap(arr[i],arr[j]);
			i++;
			j++;
		}
	}	
	return j-1;
}

void quicksort(vector<int>& arr,int lo,int hi){
	if(lo>=hi){
		return;
	}
	int pidx=part(arr,lo,hi);
	quicksort(arr,lo,pidx - 1);
	quicksort(arr,pidx + 1,hi);
}

int main(){
	vector<int> arr={2,1,5,6,7,8,3,4};
	quicksort(arr,0,arr.size()-1);
	for(auto i:arr){
		cout<<i<<" ";
	}
}

