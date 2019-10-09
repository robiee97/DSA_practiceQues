#include <iostream>
#include <vector>

using namespace std;

int permutation(vector<bool> &box, int tnq, int qpsf, string asf)
{
    if (qpsf == tnq)
    {
        cout << asf << endl;
        return 1;
    }
    int counter = 0;
    for (int b = 0; b < box.size(); b++)
    {
        if (!box[b])
        {
            box[b] = true;
            counter += permutation(box, tnq, qpsf + 1, asf + " Q " + to_string(qpsf + 1) + " B " + to_string(b + 1) + ",");
            box[b] = false;
        }
    }
    return counter;
}
int combination(vector<bool> &box, int idx, int tnq, int qpsf, string asf)
{
    if (qpsf == tnq)
    {
        cout << asf << endl;
        return 1;
    }
    int counter = 0;
    for (int b = idx; b < box.size(); b++)
    {
        if (!box[b])
        {
            box[b] = true;
            counter += combination(box, b + 1, tnq, qpsf + 1, asf + " Q " + to_string(qpsf + 1) + " B " + to_string(b + 1) + ",");
            box[b] = false;
        }
    }
    return counter;
}

//---------------------------NQUEEN-------------------------------------------//

bool isvalid(vector<vector<bool>> &chess, int r, int c)
{
    if (r < 0 || c < 0 || r >= chess.size() || c >= chess[0].size())
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
            if (isvalid(chess, nr, nc) && chess[nr][nc])
            {
                return false;
            }
        }
    }
    return true;
}

int nQueen(vector<vector<bool>> &chess, int idx, int tnq, int qpsf, string asf)
{
    if (qpsf == tnq)
    {
        cout << asf << endl;
        return 1;
    }
    int counter = 0;
    for (int b = idx; b < chess.size() * chess[0].size(); b++)
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

//-----------------------NQUEEN SUBSEQUENCE----------------------//

bool isvalid02(vector<vector<bool>> &chess, int r, int c)
{
    if (r < 0 || c < 0 || r >= chess.size() || c >= chess[0].size())
    {
        return false;
    }
    return true;
}

bool isValidLocforQueen02(vector<vector<bool>> &chess, int r, int c)
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
            if (isvalid02(chess, nr, nc) && chess[nr][nc])
            {
                return false;
            }
        }
    }
    return true;
}

int nQueen02(vector<vector<bool>> &chess, int idx, int tnq, int qpsf, string asf)
{
    if (qpsf == tnq || idx == chess.size())
    {
        if (qpsf == tnq)
        {
            cout << asf << endl;
            return 1;
        }
        return 0;
    }
    int counter = 0;

    int r = idx / chess[0].size();
    int c = idx % chess[0].size();

    if (!chess[r][c] && isValidLocforQueen02(chess, r, c))
    {
        chess[r][c] = true;
        counter += nQueen02(chess, idx + 1, tnq, qpsf + 1, asf + " Q " + to_string(qpsf + 1) + " B " + to_string(idx));
        chess[r][c] = false;
    }
    counter += nQueen02(chess, idx + 1, tnq, qpsf, asf);

    return counter;
}

int main()
{
    // vector<bool> box(4, false);
    vector<vector<bool>> chess(4, vector<bool>(4, false));
    // cout << permutation(box, 2, 0, "");
    // cout << combination(box, 0, 2, 0, "");
    // nQueen(chess, 0, 4, 0, "");
    nQueen02(chess, 0, 4, 0, "");
    return 0;
}