#include <stdio.h>

int main()
{
    int hour, mins, totalMin;
    float totalHours;
    printf("Input the hour: ");
    scanf("%d", &hour);
    printf("Input the minutes: ");
    scanf("%d", &mins);
    totalMin = (hour * 60) + mins;
    totalHours = totalMin / 60.0;
    printf("%dhours %dminutes means:\n%dminutes or %fhours", hour, mins, totalMin, totalHours);
    return 0;
}