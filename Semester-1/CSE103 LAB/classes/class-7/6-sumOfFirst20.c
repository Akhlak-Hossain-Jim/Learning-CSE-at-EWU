#include <stdio.h>

int num;

int sum(int n)
{
    if (num + 20 != n)
    {
        return (n + sum(n + 1));
    }
}

int main()
{
    int result;
    printf("This program to calculate sum of first 20 natural numbers using recursive function.\nEnter the number: ");
    scanf("%d", &num);
    result = sum(num);
    printf("%d+%d+...+%d = %d", num, num + 1, num + 20, result);
    return 0;
}