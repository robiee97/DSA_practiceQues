#include<bits\stdc++.h>
using namespace std;
void swapArr(vector<int>&arr, int i, int j){
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}

void bubbleSort(vector<int>&arr){
	int j = 1;
	while(j < arr.size()){
		for(int i = 0; i < arr.size() - j; i++){
			if(arr[i] > arr[i + 1]){
				swapArr(arr, i, i + 1);
			}
		}
		j++;
	}
	for(auto i : arr){
		cout<< i <<" ";
	}
}

void selectionSort(vector<int>&arr){
	int j = 1;
	while(j < arr.size()){
		for(int i = j; i < arr.size(); i++){
			if(arr[i] < arr[j - 1]){
				swapArr(arr, i, j - 1);
			}
		}
		j++;
	}
	for(auto i : arr){
		cout<< i <<" ";
	}
}

void insertionSort(vector<int>&arr){
	int j = 1;
	while(j < arr.size()){
		for(int i = j; i > 0; i--){
			if(arr[i] < arr[i - 1]){
				swapArr(arr, i, i - 1);
			}
			else{
				break;
			}
		}
		j++;
	}
	for(auto i : arr){
		cout<< i <<" ";
	}
}


int main(){
	vector<int> arr = {9, 2, 0, 38, 95, 9, 82, 3, 705, 98};
	// bubbleSort(arr);
	// selectionSort(arr);
	insertionSort(arr);
}
