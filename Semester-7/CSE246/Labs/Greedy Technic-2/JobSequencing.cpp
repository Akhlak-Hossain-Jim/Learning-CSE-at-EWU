#include <iostream>
#include <algorithm>

// Input: 4 a 4 20 b 1 10 c 1 40 d 1 30

using namespace std;

class Job
{
public:
    string id;
    int deadline, profit;
    Job() {};
    void assign(string i, int d, int p)
    {
        id = i;
        deadline = d;
        profit = p;
    }
    void print()
    {
        cout << "Job: " << id << "; deadline: " << deadline << "; profit: " << profit << ";\n";
    }
};

bool compare(Job a, Job b)
{
    return a.profit > b.profit;
}

int main()
{
    int n;
    cout << "Enter job length: ";
    cin >> n;
    Job *arr = new Job[n];
    for (int i = 0; i < n; i++)
    {
        string s;
        int a, b;
        cout << "\tEnter ID of " << i + 1 << "th job: ";
        cin >> s;
        cout << "\tEnter deadline of " << i + 1 << "th job: ";
        cin >> a;
        cout << "\tEnter profit of " << i + 1 << "th job: ";
        cin >> b;
        arr[i].assign(s, a, b);
    }
    sort(arr, arr + n, compare);
    cout << "Sorted List:\n";
    for (int i = 0; i < n; i++)
    {
        arr[i].print();
    }
    int currentJobIndex = 0;
    string res = arr[0].id;
    for (int i = 0; i < n; i++)
    {
        if (arr[i].deadline > arr[currentJobIndex].deadline)
        {
            res += ", " + arr[i].id;
            currentJobIndex = i;
        }
    }
    cout << "\n\n\t\tJobs that can be done are: '" << res << "'";
    return 0;
}