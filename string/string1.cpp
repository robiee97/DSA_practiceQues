#include <iostream>
#include <vector>
#include <string>
using namespace std;
// int counter=1;
int duplicate()
{
    string str = "AAABCDDDEFGH";
    int counter = 1;
    for (int i = 1; i < str.length() - 1; i++)
    {
        char ch = str[i];
        char pch = str[i - 1];
        if (pch != ch)
        {
            cout << pch << " ";
            if (counter > 1)
                cout << counter << " ";
            counter = 1;
        }
        else
        {
            counter++;
        }
    }
    char lch = str[str.length() - 1];
    cout << lch;
}

int main()
{
    // duplicate();
    return 0;
}