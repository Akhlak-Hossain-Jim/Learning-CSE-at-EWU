#include <stdio.h>

int main()
{
    int ages[100], n, total = 0, older = 0;
    float avrg;
    printf("This program can input some persons age into an array and display how many of them are older than average age of those persons.\nEnter the array length: ");
    scanf("%d", &n);
    if (n < 101)
    {
        for (int i = 0; i < n; i++)
        {
            printf("Enter the age of person %d: ", i + 1);
            scanf("%d", &ages[i]);
            total += ages[i];
        }
        avrg = (float)total / n;
        for (int i = 0; i < n; i++)
        {
            if (avrg < ages[i])
                older++;
        }
        printf("Older than average ages are: %d", older);
    }
    else
        printf("Can't consider more than 100 length of array.");
    return 0;
}