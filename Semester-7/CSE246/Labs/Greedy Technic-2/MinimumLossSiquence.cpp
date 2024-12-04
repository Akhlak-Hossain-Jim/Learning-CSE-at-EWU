#include <iostream>
#include <algorithm>
#include <string>

// Inputs: 4 3 4 1 1000 2 2 4 5

using namespace std;

class Job
{
public:
    double ratio, tOfC, loss;
    string id;
    Job() {};
    void assign(double t, double l, int i)
    {
        id = to_string(i);
        tOfC = t;
        loss = l;
        ratio = t / l;
    }
    void print()
    {
        cout << "Job " << id << " completion time: " << tOfC << "; loss: " << loss << "; daily loss: " << ratio << "\n";
    }
};

bool compare(Job a, Job b)
{
    return a.ratio > b.ratio;
}

int main()
{
    int n;
    cout << "Enter job length: ";
    cin >> n;
    Job *arr = new Job[n];
    for (int i = 0; i < n; i++)
    {
        double a, b;
        cout << "\tEnter completion time of " << i + 1 << "th job: ";
        cin >> a;
        cout << "\tEnter loss of " << i + 1 << "th job: ";
        cin >> b;
        arr[i].assign(a, b, i + 1);
    }
    sort(arr, arr + n, compare);
    string res = arr[0].id;
    for (int i = 1; i < n; i++)
    {
        res += ", " + arr[i].id;
    }
    cout << "\n\t\t\tSequence of job: " << res;

    return 0;
}