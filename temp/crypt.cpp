#include <iostream>
#include <vector>
using namespace std;

//=========================crypto=========================//

int getNum(string &str, vector<int> freqMap)
{
    int num = 0;
    int pow = 1;
    for (int i = str.length() - 1; i >= 0; i--)
    {
        num += freqMap[str[i] - 'a'] * pow;
        pow *= 10;
    }
    return num;
}

bool isvalid(string &str1, string &str2, string str3, vector<int> &freqMap)
{

    int num1 = getNum(str1, freqMap);
    int num2 = getNum(str2, freqMap);
    int num3 = getNum(str3, freqMap);

    int strt1 = freqMap[str1[0] - 'a'];
    int strt2 = freqMap[str2[0] - 'a'];
    int strt3 = freqMap[str3[0] - 'a'];

    if (strt1 != 0 && strt2 != 0 && strt3 != 0 && num1 + num2 == num3)
    {

        cout << "   "<<num1<< endl << " + " <<"  " <<num2 << endl << " = " << num3;
        return true;
    }

    return false;
}
int cryptArithmatic(string str, string &str1, string &str2, string &str3, vector<bool> &numMap, vector<int> &freqMap)
{
    if (str.length() == 0)
    {
        if (isvalid(str1, str2, str3, freqMap))
        {
            return 1;
        }
        return 0;
    }

    int counter = 0;
    char ch = str[0];
    for (int i = 0; i <= 9; i++)
    {
        if (!numMap[i])
        {
            numMap[i] = true;
            freqMap[ch - 'a'] = i;

            counter += cryptArithmatic(str.substr(1), str1, str2, str3, numMap, freqMap);

            numMap[i] = false;
            freqMap[ch - 'a'] = 0;
        }
    }
    return counter;
}

void crypto()
{
    string str1 = "kansas";
    string str2 = "ohio";
    string str3 = "oregon";

    vector<int> freqMap(26, 0);

    for (int i = 0; i < str3.length(); i++)
    {
        if (i < str1.length())
        {
            freqMap[str1[i] - 'a']++;
        }

        if (i < str2.length())
        {
            freqMap[str2[i] - 'a']++;
        }
        freqMap[str3[i] - 'a']++;
    }

    string str = "";
    for (int i = 0; i < 26; i++)
    {
        if (freqMap[i] > 0)
        {
            str += (char)(i + 'a');
        }
    }
    //string demnorsy

    vector<bool> numMap(10, false);

     cryptArithmatic(str, str1, str2, str3, numMap, freqMap);
}

//+++++++++++++++++++++++++CROSSWORD+++++++++++++++++++++++++++//

// bool canPlaceHori(vector<vector<char>>, string &word, int r, int c)
// {

// }
// int placeHori(vector<vector<char>>, string &word, int r, int c)
// {
// }
// int unPlaceHori(vector<vector<char>>, string &word, int r, int c)
// {
// }
// bool canPlaceVert(vector<vector<char>>, string &word, int r, int c)
// {
// }
// int placeVerti(vector<vector<char>>, string &word, int r, int c)
// {
// }
// int unPlaceVerti(vector<vector<char>>, string &word, int r, int c)
// {
// }

int main()
{
    crypto();
    return 0;
}