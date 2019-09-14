#include<iostream>
using namespace std;

int main(){
    int n;
    bool flag=false;
    cout<<"enter a no.";
    cin>>n;
    for(int i=2; i*i<n; i++){
        if(n%i==0){
            flag=true;
            break;
        }
    }
        if(flag==true){
            cout<<n<<"No is not prime";
        }else{
            cout<<n<<"No is prime";
        }
    return 0;
}