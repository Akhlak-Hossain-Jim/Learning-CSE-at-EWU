#include <stdio.h>

int main()
{
    int yearlySalary;
    printf("This program is to convert yearly salary into monthly salary.\n");
    printf("Enter the annual salary: ");
    scanf("%d", &yearlySalary);
    printf("%d is the monthly salary.", yearlySalary / 12);
    return 0;
}