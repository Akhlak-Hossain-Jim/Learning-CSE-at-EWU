#include <stdio.h>

int main()
{
    int radius;
    float area, circumference;
    const float pi = 3.14;
    printf("This program is to calculate area and circumference from a given radius.\n");
    printf("Enter the radius: ");
    scanf("%d", &radius);
    area = pi * radius * radius;
    circumference = 2 * pi * radius;
    printf("The area is %f \nThe circumference is %f", area, circumference);
    return 0;
}