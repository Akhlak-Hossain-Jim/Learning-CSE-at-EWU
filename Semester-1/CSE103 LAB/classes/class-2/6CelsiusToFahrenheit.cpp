#include <stdio.h>

int main()
{
    int Celsius;
    float Fahrenheit;
    printf("This program is to calculate Fahrenheit from Celsius. \n");
    printf("Enter temperature in Celsius: ");
    scanf("%d", &Celsius);
    Fahrenheit = Celsius * 9 / 5 + 32;
    printf("The temperature in fahrenheit is %f", Fahrenheit);
    return 0;
}