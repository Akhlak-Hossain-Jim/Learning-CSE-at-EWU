#include <iostream>
using namespace std;

int sumOfSubsets(int n, int sum, int arr[])
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
            else if (arr[i - 1] > j)
            {
                dp[i][j] = dp[i - 1][j];
            }
            else
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
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

    cout << "Enter the length of items: ";
    cin >> n;
    int value[n];
    for (int i = 0; i < n; i++)
    {
        cout << "Enter value for " << i + 1 << "th value: ";
        cin >> value[i];
    }
    cin >> sum;

    int t = sumOfSubsets(n, sum, value);
    if (t == 1)
    {
        cout << "Yes";
    }
    else
        cout << "No";
}
