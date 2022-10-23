#include <stdio.h>

int main()
{
    int x, y;
    printf("This program is to find the coordinate of a 2D.\n");
    printf("Enter the x point: ");
    scanf("%d", &x);
    printf("Enter the y point: ");
    scanf("%d", &y);
    if (x == 0 && y == 0)
    {
        printf("(%d, %d) is in center or origin.", x, y);
    }
    else if (x > 0 && y > 0)
    {
        printf("(%d, %d) is in 1st coordinate.", x, y);
    }
    else if (x < 0 && y > 0)
    {
        printf("(%d, %d) is in 2nd coordinate.", x, y);
    }
    else if (x < 0 && y < 0)
    {
        printf("(%d, %d) is in 3rd coordinate.", x, y);
    }
    else
    {
        printf("(%d, %d) is in 4th coordinate.", x, y);
    }
    return 0;
}