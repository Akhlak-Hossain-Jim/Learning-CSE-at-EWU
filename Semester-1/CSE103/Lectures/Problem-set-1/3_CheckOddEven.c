#include <stdio.h>

int main()
{
    int number;
    printf("This program is to check a number is Odd or Even.\n");
    printf("Enter the number: ");
    scanf("%d", &number);
    if (number % 2 == 0)
        printf("%d is an Even Number.", number);
    else
        printf("%d is an Odd Number.", number);
    return 0;
}