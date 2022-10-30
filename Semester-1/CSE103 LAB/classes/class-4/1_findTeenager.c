#include <stdio.h>

int main()
{
    int n, age, child = 0, teens = 0, senior = 0;
    printf("This program is to find number of teens.\n");
    printf("Enter the number of peoples' age: ");
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        printf("Enter person %d's age: ", i + 1);
        scanf("%d", &age);
        if (age > 12 && age < 19)
        {
            teens += 1;
        }
        else if (age > 12 && age < 19)
        {
            teens += 1;
        }
    }
    printf("%d of %d are teenagers.", teens, n);
    return 0;
}