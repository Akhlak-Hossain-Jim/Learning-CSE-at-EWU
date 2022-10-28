#include <stdio.h>

int main()
{
    int radius, height;
    float volume;
    const float pi = 3.14;
    printf("This program is to calculate Volume of a cylinder from radius and height.\n");
    printf("Enter radius: ");
    scanf("%d", &radius);
    printf("Enter height: ");
    scanf("%d", &height);
    volume = pi * radius * radius * height;
    printf("The volume is %f", volume);
    return 0;
}