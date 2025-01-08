#include <iostream>
#include <string>
using namespace std;

// input 1
// abcxyza
// xyzabcb

// input 2
// ABCDGH
// ACDGHR

int main()
{
    string initial, compare;
    cout << "Enter the initial string: ";
    getline(cin, initial);
    cout << "Enter the string to match: ";
    getline(cin, compare);

    int iL = initial.length(), cL = compare.length();

    int DP[iL + 1][cL + 1];

    for (int i = 0; i <= iL; i++)
        for (int j = 0; j <= cL; j++)
            DP[i][j] = 0;

    for (int i = 1; i <= iL; i++)
        for (int j = 1; j <= cL; j++)
            if (initial[i - 1] == compare[j - 1])
                DP[i][j] = DP[i - 1][j - 1] + 1;

    cout << endl
         << "DP Table:" << endl;
    for (int i = 0; i <= iL; i++)
    {
        for (int j = 0; j <= cL; j++)
            cout << DP[i][j] << " ";
        cout << endl;
    }

    int max = DP[0][0];
    int maxI = 0;

    for (int i = 1; i <= iL; i++)
    {
        for (int j = 1; j <= cL; j++)
        {
            if (DP[i][j] > max)
            {
                max = DP[i][j];
                maxI = j;
            }
        }
    }

    cout << endl
         << "LCSS length: " << max;
    string res = "";
    int st = maxI - max;
    for (int i = st; i < maxI; i++)
        res += compare[i];
    cout << endl
         << "Longest Common Substring: " << res;
}