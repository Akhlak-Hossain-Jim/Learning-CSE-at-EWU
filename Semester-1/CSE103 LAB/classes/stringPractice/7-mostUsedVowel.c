#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main()
{
    char ch[100];
    int a = 0, e = 0, I = 0, o = 0, u = 0;
    printf("This program can input some lowercase letters and display which vowels appear most.\nEnter some lowercase letters with length of 1-100: ");
    gets(ch);
    printf("Before:\t%s\n", ch);
    for (int i = 0; i < strlen(ch); i++)
    {
        if (ch[i] == 'a')
        {
            a++;
        }
        else if (ch[i] == 'e')
        {
            e++;
        }
        else if (ch[i] == 'i')
        {
            I++;
        }
        else if (ch[i] == 'o')
        {
            o++;
        }
        else if (ch[i] == 'u')
        {
            u++;
        }
    }
    if (a > e && a > I && a > o && a > u)
        printf("'a' is most used vowel");
    else if (e > a && e > I && e > o && e > u)
        printf("'e' is most used vowel");
    else if (I > e && I > a && I > o && I > u)
        printf("'i' is most used vowel");
    else if (o > e && o > I && o > a && o > u)
        printf("'o' is most used vowel");
    else
        printf("'u' is most used vowel");
    return 0;
}