#include<iostream>
using namespace std;

int fibonacci(int n){
    if(n<=1){
        return n;
    }
    int nthMinusOne = fibonacci(n-1);
    int nthMinusTwo = fibonacci(n-2);
    int nth= nthMinusOne + nthMinusTwo;
    return nth;
}
int main(){
    cout<<fibonacci(10);cout<<endl;
    return 0;
}