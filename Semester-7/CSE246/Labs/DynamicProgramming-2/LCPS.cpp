#include <iostream>
#include <string>
using namespace std;

// input 1
// aaaabbaa

// input 2
// BBABCBCAB

// input 3
// BBABCBAB

int main()
{
    string str;
    cout << "Enter the string: ";
    getline(cin, str);

    int L = str.length();

    cout << endl
         << "Entered String: " << str;

    int DP[L][L];

    for (int i = 0; i < L; i++)
        for (int j = 0; j < L; j++)
        {
            if (i == j)
                DP[i][j] = 1;
            else
                DP[i][j] = 0;
        }

    int start = L - 1, length = 1;

    for (int i = L - 2; i >= 0; i--)
    {
        for (int j = i + 1; j < L; j++)
        {
            if (str[i] == str[j])
            {
                if (DP[i + 1][j - 1] == 1 || j - i == 1)
                {
                    DP[i][j] = 1;
                    if (length < j - i + 1)
                    {
                        start = i;
                        length = j - i + 1;
                    }
                }
            }
        }
    }

    cout << endl
         << "DP Table:" << endl;
    for (int i = 0; i < L; i++)
    {
        for (int j = 0; j < L; j++)
            cout << DP[i][j] << " ";
        cout << endl;
    }

    cout << endl
         << "LCPS length: " << length;
    string res = "";
    for (int i = start; i < start + length; i++)
        res += str[i];
    cout << endl
         << "Longest Common Palindrom Substring: " << res;
}