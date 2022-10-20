#include <stdio.h>

int main()
{
    int days, weeks, months, years, calculatedDays;
    printf("Input the days\n");
    scanf("%d", &days);
    years = days / 365;
    calculatedDays = days % 365;
    months = calculatedDays / 30;
    calculatedDays = calculatedDays % 30;
    weeks = calculatedDays / 7;
    calculatedDays = calculatedDays % 7;
    printf("%d days is equals to %dyears, %dmonths, %dweeks and %ddays", days, years, months, weeks, calculatedDays);
    return 0;
}