#include <stdio.h>

int main()
{
    int a, b, c;
    printf("This program is to check the maximum of inputted 3 values.\n");
    printf("Enter the first number: ");
    scanf("%d", &a);
    printf("Enter the second number: ");
    scanf("%d", &b);
    printf("Enter the third number: ");
    scanf("%d", &c);
    if (a > b)
    {
        if (a > c)
        {
            printf("%d is the maximum number.", a);
        }
        else
        {
            printf("%d is the maximum number.", c);
        }
    }
    else
    {
        if (b > c)
        {
            printf("%d is the maximum number.", b);
        }
        else
        {
            printf("%d is the maximum number.", c);
        }
    }
    return 0;
}