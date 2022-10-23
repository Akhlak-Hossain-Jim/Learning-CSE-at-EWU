#include <stdio.h>

int main()
{
    int a, b, c;
    printf("This program is to check whether the triangle is equilateral, isosceles or scalene triangle.\n");
    printf("Enter the first side of the triangle: ");
    scanf("%d", &a);
    printf("Enter the second side of the triangle: ");
    scanf("%d", &b);
    printf("Enter the third side of the triangle: ");
    scanf("%d", &c);
    if (a + b > c)
    {
        printf("This is a valid triangle.");
    }
    else
    {
        printf("This is not a valid triangle.");
    }
    return 0;
}