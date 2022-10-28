#include <stdio.h>

int main()
{
    int hour, mins, totalMin;
    float totalHours;
    printf("This program is to calculate total minutes and fractional hour from minutes and hours.\n");
    printf("Enter the running hour: ");
    scanf("%d", &hour);
    printf("Enter the running minutes: ");
    scanf("%d", &mins);
    totalMin = (hour * 60) + mins;
    totalHours = totalMin / 60.0;
    printf("%dhours %dminutes means:\n%dminutes or %fhours", hour, mins, totalMin, totalHours);
    return 0;
}