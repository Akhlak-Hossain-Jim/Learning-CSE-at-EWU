#include <stdio.h>

int main()
{
    int cm;
    float inches;
    printf("This program is to convert centimeters to Inches.\n");
    printf("Enter the length in cm: ");
    scanf("%d", &cm);
    inches = cm / 2.54;
    printf("%d centimeters means %finches", cm, inches);
    return 0;
}