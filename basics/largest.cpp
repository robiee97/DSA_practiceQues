#include<iostream>
using namespace std;

int main(){
int a,b,c;
cout<<"Enter three no";
cin>>a>>b>>c;

if(a>b && a>c){
    cout<<a<<"is largest";
}

else if(b>c && b>a){
    cout<<b<<"is largest";
}

else{
    cout<<c<<"is largest";
}
    return 0;
}