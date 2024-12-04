#include <iostream>
#include <algorithm>

// Inputs 6 2.00 2.10 3.00 3.20 3.50 5.00 2.30 3.40 3.20 4.30 4.00 5.20

using namespace std;

int main()
{
    int n;
    cout << "Enter schedule length: ";
    cin >> n;
    double arrival[n];
    double departure[n];
    for (int i = 0; i < n; i++)
    {
        double t;
        cout << "\tEnter arrival time of " << i + 1 << "th job: ";
        cin >> t;
        arrival[i] = t;
    }
    for (int i = 0; i < n; i++)
    {
        double t;
        cout << "\tEnter departure time of " << i + 1 << "th job: ";
        cin >> t;
        departure[i] = t;
    }
    sort(arrival, arrival + n);
    sort(departure, departure + n);
    cout << "Sorted List:" << n << "\n";
    for (int i = 0; i < n; i++)
    {
        cout << "Arrival: " << arrival[i] << "; Departure: " << departure[i] << "\n";
    }
    int count = 0;
    int max = 0;
    int i = 0, j = 0;
    while (i < n)
    {
        if (arrival[i] < departure[j])
        {
            count++;
            i++;
        }
        else if (arrival[i] >= departure[j])
        {
            count--;
            j++;
        }
        if (count > max)
        {
            max = count;
        }
    }
    cout << "\n\n\t\tMinimum track required: '" << max << "'";
    return 0;
}