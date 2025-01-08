#include <iostream>
#include <string>
using namespace std;

// input 1
// PROVIDENCE
// PRESIDENT

// input 2
// ABCDGH
// AEDFHR

int maxValue(int a, int b)
{
    if (a > b)
        return a;
    return b;
}

int main()
{
    string initial, compare;
    cout << "Enter the initial string: ";
    getline(cin, compare);
    cout << "Enter the string to match: ";
    getline(cin, initial);

    int iL = initial.length(), cL = compare.length();

    int DP[iL + 1][cL + 1];

    for (int i = 0; i <= iL; i++)
        for (int j = 0; j <= cL; j++)
            DP[i][j] = 0;

    for (int i = 1; i <= iL; i++)
    {
        for (int j = 1; j <= cL; j++)
        {
            if (j == 0 || i == 0)
                DP[i][j] = 0;
            else if (initial[i - 1] == compare[j - 1])
                DP[i][j] = DP[i - 1][j - 1] + 1;
            else
                DP[i][j] = maxValue(DP[i][j - 1], DP[i - 1][j]);
        }
    }

    cout << endl
         << "DP Table:" << endl;
    for (int i = 0; i <= iL; i++)
    {
        for (int j = 0; j <= cL; j++)
        {
            cout << DP[i][j] << " ";
        }
        cout << endl;
    }

    cout << endl
         << "LCS length: " << DP[iL][cL];
    int i = iL, j = cL;
    int ref = DP[iL][cL];
    string res = "";
    while (ref > 0)
    {
        if (ref == DP[i][j - 1])
            j--;
        else if (ref > DP[i][j - 1] && ref == DP[i - 1][j])
            i--;
        else
        {
            res = initial[i - 1] + res;
            i--;
            j--;
            ref = DP[i][j];
        }
    }
    cout << endl
         << "Longest Common Subsequence: " << res;
}