#include <iostream>
using namespace std;

int sumofs(int n, int m, int value[])
{
    int dp[n + 1][m + 1];
    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j <= m; j++)
        {
            if (i == 0 || j == 0)
            {
                dp[0][j] = 0;
                dp[i][0] = 1;
            }
            else if (value[i - 1] > j)
            {
                dp[i][j] = dp[i - 1][j];
            }
            else
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - value[i - 1]];
        }
    }

    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j <= m; j++)
        {
            cout << dp[i][j] << " ";
        }
        cout << endl;
    }
    return dp[n][m];
}

int main()
{
    int n, sum;

    cout << "Enter the length of items: ";
    cin >> n;
    int value[n];
    for (int i = 0; i < n; i++)
    {
        cout << "Enter value for " << i + 1 << "th value: ";
        cin >> value[i];
    }
    cin >> sum;

    int t = sumofs(n, sum, value);
    if (t == 1)
    {
        cout << "Yes";
    }
    else
        cout << "No";
}
