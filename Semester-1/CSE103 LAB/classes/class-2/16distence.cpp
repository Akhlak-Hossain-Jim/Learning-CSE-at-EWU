#include <stdio.h>
#include <math.h>

int main()
{
    int x1, y1, x2, y2;
    double distance;
    printf("Enter the x1 point: ");
    scanf("%d", &x1);
    printf("Enter the y1 point: ");
    scanf("%d", &y1);
    printf("Enter the x2 point: ");
    scanf("%d", &x2);
    printf("Enter the y2 point: ");
    scanf("%d", &y2);
    distance = sqrt(((y2 - y1) * (y2 - y1)) + ((x2 - x1) * (x2 - x1)));
    printf("The distance of the 2D points is: %f", distance);
    return 0;
}