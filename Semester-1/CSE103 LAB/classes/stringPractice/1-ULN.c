#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main()
{
    char ch;
    printf("This program can input a character and display whether it is an uppercase letter, lowercase letter or digit.\nEnter the string: ");
    ch = getchar();
    if (!isdigit(ch))
    {
        if (ch >= 'a' && ch <= 'z')
            printf("Input is a lowercase letter.");
        else if (ch >= 'A' && ch <= 'Z')
            printf("Input is a uppercase letter.");
    }
    else
        printf("Input is a digit.");
    return 0;
}