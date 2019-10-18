#include <iostream>
using namespace std;

void fun1()
{
    static int i = 100;
    int j = 200;

    i++;
    j++;

    cout << i << " " << j << endl;
}

void fun2()
{
    static int i = 10;
    int j = 20;

    i++;
    j++;

    cout << i << " " << j << endl;
}

int main()
{
    fun1();
    fun2();
    fun1();
    fun2();
}