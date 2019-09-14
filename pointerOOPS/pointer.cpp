#include<iostream>
using namespace std;

void caseII_(){
    cout<<caseII();
}

int *caseII(){
    int var=10;
    return &var;
}

void stackId(int idx){
    if(idx==2){
        return;
    }
    cout<<&idx<<endl;
    stackId(idx+1);
}

int main(){
    // caseII_();
    stackId(0);
    return 0;
}
