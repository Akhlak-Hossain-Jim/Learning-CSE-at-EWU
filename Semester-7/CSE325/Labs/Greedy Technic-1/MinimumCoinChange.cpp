#include <iostream>
using namespace std;

int main()
{
    int n;
    cout << "Enter the array length: ";
    cin >> n;
    int arr[n];
    int res[n];
    for (int i = 0; i < n; i++)
    {
        int temp;
        cout << "Enter the " << i + 1 << "th coin value: ";
        cin >> temp;
        arr[i] = temp;
        res[i] = 0;
    }
    sort(arr, arr + n, greater<int>());

    int RA, TA, count = 0;
    cout << "Enter the Total Amount: ";
    cin >> TA;
    RA = TA;
    for (int i = 0; i < n; i++)
    {
        while (RA >= arr[i])
        {
            RA -= arr[i];
            res[count] = arr[i];
            count++;
        }
    }
    cout << "Minimum Change required: " << count << "; with: ";
    for (int i = 0; i < n; i++)
    {
        if (res[i] != 0)
            cout << " " << res[i];
    }
}
