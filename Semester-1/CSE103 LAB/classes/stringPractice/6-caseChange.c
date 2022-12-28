#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main()
{
    char ch[100];
    int L = 0, U = 0;
    printf("This program can input some letters and interchange each one case.\nEnter some letters with length of 1-100: ");
    gets(ch);
    printf("Before:\t%s\n", ch);
    for (int i = 0; i < strlen(ch); i++)
    {
        if (ch[i] >= 'A' && ch[i] <= 'Z')
        {
            ch[i] = tolower(ch[i]);
        }
        else if (ch[i] >= 'a' && ch[i] <= 'z')
        {
            ch[i] = toupper(ch[i]);
        }
    }
    printf("After:\t%s", ch);
    return 0;
}