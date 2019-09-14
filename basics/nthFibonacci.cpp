#include<iostream>
using namespace std;

int main(){
    int n;
    cout<<"enter no till fibonacci";
    cin>>n;
    int a=0;
    int b=1;
    int c;
    int i=0;
    while(i<n){
        c=a+b;
        a=b;
        b=c;
        i++;
    }
  cout<<a;
    return 0;
}