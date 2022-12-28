#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main()
{
    char ch[100], s[100];
    printf("This program can input some letters into an array and change each uppercase letter to its next uppercase letter keeping lowercase letter unchanged.\nEnter some letters with length of 1-100: ");
    gets(ch);
    strcpy(s, ch);
    for (int i = 0; i < strlen(ch); i++)
    {
        if (ch[i] >= 'A' && ch[i] <= 'Z')
        {
            ch[i]++;
        }
    }
    printf("%s changed to %s.", s, ch);
    return 0;
}