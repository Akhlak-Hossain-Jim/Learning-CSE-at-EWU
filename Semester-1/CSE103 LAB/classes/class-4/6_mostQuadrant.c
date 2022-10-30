#include <stdio.h>

int main()
{
    int n, x, y, first = 0, second = 0, third = 0, forth = 0, center = 0;
    printf("This program is to find most points falls in a quadrant of some 2D points.\n");
    printf("Enter points to be compared: ");
    scanf("%d", &n);
    if (n > 0)
    {
        for (int i = 0; i < n; i++)
        {
            printf("Enter %d's x value: ", i + 1);
            scanf("%lf", &x);
            printf("Enter %d's y value: ", i + 1);
            scanf("%lf", &y);
            if (x == 0 && y == 0)
                center++;
            else if ((x > 0 && y > 0) || (x > 0 && y == 0) || (x == 0 && y > 0))
                first++;
            else if ((x < 0 && y > 0) || (x < 0 && y == 0))
                second++;
            else if (x < 0 && y < 0)
                third++;
            else if ((x > 0 && y < 0) || (x == 0 && y < 0))
                forth++;
        }
        if (center > first && center > second && center > third && center > forth)
            printf("Most points are in the center.");
        else if (first > center && first > second && first > third && first > forth)
            printf("Most points are in 1st quadrant.");
        else if (second > center && second > first && second > third && second > forth)
            printf("Most points are in 2nd quadrant.");
        else if (third > center && third > first && third > second && third > forth)
            printf("Most points are in 3rd quadrant.");
        else if (forth > center && forth > first && forth > second && forth > third)
            printf("Most points are in 4th quadrant.");
    }
    else
        printf("Can't compare less then 1 2D point");
    return 0;
}