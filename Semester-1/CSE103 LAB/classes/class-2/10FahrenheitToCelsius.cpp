#include <stdio.h>

int main()
{
    int Fahrenheit;
    float Celsius;
    printf("This program is to calculate Celsius from Fahrenheit.\n");
    printf("Enter temperature in Fahrenheit: ");
    scanf("%d", &Fahrenheit);
    Celsius = ((Fahrenheit - 32) * 5) / 9;
    printf("%d Fahrenheit is equals to %f celsius", Celsius);
    return 0;
}