#include <stdio.h>
#include <math.h>

int main()
{
    double a, b, c, determiner, x1, x2, realPart, imagPart;
    printf("This program is to solve quadratic equation (ax^2+bx+c=0).\n");
    printf("Enter coefficient of a: ");
    scanf("%lf", &a);
    printf("Enter coefficient of b: ");
    scanf("%lf", &b);
    printf("Enter coefficient of c: ");
    scanf("%lf", &c);

    determiner = (b * b) - (4 * a * c);

    if (determiner > 0)
    {
        x1 = (-b + sqrt(determiner)) / (2 * a);
        x2 = (-b - sqrt(determiner)) / (2 * a);
        printf("x1 = %.2lf and x2 = %.2lf", x1, x2);
    }
    else
    {
        realPart = -b / (2 * a);
        imagPart = sqrt(-determiner) / (2 * a);
        printf("Roots are complex numbers\nx1 = %.2lf+%.2lfi and x2 = %.2f-%.2fi", realPart, imagPart, realPart, imagPart);
    }
    return 0;
}