#include <stdio.h>

void EvenOdd(int a)
{
    if (a % 2 == 0)
        printf("The number is Even number.");
    else
        printf("The number is Odd number.");
}

int main()
{
    int num1;
    printf("This program to check whether a number is even or odd using functions.\nEnter the number: ");
    scanf("%d", &num1);
    EvenOdd(num1);
    return 0;
}