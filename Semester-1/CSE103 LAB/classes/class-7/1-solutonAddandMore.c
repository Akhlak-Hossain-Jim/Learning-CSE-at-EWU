#include <stdio.h>

int SUM(int a, int b)
{
    return a + b;
}

int SUB(int a, int b)
{
    return a - b;
}
double DIVI(int a, int b)
{
    return (double)a / b;
}
int MUL(int a, int b)
{
    return a * b;
}

int main()
{
    int num1, num2, sum, sub, mul;
    double divi;
    printf("This program to add, subtract, multiply and divide two integers using user-defined type function with return type.\nEnter the 1st number: ");
    scanf("%d", &num1);
    printf("Enter the 2nd number: ");
    scanf("%d", &num2);
    sum = SUM(num1, num2);
    sub = SUB(num1, num2);
    divi = DIVI(num1, num2);
    mul = MUL(num1, num2);
    printf("%d + %d = %d\n%d - %d = %d\n%d / %d = %lf\n%d * %d = %d", num1, num2, sum, num1, num2, sub, num1, num2, divi, num1, num2, mul);
    return 0;
}