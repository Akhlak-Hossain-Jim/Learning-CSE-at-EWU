#include <stdio.h>

int main()
{
    int r;
    float a, c;
    const float pi = 3.14;
    printf("input radius\n");
    scanf("%d", &r);
    a = pi * r * r;
    c = 2 * pi * r;
    printf("The area is %f \nThe circumference is %f", a, c);
    return 0;
}