#include <stdio.h>

int main()
{
    int n, x, y, i = 0, ii = 0, iii = 0, iv = 0, center = 0;
    printf("This program is to find most poins falls in a quadrant of some 2D points.\n");
    printf("Enter points to be compared: ");
    scanf("%d", &n);
    for (int j = 0; j < n; j++)
    {
        printf("Enter %d's x value: ", j + 1);
        scanf("%lf", &x);
        printf("Enter %d's y value: ", j + 1);
        scanf("%lf", &y);
        if (x == 0 && y == 0)
            center++;
        else if (x > 0 && y > 0)
            i++;
        else if (x < 0 && y > 0)
            ii++;
        else if (x < 0 && y < 0)
            iii++;
        else if (x > 0 && y < 0)
            iv++;
    }
    if (center > i && center > ii && center > iii && center > iv)
        printf("Most points are in center quadrant.");
    else if (i > center && i > ii && i > iii && i > iv)
        printf("Most points are in 1st quadrant.");
    else if (ii > center && ii > i && ii > iii && ii > iv)
        printf("Most points are in 2nd quadrant.");
    else if (iii > center && iii > i && iii > ii && iii > iv)
        printf("Most points are in 3rd quadrant.");
    else
        printf("Most points are in 4th quadrant.");
    return 0;
}