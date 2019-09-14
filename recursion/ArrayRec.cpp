#include<iostream>
#include<vector>
#include<climits>
#include<algorithm>
using namespace std;

void display(vector<int> &arr, int vidx){
    if(vidx==arr.size()-1){
        return;
    }
    cout<<arr[vidx]<<" ";
    display(arr,vidx+1);
    }
int maxArr(vector<int> &arr,int vidx){
    if(vidx==arr.size()){
        return INT_MIN;

    }
    int faithMax = maxArr(arr,vidx+1);
    int actualMax= max(faithMax,arr[vidx]);

    return actualMax;
}

int minArr(vector<int> &arr,int vidx){
if(vidx==arr.size()){
        return INT_MAX;

    }
    int faithMin = minArr(arr,vidx+1);
    int actualMin= min(faithMin,arr[vidx]);

    return actualMin;
}
int findArr(vector<int> &arr, int data,int vidx){
if(vidx==arr.size()-1){
    return vidx;
}

    if(arr[vidx]==data){
        return -1;
    }
    int ans= findArr(arr,data,vidx+1);

    return ans;
}

vector<int> allIndex(vector<int> &arr, int data,int vidx,int count){
if(vidx==arr.size()){
    vector<int> base(count,0);
    return base;
}

if(arr[vidx]==data){
    count++;
}
vector<int> smallAns = allIndex(arr,data,vidx+1,count);
if(arr[vidx]==data){
    smallAns[count-1]=vidx;
}
return smallAns;
}

int lastIndex(vector<int> &arr ,int data,int vidx){
if(vidx==arr.size()-1){
    return vidx;
}
    int last = lastIndex(arr,data,vidx+1);
    if(arr[vidx]==data){
        return vidx;
    }
    return last;

}

void inverseArr(vector<int> &arr, int vidx){
if(vidx==arr.size()){
    return;
    }
    int data= arr[vidx];
    inverseArr(arr,vidx+1);
    arr[data] = vidx;
    
}

int main(int args, char** argv){
    vector<int> arr ={10,20,30,30,20,10,10};
    int vidx=0;
    // display(arr,vidx);
    // maxArr(arr);
    // cout<<findArr(arr,20,vidx);
    // cout<<maxArr(arr,vidx);
    // cout<<minArr(arr,vidx);
    // cout<<lastIndex(arr,10,vidx);
    vector<int> arr2={1,2,0,3};

    // for(int i: arr2){
    //     cout<<i<<" ";
    // }

    inverseArr(arr2,vidx);
    for(int i:arr2){
        cout<<i<<" ";
    }
    return 0;
}