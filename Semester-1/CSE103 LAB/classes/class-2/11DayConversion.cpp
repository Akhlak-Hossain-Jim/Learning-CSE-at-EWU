#include <stdio.h>

int main()
{
    int days, weeks, months, years, calculatedDays;
    printf("This program is to calculate years, months, weeks, and days form total number of days.\n");
    printf("Enter total days: ");
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