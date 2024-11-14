#include <iostream>
using namespace std;

int BS(int Arr[], int startI, int endI, int searchValue)
{
    if (startI > endI)
        return -1;

    int mid = startI + (endI - startI) / 2;
    if (Arr[mid] == searchValue)
        return mid;
    else if (Arr[mid] < searchValue)
        return BS(Arr, mid + 1, endI, searchValue);
    else
        return BS(Arr, startI, mid - 1, searchValue);
}

int main()
{
    int n = 0;
    cout << "Enter the Array Length: ";
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        cout << "Enter the " << i + 1 << "th value: ";
        int x;
        cin >> x;
        arr[i] = x;
    }

    int sv;
    cout << "\n\nEnter a value you are searching for: ";
    cin >> sv;
    int bsv = BS(arr, 0, n - 1, sv);
    if (bsv < 0)
        cout << "'" << sv << "' Not Found";
    else
        cout << "'" << sv << "' Found at index: " << bsv;
}
