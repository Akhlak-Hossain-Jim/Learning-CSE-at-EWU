#include <iostream>
using namespace std;

void computePrefixTable(string pattern, int lps[], int n)
{
    int length = 0;
    int i = 1;
    lps[0] = 0;
    while (i < n)
    {
        if (pattern[i] == pattern[length])
        {
            length++;
            lps[i] = length;
            i++;
        }
        else
        {
            if (length != 0)
            {
                length = lps[length - 1];
            }
            else
            {
                lps[i] = 0;
                i++;
            }
        }
    }
}

void kmp(string text, string pattern, int lps[])
{
    int n = text.length();
    int m = pattern.length();
    int i = 0;
    int j = 0;
    while (i < n)
    {
        if (pattern[j] == text[i])
        {
            j++;
            i++;
        }

        if (j == m)
        {
            cout << "\n\t\t\tThe Pattern '" << pattern << "' found at index: '" << i - j << "'";
            j = lps[j - 1];
        }
        else if (i < n && pattern[j] != text[i])
        {
            if (j != 0)
            {
                j = lps[j - 1];
            }
            else
            {
                i = i + 1;
            }
        }
    }
}

int main()
{
    string str, patt;
    cout << "Enter the text: ";
    getline(cin, str);
    cout << "Enter the pattern: ";
    cin >> patt;
    int n = patt.length();
    int m = str.length();
    int lps[n];
    computePrefixTable(patt, lps, n);
    kmp(str, patt, lps);

    return 0;
}