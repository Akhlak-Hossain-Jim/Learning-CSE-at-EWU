#include <iostream>
#include <string>
#include <cmath>

// Inputs: The quick brown fox jumps over the lazy dog. fox

using namespace std;

int main()
{
    string str, patt;
    int P = 1000003;
    cout << "Enter the text: ";
    getline(cin, str);
    cout << "Enter the pattern: ";
    cin >> patt;
    int pattHash = 0;
    for (int i = patt.length() - 1; i >= 0; i--)
    {
        pattHash += (int(patt[i]) * pow(26, (patt.length() - 1 - i)));
    }
    pattHash = pattHash % P;
    int res = 0;
    for (int i = 0; i < str.length() - patt.length(); i++)
    {
        int temp = 0;
        string s = "";
        int x = 0;
        for (int j = patt.length() - 1; j >= 0; j--)
        {
            s += str[i + j];
            temp += (int(str[i + j]) * pow(26, x));
            x++;
        }
        temp = temp % P;
        if (temp == pattHash)
        {
            bool matched = true;
            for (int j = 0; j < patt.length(); j++)
            {
                if (str[i + j] != patt[j])
                {
                    matched = false;
                    break;
                }
            }
            if (matched)
            {
                res = i;
                break;
            }
        }
    }
    cout << "\n\t\t\tThe Pattern '" << patt << "' found at index: '" << res << "'";

    return 0;
}