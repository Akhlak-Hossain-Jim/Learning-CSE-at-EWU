#include <iostream>
#include <cmath>
#include <algorithm>

// Inputs: 3 4 -4 2 3 4 0 5

using namespace std;

int main()
{
    int mN, hN;
    cout << "Enter number of miceArr: ";
    cin >> mN;
    int miceArr[mN];
    for (int i = 0; i < mN; i++)
    {
        int t;
        cout << "\tEnter position of " << i + 1 << "th mice: ";
        cin >> t;
        miceArr[i] = t;
    }
    cout << "Enter number of holes: ";
    cin >> hN;
    int holes[hN];
    for (int i = 0; i < hN; i++)
    {
        int t;
        cout << "\tEnter position of " << i + 1 << "th hole: ";
        cin >> t;
        holes[i] = t;
    }
    sort(miceArr, miceArr + mN);
    sort(holes, holes + hN);

    string holesAre = "equal";
    int net = hN;

    if (hN > mN)
    {
        holesAre = "more";
        net = mN;
        cout << "\n\tAll mice will get a hole and " << hN - mN << " will be empty.";
    }
    else if (hN < mN)
    {
        holesAre = "less";
        cout << "\n\tAll mice will not get a hole and " << mN - hN << " mice will not get a hole.";
    }
    else
    {
        cout << "\n\tAll mice will get a hole and all the holes will be occupied.";
    }

    int max = 0;
    for (int i = 0; i < net; i++)
    {
        int ab = abs(miceArr[i] - holes[i]);
        if (max < ab)
            max = ab;
    }
    cout << "\n\n\t\tTime required: '" << max << "'";
    return 0;
}