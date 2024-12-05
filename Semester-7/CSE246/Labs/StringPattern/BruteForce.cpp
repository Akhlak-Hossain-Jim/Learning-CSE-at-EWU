#include <iostream>
#include <string>

// Inputs: The quick brown fox jumps over the lazy dog. fox

using namespace std;

int main()
{
    string str, patt;
    cout << "Enter the text: ";
    getline(cin, str);
    cout << "Enter the pattern: ";
    cin >> patt;
    int res;
    for (int i = 0; i < str.length() - patt.length(); i++)
    {
        string temp = "";
        for (int j = 0; j < patt.length(); j++)
        {
            temp += str[i + j];
        }
        if (temp.compare(patt) == 0)
        {
            res = i;
            break;
        }
    }
    cout << "\n\t\t\tThe Pattern '" << patt << "' found at index: '" << res << "'";

    return 0;
}