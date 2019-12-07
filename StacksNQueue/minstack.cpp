/*
MINSTACK USING tWO STACKS
*/

#include<iostream>
#include<stack>

using namespace std;

class MinStack {
private:
    stack<int> vs;
    stack<int> ms;
public:
    MinStack(): vs(), ms() {}

    void push(int x) {
        vs.push(x);
        if (ms.empty() || x <= ms.top()) {
            ms.push(x);
        }
    }

    void pop() {
        if (vs.top() == ms.top()) {
            ms.pop();
        }
        vs.pop();
    }

    int top() {  return vs.top(); }
    int getMin() { return ms.top(); }
};
int main(){
    MinStack ms;
    ms.push(512);
    ms.push(-1024);
    ms.push(-1024);
    ms.push(512);

    ms.pop();cout<<ms.getMin()<<endl;
    ms.pop();cout<<ms.getMin()<<endl;
    ms.pop();cout<<ms.getMin()<<endl;
}
