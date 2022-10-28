#include <stdio.h>

int main()
{
    int number, square, cube;
    printf("This program is to calculate square and cube of number.\n");
    printf("Enter the number: ");
    scanf("%d", &number);
    square = number * number;
    cube = number * number * number;
    printf("The square is %d \nThe cube is %d", square, cube);
    return 0;
}