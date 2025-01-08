#include <iostream>
using namespace std;

// inputs:
// 3
// 1 3 5
// 8

int CoinChange(int n, int sum, int coin[])
{
    int dp[n + 1][sum + 1];
    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j <= sum; j++)
        {
            if (j == 0)
                dp[i][j] = 1;
            else if (i == 0)
                dp[i][j] = 0;
            else if (coin[i - 1] > j)
            {
                dp[i][j] = dp[i - 1][j];
            }
            else
                dp[i][j] = dp[i - 1][j] + dp[i][j - coin[i - 1]];
        }
    }

    cout << endl;
    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j <= sum; j++)
        {
            cout << dp[i][j] << " ";
        }
        cout << endl;
    }
    return dp[n][sum];
}

int main()
{
    int n, sum;

    cout << "Enter the length of coins: ";
    cin >> n;
    int coins[n];
    for (int i = 0; i < n; i++)
    {
        cout << "Enter value for " << i + 1 << "th coin value: ";
        cin >> coins[i];
    }
    cin >> sum;

    int t = CoinChange(n, sum, coins);
    cout << "\n\t\tThe sum '" << sum << "' can be found in total of '" << t << "' combinations";
}
