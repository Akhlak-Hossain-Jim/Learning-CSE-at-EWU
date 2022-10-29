#include <stdio.h>

int main()
{
    int a, b, c;
    printf("This program is to swap two number.\n");
    printf("Enter first number: ");
    scanf("%d", &a);
    printf("Enter first number: ");
    scanf("%d", &b);
    printf("You entered:\n\ta = %d and b = %d\n", a, b);
    c = a;
    a = b;
    b = c;
    printf("Swapped value:\n\ta = %d and b = %d", a, b);
    return 0;
}