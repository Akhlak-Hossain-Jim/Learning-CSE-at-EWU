#include <stdio.h>

void Prime(int a)
{
    int sp = 0;
    for (int i = 2; i <= a / 2; i++)
    {
        if (a % i == 0)
        {
            sp = 1;
        }
    }
    if (sp == 0)
        printf("The number is a prime number.\n");
    else
        printf("The number is not a prime number.\n");
}
void Perfect(int a)
{
    int sum = 0;
    for (int i = 1; i <= a; i++)
    {
        if (a % i == 0)
            sum += i;
    }
    if (sum / 2 == a)
        printf("The number is a perfect number.\n");
    else
        printf("The number is not a perfect number.\n");
}

int main()
{
    int num1;
    printf("This program to check whether a number is prime, Armstrong or perfect number using functions.\nEnter the number: ");
    scanf("%d", &num1);
    Prime(num1);
    Perfect(num1);
    return 0;
}