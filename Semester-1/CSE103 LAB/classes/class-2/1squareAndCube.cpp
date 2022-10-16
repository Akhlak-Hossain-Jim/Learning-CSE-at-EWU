#include <stdio.h>

int main()
{
    int number, square, cube;
    printf("Input the number\n");
    scanf("%d", &number);
    square = number * number;
    cube = number * number * number;
    printf("The square is %d \nThe cube is %d", square, cube);
    return 0;
}