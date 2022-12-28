#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main()
{
    char ch[100];
    int U = 0, L = 0;
    double r;
    printf("This program can input some letters and display ratio between uppercase and lowercase letters.\nEnter some letters with length of 1-100: ");
    gets(ch);
    for (int i = 0; i < strlen(ch); i++)
    {
        if (ch[i] >= 'a' && ch[i] <= 'z')
        {
            L++;
        }
        else if (ch[i] >= 'A' && ch[i] <= 'Z')
        {
            U++;
        }
    }
    r = (float)U / L;
    printf("Ratio between uppercase and lowercase is %d:%d = %.2lf", U, L, r);
    return 0;
}