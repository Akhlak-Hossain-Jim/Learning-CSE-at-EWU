#include <stdio.h>

int main()
{
    int ages[100], n, teen = 0;
    printf("This program can input some students' age of a particular class into an array and display number of teenager in that class.\nEnter the array length: ");
    scanf("%d", &n);
    if (n < 101)
    {
        for (int i = 0; i < n; i++)
        {
            printf("Enter the age of person %d: ", i + 1);
            scanf("%d", &ages[i]);
            if ((ages[i] > 12) && ages[i] < 20)
            {
                teen++;
            }
        }
        printf("Older than average ages are: %d", teen);
    }
    else
        printf("Can't consider more than 100 length of array.");
    return 0;
}