#include <stdio.h>

int main()
{
    int a, b, sum;
    printf("This program is to add two inputted number.\n");
    printf("Enter first number: ");
    scanf("%d", &a);
    printf("Enter second number: ");
    scanf("%d", &b);
    sum = a + b;
    printf("Result:\n\t%d+%d=%d", a, b, sum);
    return 0;
}