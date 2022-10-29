#include <stdio.h>
#include <ctype.h>

int main()
{
    char c, d;
    printf("This program is to check if a given Alphabet is Vowel or not.\n");
    printf("Enter an alphabet: ");
    scanf("%c", &c);
    d = tolower(c);
    if (d == 'a' || d == 'e' || d == 'i' || d == 'o' || d == 'u')
        printf("%c is a vowel.", c);
    else
        printf("%c is not a vowel.", c);
    return 0;
}