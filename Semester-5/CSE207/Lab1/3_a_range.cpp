#include <iostream>
using namespace std;

class PrimeInRange
{
private:
    int range1;
    int range2;
    int n = range2 - range1;
    int counter = 0;
    int *arr = new int[n];
    void find()
    {
        for (int i = range1; i <= range2; i++)
        {
            bool is_prime = true;
            if (i == 0 || i == 1)
            {
                is_prime = false;
            }
            for (int j = 2; j <= i / 2; ++j)
            {
                if (i % j == 0)
                {
                    is_prime = false;
                    break;
                }
            }
            if (is_prime)
            {
                arr[counter] = i;
                counter++;
            }
        }
    }

public:
    PrimeInRange() {}
    PrimeInRange(int r1, int r2)
    {
        range1 = r1;
        range2 = r2;
    }
    void display()
    {
        find();
        cout << "Total " << counter << " prime numbers found between " << range1 << " and " << range2;
        cout << "\nThey are: " << endl;
        for (int i = 0; i < counter; i++)
            cout << arr[i] << "\t";
    }
};

int main()
{
    int runner = 0;
    int n1, n2;
    PrimeInRange *obj;

    cout << "Enter two number to find prime numbers between them.\n";
    cout << "\nEnter the first number: ";
    cin >> n1;
    cout << "Enter the second number: ";
    cin >> n2;

    if ((n1 == n2) || (n1 < 1) || (n2 < 1))
    {
        cout << "\n two numbers cannot be equal or smaller than 1.\nTry again.\n";
    }
    else if (n1 < n2)
    {
        obj = new PrimeInRange(n1, n2);
        obj->display();
        delete obj;
    }
    else if (n1 > n2)
    {
        obj = new PrimeInRange(n2, n1);
        obj->display();
        delete obj;
    }

    return 0;
}