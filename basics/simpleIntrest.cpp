#include<iostream>
using namespace std;

int main(){
    int p,r,t;
    cout<<"Enter the principle value";
    cin>>p;
    cout<<"Enter the rate value";
    cin>>r;
    cout<<"Enter the time value";
    cin>>t;

    int si =  (p*r*t)/100;
    cout<<"SIMPLE INTREST IS:"<<si;

    return 0;
}