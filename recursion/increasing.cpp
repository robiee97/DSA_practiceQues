#include <iostream>
using namespace std;

void increasing(int n)
{
    if (n == 0)
    {
        return;
    }
    increasing(n - 1);
    cout << n << " ";
}
void decreasing(int n)
{
    if (n == 0)
    {
        return;
    }
    cout << n << " ";
    decreasing(n - 1);
}
void IDV1(int n)
{
    if (n == 0)
    {
        return;
    }
    cout << n << " ";
    IDV1(n - 1);
    cout << n << " ";
}
void IDV2(int n)
{
    if (n == 1)
    {
        cout << n << " ";
        return;
    }
    cout << n << " ";
    IDV2(n - 1);
    cout << n << " ";
}

int main()
{
    increasing(10);
    cout << endl;
    decreasing(10);
    cout << endl;
    IDV1(10);
    cout << endl;
    IDV2(10);
    cout << endl;
    return 0;
}
