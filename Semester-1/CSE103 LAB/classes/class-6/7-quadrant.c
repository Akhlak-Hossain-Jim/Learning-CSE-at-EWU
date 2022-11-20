#include <stdio.h>

int main()
{
    int X[100], Y[100], n, most = 0, index, first = 0, second = 0, third = 0, forth = 0, center = 0;
    char GRADE[4] = {'A', 'B', 'C', 'D'};
    printf("This program  can some 2D points into an array (The x values in one array and y values in another array). Display how many points are in each quadrant.\nEnter the array length: ");
    scanf("%d", &n);
    if (n < 101)
    {
        for (int i = 0; i < n; i++)
        {
            printf("Enter the x value of point %d: ", i + 1);
            scanf("%d", &X[i]);
            printf("Enter the y value of point %d: ", i + 1);
            scanf("%d", &Y[i]);
            if (X[i] == 0 && Y[i] == 0)
                center++;
            else if ((X[i] > 0 && Y[i] > 0) || (X[i] > 0 && Y[i] == 0) || (X[i] == 0 && Y[i] > 0))
                first++;
            else if ((X[i] < 0 && Y[i] > 0) || (X[i] < 0 && Y[i] == 0))
                second++;
            else if (X[i] < 0 && Y[i] < 0)
                third++;
            else if ((X[i] > 0 && Y[i] < 0) || (X[i] == 0 && Y[i] < 0))
                forth++;
        }
        printf("%d %d %d %d", first, second, third, forth);
    }
    else
        printf("Can't consider more or less than 100 length of array.");
    return 0;
}