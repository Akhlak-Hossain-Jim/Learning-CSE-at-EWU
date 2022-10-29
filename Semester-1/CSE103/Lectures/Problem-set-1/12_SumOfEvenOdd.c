#include <stdio.h>

int main()
{
    int n;
    int even = 0;
    int odd = 0;
    printf("This program is to print sum of Even and Odd numbers between a given number.\n");
    printf("Enter a number: ");
    scanf("%d", &n);
    for (int i = 1; i <= n; i++)
        if (i % 2 == 0)
            even += i;
        else
            odd += i;
    printf("Sum of Even numbers is: %d\nSum of Odd numbers is:%d", even, odd);
    return 0;
}