#include <stdio.h>

int main()
{
    int a, b, perform;
    float result;
    printf("This program is to perform Addition, Subtraction, Multiplication and Division.\n");
    printf("Enter first number: ");
    scanf("%d", &a);
    printf("Enter first number: ");
    scanf("%d", &b);
    printf("Perform: \n1)Addition\t2)Substraction\n3)Multiplication\t4)Division\nChoose 1/2/3/4: ");
    scanf("%d", &perform);
    if (perform == 1)
    {
        result = a + b;
        printf("Result is: %f", result);
    }
    else if (perform == 2)
    {
        result = a - b;
        printf("Result is: %f", result);
    }
    else if (perform == 3)
    {
        result = a * b;
        printf("Result is: %f", result);
    }
    else if (perform == 4)
    {
        result = (float)a / b;
        printf("Result is: %f", result);
    }
    else
        printf("You choosed somthing that the program can't understand.");
    return 0;
}