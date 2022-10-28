#include <stdio.h>

int main()
{
    int x, y;
    float z;
    printf("This program is to find average between 2 number.\n");
    printf("Enter a number: ");
    scanf("%d", &x);
    printf("Enter second number: ");
    scanf("%d", &y);
    z = (x + y) / 2.0;
    printf("This result is %f", z);
    return 0;
}