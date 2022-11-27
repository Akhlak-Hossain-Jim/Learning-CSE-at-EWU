#include <stdio.h>

void minMax(int a, int b)
{
    if (a > b)
        printf("1st number is greter than 2nd Number");
    else
        printf("2nd number is greter than 1st Number");
}

int main()
{
    int num1, num2;
    printf("This program to find maximum and minimum between two numbers using functions.\nEnter the 1st number: ");
    scanf("%d", &num1);
    printf("Enter the 2nd number: ");
    scanf("%d", &num2);
    minMax(num1, num2);
    return 0;
}