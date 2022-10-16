#include <stdio.h>

int main()
{
    int Fahrenheit;
    float Celsius;
    printf("Input the temperature in Fahrenheit: ");
    scanf("%d", &Fahrenheit);
    Celsius = ((Fahrenheit - 32) * 5) / 9;
    printf("%d is equals to %f celsius", Celsius);
    return 0;
}