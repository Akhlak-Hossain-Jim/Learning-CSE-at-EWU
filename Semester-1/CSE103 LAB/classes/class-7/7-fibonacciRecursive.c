#include <stdio.h>

int num;

int sum(int n)
{
    if (n != 0)
    {
        // printf("%d, ", prev);
        return (n + sum(n - 1));
    }
}

int main()
{
    int result, prev = 0, next = 1, h;
    printf("This program to generate Fibonacci series without and with recursive function.\nEnter the number: ");
    scanf("%d", &num);
    printf("\nWithout recursive:\n");
    for (int i = 0; i < num; i++)
    {
        printf("%d, ", prev);
        h = prev;
        prev = next;
        next += h;
    }
    printf("\nWith recursive:\n");
    // result = sum(num);
    return 0;
}