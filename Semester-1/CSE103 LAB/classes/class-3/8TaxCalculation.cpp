#include <stdio.h>

int main()
{
    int income;
    float rate, tax;
    printf("This program is to output calculated tax based on income.\n");
    printf("Enter the income: ");
    scanf("%d", &income);
    if (income <= 150000)
    {
        printf("You don't have to pay tax.");
    }
    else if (income > 150001 && income < 300000)
    {
        rate = 0.10;
        tax = income * rate;
        printf("The calculated tax is %f.", tax);
    }
    else if (income > 300001 && income < 500000)
    {
        rate = 0.20;
        tax = income * rate;
        printf("The calculated tax is %f.", tax);
    }
    else
    {
        rate = 0.30;
        tax = income * rate;
        printf("The calculated tax is %f.", tax);
    }
    return 0;
}