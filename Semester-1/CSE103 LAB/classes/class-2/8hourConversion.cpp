#include <stdio.h>

int main()
{
    int minutes, hours, calculatedMin;
    printf("This program is to convert minutes to Hour and Minutes.\n");
    printf("Enter minutes: ");
    scanf("%d", &minutes);
    hours = minutes / 60;
    calculatedMin = minutes % 60;
    printf("%d minutes means: %dhour and %dminutes", minutes, hours, calculatedMin);
    return 0;
}