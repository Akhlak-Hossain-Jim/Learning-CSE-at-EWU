#include <stdio.h>

int main()
{
    int distance, meters, centimeters;
    float feet, inches;
    printf("Input the number\n");
    scanf("%d", &distance);
    meters = distance * 1000;
    feet = distance * 3280.84;
    inches = distance * 39370.1;
    centimeters = distance * 100000;
    printf("%d is %d meters, %f feet, %f inches, %d centimeters", distance, meters, feet, inches, centimeters);
    return 0;
}