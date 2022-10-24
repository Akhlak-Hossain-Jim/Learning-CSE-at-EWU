#include <stdio.h>

int main()
{
    int Celsius;
    float Fahrenheit;
    printf("Input the temperature in Celsius\n");
    scanf("%d", &Celsius);
    Fahrenheit = Celsius * 9 / 5 + 32;
    printf("The temperature in fahrenheit is %f", Fahrenheit);
    return 0;
}