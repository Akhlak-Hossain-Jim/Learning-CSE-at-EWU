#include <stdio.h>

int main()
{
    int principal, rate, TIME;
    float interest;
    printf("This program is to calculate simple interest from given principal, rate and time.\n");
    printf("Enter the principal: ");
    scanf("%d", &principal);
    printf("Enter the rate: ");
    scanf("%d", &rate);
    printf("Enter the time: ");
    scanf("%d", &TIME);
    interest = principal * rate * TIME / 100;
    printf("The simple Interest is %f", interest);
    return 0;
}