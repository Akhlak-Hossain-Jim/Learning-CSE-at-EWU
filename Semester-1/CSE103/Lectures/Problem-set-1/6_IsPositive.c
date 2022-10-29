#include <stdio.h>

int main()
{
    int number;
    printf("This program is to check if the given number is positive or not.\n");
    printf("Enter the number: ");
    scanf("%d", &number);
    if (0 <= number)
        printf("%d is a positive number.", number);
    else
        printf("%d is not a positive number.", number);
    return 0;
}