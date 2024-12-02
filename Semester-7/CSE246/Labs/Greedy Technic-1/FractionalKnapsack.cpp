#include <iostream>
#include <algorithm>
using namespace std;

class WeightProfit
{
public:
    int profit, weight;
    float ratio;
    WeightProfit() {};
    WeightProfit(int p, int w)
    {
        profit = p;
        weight = w;
        ratio = static_cast<float>(p) / w;
    }
};

bool compare(WeightProfit a, WeightProfit b)
{
    return a.ratio > b.ratio;
}

int main()
{
    int n, MW, RW;
    cout << "Enter the number of items: ";
    cin >> n;
    WeightProfit *arr = new WeightProfit[n];
    for (int i = 0; i < n; i++)
    {
        int p, w;
        cout << "Enter " << i + 1 << "th (profit, weight): ";
        cin >> p >> w;
        arr[i] = WeightProfit(p, w);
    }
    sort(arr, arr + n, compare);
    cout << "Profit\tWeight\tRatio:\n";
    for (int i = 0; i < n; i++)
    {
        cout << arr[i].profit << "\t" << arr[i].weight << "\t" << arr[i].ratio << "\n";
    }

    cout << "Enter the Max Weight: ";
    cin >> MW;
    RW = MW;

    int TP = 0;
    for (int i = 0; i < n; i++)
    {
        if (arr[i].weight <= RW)
        {
            RW -= arr[i].weight;
            TP += arr[i].profit;
        }
        else
        {
            TP += (RW * arr[i].ratio);
            RW = 0;
            break;
        }
    }
    cout << "For max weight of '" << MW << "', max profit can be: " << TP;
}
