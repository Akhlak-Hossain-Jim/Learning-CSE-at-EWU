#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main()
{
    char ch[3];
    printf("This program can input three lowercase letters and display whether any duplicate exists or not.\nEnter the three lowercase letters: ");
    gets(ch);
    if ((ch[0] == ch[1] && ch[1] == ch[2]) || ch[0] == ch[1] || ch[1] == ch[2] || ch[2] == ch[0])
        printf("Duplicate exists.");
    else
        printf("No duplicate exists.");
    return 0;
}