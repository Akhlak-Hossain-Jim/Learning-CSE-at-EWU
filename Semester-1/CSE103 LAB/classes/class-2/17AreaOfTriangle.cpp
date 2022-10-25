#include <stdio.h>
#include <math.h>

int main()
{
    int a, b, c;
    double semi, area;
    printf("Enter the first side: ");
    scanf("%d", &a);
    printf("Enter the second side: ");
    scanf("%d", &b);
    printf("Enter the third side: ");
    scanf("%d", &c);
    semi = (a + b + c) / 2;
    area = sqrt(semi * (semi - a) * (semi - b) * (semi - c));
    printf("Area of the triangle is: %lf", area);
    return 0;
}