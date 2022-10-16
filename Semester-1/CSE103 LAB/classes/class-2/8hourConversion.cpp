#include <stdio.h>

int main()
{
    int minutes, hours, calculatedMin;
    printf("Input the minutes\n");
    scanf("%d", &minutes);
    hours = minutes / 60;
    calculatedMin = minutes % 60;
    printf("%d minutes is equals to %dhour and %dminutes", minutes, hours, calculatedMin);
    return 0;
}