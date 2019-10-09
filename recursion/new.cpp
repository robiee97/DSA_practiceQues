#include<bits/stdc++.h>
using namespace std;

bool canPlaceHorizontal(vector<vector<char>> &box, string &word, int r, int c)
{
    if (c + word.length() > box[0].size())
    {
        return false;
    }
    if (c - 1 >= 0 && box[r][c - 1] != '+')
        return false;

    if (c + word.length() < box[0].size() && box[r][c + word.length()] != '+')
    {
        return false;
    }

    for (int i = 0; i < word.length(); i++)
    {
        char ch = box[r][c + i];
        if (ch != '-' && ch != word[i])
        {
            return false;
        }
    }
    return true;
}

vector<bool> placeHorizontal(vector<vector<char>> &box, string &word, int r, int c)
{
    vector<bool> placedLocation(word.length(), false);
    for (int i = 0; i < word.length(); i++)
    {
        char ch = box[r][c + i];
        if (ch == '-')
        {
            box[r][c + i] = word[i];
            placedLocation[i] = true;
        }
    }

    return placedLocation;
}

void unPlaceHorizontal(vector<vector<char>> &box, vector<bool> &placedLocation, int r, int c)
{
    for (int i = 0; i < placedLocation.size(); i++)
    {
        if (placedLocation[i])
        {
            box[r][c + i] = '-';
            placedLocation[i] = false;
        }
    }
}

bool canPlaceVertical(vector<vector<char>> &box, string &word, int r, int c)
{
    if (r + word.length() > box.size())
        return false;
    if (r - 1 >= 0 && box[r - 1][c] != '+')
        return false;

    if (r + word.length() < box.size() && box[r + word.length()][c] != '+')
        return false;

    for (int i = 0; i < word.length(); i++)
    {
        char ch = box[r + i][c];
        if (ch != '-' && ch != word[i])
        {
            return false;
        }
    }
    return true;
}

vector<bool> placeVertical(vector<vector<char>> &box, string &word, int r, int c)
{
    vector<bool> placedLocation(word.length(), false);
    for (int i = 0; i < word.length(); i++)
    {
        char ch = box[r + i][c];
        if (ch == '-')
        {
            box[r + i][c] = word[i];
            placedLocation[i] = true;
        }
    }

    return placedLocation;
}

void unPlaceVertical(vector<vector<char>> &box, vector<bool> &placedLocation, int r, int c)
{
    for (int i = 0; i < placedLocation.size(); i++)
    {
        if (placedLocation[i])
        {
            box[r + i][c] = '-';
            placedLocation[i] = false;
        }
    }
}

int crossWordUtil(vector<vector<char>> &box, vector<string> &words, int idx)
{
    if (idx == words.size())
    {

        for (int i = 0; i < box.size(); i++)
        {
            for (int j = 0; j < box[0].size(); j++)
            {
                cout << box[i][j] << " ";
            }
            cout << endl;
        }

        return 1;
    }
    string word = words[idx];
    int count = 0;

    for (int i = 0; i < box.size(); i++)
    {
        for (int j = 0; j < box[0].size(); j++)
        {
            if (box[i][j] == '-' || box[i][j] == word[0])
            {
                //horizontal
                if (canPlaceHorizontal(box, word, i, j))
                {
                    vector<bool> placedLocation = placeHorizontal(box, word, i, j);
                    count += crossWordUtil(box, words, idx + 1);
                    unPlaceHorizontal(box, placedLocation, i, j);
                }

                //vertical
                if (canPlaceVertical(box, word, i, j))
                {
                    vector<bool> placedLocation = placeVertical(box, word, i, j);
                    count += crossWordUtil(box, words, idx + 1);
                    unPlaceVertical(box, placedLocation, i, j);
                }
            }
        }
    }
    return count;
}

void crossWord()
{

    vector<vector<char>> boards = {
        {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
        {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
        {'+', '-', '-', '-', '-', '-', '-', '-', '+', '+'},
        {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
        {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
        {'+', '-', '-', '-', '-', '-', '-', '+', '+', '+'},
        {'+', '-', '+', '+', '+', '-', '+', '+', '+', '+'},
        {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
        {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
        {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+'}};

    vector<string> words = {"agra", "norway", "england", "gwal2ior"};
    cout << crossWordUtil(boards, words, 0) << endl;
}

//===========================================================================================================
bool isvalid(vector<vector<bool>> &chess, int r, int c)
{
    if (r < 0 || c < 0 || r >= chess.size() || c >= chess.size())
    {
        return false;
    }
    return true;
}

bool isValidLocforQueen(vector<vector<bool>> &chess, int r, int c)
{
    int dir[8][2] = {{0, 1},
                     {1, 0},
                     {0, -1},
                     {-1, 0},
                     {1, 1},
                     {-1, 1},
                     {1, -1},
                     {-1, -1}};

    for (int rad = 1; rad < chess.size(); rad++)
    {
        for (int dirItr = 0; dirItr < 8; dirItr++)
        {
            int nr = r + rad * dir[dirItr][0];
            int nc = c + rad * dir[dirItr][1];
            if (isvalid(chess, nr, nc) || chess[nr][nc])
            {
                return false;
            }
        }
    }
    return true;
}

int nQueen(vector<vector<bool>> &chess, int idx, int tnq, int qpsf, string asf)
{
    if (tnq == qpsf)
    {
        cout << asf << endl;
        return 1;
    }
    int counter = 0;
    for (int b = idx; b < chess.size() * chess.size(); b++)
    {
        int r = b / chess[0].size();
        int c = b % chess[0].size();
        if (!chess[r][c] && isValidLocforQueen(chess, r, c))
        {
            chess[r][c] = true;
            counter += nQueen(chess, b + 1, tnq, qpsf + 1, asf + " Q " + to_string(b) + " B " + to_string(b));
            chess[r][c] = false;
        }
    }
    return counter;
}

int main()
{
     vector<vector<bool>> chess(4, vector<bool>(4, false));
    nQueen(chess, 0, 4, 0, "");
    return 0;
}