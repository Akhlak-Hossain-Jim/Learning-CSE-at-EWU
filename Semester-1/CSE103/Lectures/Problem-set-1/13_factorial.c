#include <stdio.h>

int main()
{
    int n, factorial = 1;
    printf("This program is to calculate factorial of a given number.\n");
    printf("Enter a number: ");
    scanf("%d", &n);
    for (int i = 1; i <= n; i++)
        factorial *= i;
    printf("Factorial of %d is:%d", n, factorial);
    return 0;
}