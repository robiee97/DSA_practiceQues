#include<iostream>
using namespace std;


void printDecreasing(int n ){
        if(n==0){
            return;
        }     
        cout<<n<<endl;
        printDecreasing(n-1);
}

void printIncreasing(int n){
    if(n==0){
        return;
    }
    printIncreasing(n-1);
    cout<<n<<endl;
}

void PDI(int n){

    if(n==0){
        return;
    }
    cout<<n<<endl;
    PDI(n-1);
    cout<<n<<endl;
}

int fact(int n){
if(n==0){
    return 1;
}
    int a= fact(n-1);
    int b= n*a;

    return b;
}
int power(int x, int n){
    if(n==0){
        return 1;
    }
    
    int xpnm1= power(x,n-1);
    int xpn= x*xpnm1;
    return xpn;
}

void printOdd(int n){
if(n==0){
    return;
}
printOdd(n-1);
if(n%2!=0){
    cout<<n<<endl;
    }
}


void printOddEven(int n, int tar){
if(n>tar)
    return;

if(n%2!=0){
    cout<<n<<endl;
    } 

printOddEven(n + 1, tar);

if(n%2==0){
    cout<<n<<endl;
    } 
}

int main()
{
  int n;
  cin>>n;
//   printDecreasing(n);  
//   printIncreasing(n);
// PDI(n);
// cout<<fact(n);
// cout<<power(5,4);
// printOdd(n);
printOddEven(n,10);
return 0;
} 

