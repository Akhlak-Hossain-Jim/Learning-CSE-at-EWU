#include <stdio.h>

int main()
{
    int n, age, teens = 0;
    printf("This program is to find number of teens.\n");
    printf("Enter the number of peoples' age: ");
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        printf("Enter person %d's age: ", i);
        scanf("%d", &age);
        if (age > 12 && age < 20)
        {
            teens += 1;
        }
    }
    printf("%d of %d are teenagers.", teens, n);
    return 0;
}