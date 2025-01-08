#include <iostream>
#include <string>
using namespace std;

// 4
// 2 3
// 3 4
// 4 5
// 5 6
// 8

int maxV(int a, int b)
{
    if (a > b)
        return a;
    return b;
}

int main()
{
    int n, c;
    cout << "Enter the length of items: ";
    cin >> n;
    int wt[n], p[n];
    for (int i = 0; i < n; i++)
    {
        cout << "Enter wight for " << i + 1 << "th value: ";
        cin >> wt[i];
        cout << "Enter profit for " << i + 1 << "th value: ";
        cin >> p[i];
    }
    cin >> c;
    for (int i = 0; i < n; i++)
    {
        cout << "\n\t\t" << i + 1 << "th weight: " << wt[i] << " & profit: " << p[i];
    }
    cout << "\n\n\t\tCapacity: " << c;

    int DP[n + 1][c + 1];

    for (int i = 0; i <= n; i++)
    {
        for (int w = 0; w <= c; w++)
        {
            if (i == 0 || w == 0)
                DP[i][w] = 0;
            else if (wt[i - 1] > w)
                DP[i][w] = DP[i - 1][w];
            else
                DP[i][w] = maxV(DP[i - 1][w], DP[i - 1][w - wt[i - 1]] + p[i - 1]);
        }
    }

    cout << "\n\tThe Tabel:\n\n\t\t";
    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j <= c; j++)
        {
            cout << DP[i][j] << "  ";
        }
        cout << "\n\t\t";
    }

    cout << "\n\n\t\tMax profit: " << DP[n][c];

    const int refC = DP[n][c];
    int ref = refC;
    string res = "\n\n\n\t\t\tThe program will take:";

    int i = n, j = c;
    while (ref > 0)
    {
        cout << "\n---" << ref << "---" << i << j;
        if (DP[i][j] == ref)
        {
            i--;
        }
        else if (DP[i][j] < ref)
        {
            res += " Obj " + to_string(i + 1);
            ref = ref - p[i];
            ++i;
            while (DP[i][j] != ref)
            {
                j--;
            }
        }
    }

    cout << res;

    return 0;
}