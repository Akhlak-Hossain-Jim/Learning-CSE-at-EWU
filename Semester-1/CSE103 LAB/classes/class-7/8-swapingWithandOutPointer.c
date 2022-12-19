#include <stdio.h>

void CVSwap(int x, int y)
{
    int helper;
    helper = x;
    x = y;
    y = helper;
    printf("Inside call by value function.\na=%d\tb=%d\n", x, y);
    return;
}
void CRSwap(int *x, int *y)
{
    int helper;
    helper = *x;
    *x = *y;
    *y = helper;
    printf("Inside call by reference function.\na=%d\tb=%d\n", *x, *y);
    return;
}

int main()
{
    int a, b;
    printf("This program swap two integers using call by value and call by reference methods of passing arguments to a function.\nEnter the first number: ");
    scanf("%d", &a);
    printf("Enter the second number: ");
    scanf("%d", &b);
    printf("Swapping with call by value.\n");
    CVSwap(a, b);
    printf("In main function.\na=%d\tb=%d\n", a, b);
    printf("Now call by reference.\n");
    CRSwap(&a, &b);
    printf("And in main function.\na=%d\tb=%d\n", a, b);
    return 0;
}