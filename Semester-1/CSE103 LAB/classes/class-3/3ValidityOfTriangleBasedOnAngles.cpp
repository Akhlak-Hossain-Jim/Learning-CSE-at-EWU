#include <stdio.h>

int main()
{
    int a, b, c;
    printf("This program is to check whether the triangle is valid or not based on inputed angels.\n");
    printf("Enter the first angle of the triangle: ");
    scanf("%d", &a);
    printf("Enter the second angle of the triangle: ");
    scanf("%d", &b);
    printf("Enter the third angle of the triangle: ");
    scanf("%d", &c);
    if (a + b + c == 180)
    {
        printf("This is a valid triangle.");
    }
    else
    {
        printf("This is not a valid triangle.");
    }
    return 0;
}