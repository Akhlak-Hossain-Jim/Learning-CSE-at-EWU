#include <stdio.h>

int main()
{
    int a, b, c, d;
    float ratio;
    printf("Enter the first number: ");
    scanf("%d", &a);
    printf("Enter the second number: ");
    scanf("%d", &b);
    printf("Enter the third number: ");
    scanf("%d", &c);
    printf("Enter the fourth number: ");
    scanf("%d", &d);
    ratio = (float)(a - b) / (c - d);
    printf("The ratio is: %f", ratio);
    return 0;
}