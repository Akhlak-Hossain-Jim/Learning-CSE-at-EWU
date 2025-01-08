#include <iostream>
using namespace std;

int CoinChangeFinite(int n, int sum, int coin[], int sup[])
{
    int dp[n + 1][sum + 1];

    for (int i = 0; i <= n; i++)
        for (int j = 0; j <= sum; j++)
            if (j == 0)
                dp[i][j] = 1;
            else
                dp[i][j] = 0;

    for (int i = 1; i <= n; i++)
    {
        for (int j = 0; j <= sum; j++)
        {
            dp[i][j] = dp[i - 1][j];
            for (int k = 1; k <= sup[i - 1] && k * coin[i - 1] <= j; k++)
            {
                dp[i][j] += dp[i - 1][j - k * coin[i - 1]];
            }
        }
    }

    cout << "DP Table:" << endl;
    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j <= sum; j++)
            cout << dp[i][j] << " ";
        cout << endl;
    }

    return dp[n][sum];
}

int main()
{
    int n, sum;

    cout << "Enter the number of coin types: ";
    cin >> n;

    int coins[n], supply[n];
    for (int i = 0; i < n; i++)
    {
        cout << "Enter value and coin with supply " << i + 1 << ": ";
        cin >> coins[i] >> supply[i];
    }

    cout << "Enter the target sum: ";
    cin >> sum;

    int result = CoinChangeFinite(n, sum, coins, supply);
    cout << "The sum '" << sum << "' can be found in a total of '" << result << "' combinations." << endl;

    return 0;
}
