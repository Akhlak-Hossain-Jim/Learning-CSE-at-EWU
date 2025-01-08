#include <iostream>
#include <string>
using namespace std;

// inputs:
// 8
// 5 2 8 6 3 6 9 7

int main()
{
    int n;
    cout << "Enter the number of inputs: ";
    cin >> n;

    int inputs[n];
    for (int i = 0; i < n; i++)
    {
        cout << "Enter value " << i + 1 << ": ";
        cin >> inputs[i];
    }

    int DP[n];
    int Hash[n];

    for (int i = 0; i < n; i++)
    {
        DP[i] = 1;
        Hash[i] = i;
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < i; j++)
        {
            if (inputs[j] < inputs[i])
            {
                DP[i] = 1 + DP[j];
                Hash[i] = j;
            }
        }
    }

    cout << endl
         << "Inputs    : ";
    for (int i = 0; i < n; i++)
        cout << inputs[i] << " ";

    cout << endl
         << "DP Table  : ";
    for (int i = 0; i < n; i++)
        cout << DP[i] << " ";

    cout << endl
         << "Hash Table: ";
    for (int i = 0; i < n; i++)
        cout << Hash[i] << " ";

    int max = DP[0], maxI = 0;
    for (int i = 1; i < n; i++)
        if (DP[i] > max)
        {
            max = DP[i];
            maxI = i;
        }

    cout << endl
         << "LIC length: " << DP[n - 1];
    string res = "";
    for (int i = n - 1; i >= 0; i--)
    {
        if (i == maxI)
        {
            res = to_string(inputs[i]) + " " + res;
            maxI = Hash[i];
        }
    }
    cout << endl
         << "LCI       : " << res;
}