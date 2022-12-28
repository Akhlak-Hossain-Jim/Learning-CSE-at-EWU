#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main()
{
    char ch[100];
    int L = 0, U = 0;
    printf("This program can input some letters and display how many uppercase vowels and how many lowercase vowels exist.\nEnter some letters with length of 1-100: ");
    gets(ch);
    for (int i = 0; i < strlen(ch); i++)
    {
        if (ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U')
        {
            U++;
        }
        else if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u')
        {
            L++;
        }
    }
    printf("Uppercase vowels:\t%d\nLowercase vowels:\t%d", U, L);
    return 0;
}