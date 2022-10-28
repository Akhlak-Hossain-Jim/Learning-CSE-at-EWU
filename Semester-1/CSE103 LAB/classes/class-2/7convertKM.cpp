#include <stdio.h>

int main()
{
    int distance, meters, centimeters;
    float feet, inches;
    printf("This program is to convert Km to meters, feet, inches, centimeters.\n");
    printf("Enter a Kilometer value: ");
    scanf("%d", &distance);
    meters = distance * 1000;
    feet = distance * 3280.84;
    inches = distance * 39370.1;
    centimeters = distance * 100000;
    printf("%d is %d meters, %f feet, %f inches, %d centimeters", distance, meters, feet, inches, centimeters);
    return 0;
}