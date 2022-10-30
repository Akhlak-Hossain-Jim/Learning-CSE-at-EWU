#include <stdio.h>

int main()
{
    int a, b, c, d, e, max;
    char z;
    printf("Enter a value of a: ");
    scanf("%d", &a);
    printf("Enter a value of b: ");
    scanf("%d", &b);
    printf("Enter a value of c: ");
    scanf("%d", &c);
    printf("Enter a value of d: ");
    scanf("%d", &d);
    printf("Enter a value of e: ");
    scanf("%d", &e);
    if (a > b && a > c && a > d && a > e)
    {
        z = 'a';
        max = a;
    }
    else if (b > a && b > c && b > d && b > e)
    {
        z = 'b';
        max = b;
    }
    else if (c > a && c > b && c > d && c > e)
    {
        z = 'c';
        max = c;
    }
    else if (d > a && d > b && d > c && d > e)
    {
        z = 'd';
        max = d;
    }
    else
    {
        z = 'e';
        max = e;
    }
    printf("Maximum value: %d is %c", max, z);
    return 0;
}