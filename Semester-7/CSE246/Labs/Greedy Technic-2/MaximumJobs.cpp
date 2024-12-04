#include <iostream>
#include <algorithm>

// Inputs: 3 10 12 20 20 25 30

using namespace std;

class Job
{
public:
    int start, end;
    Job() {};
    Job(int s, int e)
    {
        start = s;
        end = e;
    }
    void setStart(int s)
    {
        start = s;
    }
    void setEnd(int e)
    {
        end = e;
    }
};

bool compare(Job a, Job b)
{
    return a.end < b.end;
}

int main()
{
    int n;
    cout << "Enter job length: ";
    cin >> n;
    Job *arr = new Job[n];
    for (int i = 0; i < n; i++)
    {
        int t;
        cout << "\tEnter start time of " << i + 1 << "th job: ";
        cin >> t;
        arr[i].setStart(t);
    }
    for (int i = 0; i < n; i++)
    {
        int t;
        cout << "\tEnter end time of " << i + 1 << "th job: ";
        cin >> t;
        arr[i].setEnd(t);
    }
    sort(arr, arr + n, compare);
    cout << "Sorted List:\n";
    for (int i = 0; i < n; i++)
    {
        cout << "Start: " << arr[i].start << "; End: " << arr[i].end << "\n";
    }
    int currentJobIndex = 0;
    int jobs = 1;
    for (int i = 1; i < n; i++)
    {
        if (arr[i].start >= arr[currentJobIndex].end)
        {
            jobs++;
            currentJobIndex = i;
        }
    }
    cout << "\n\n\t\tMaximum Job can be done: '" << jobs << "'";
    return 0;
}