#include <stdio.h>

int main()
{
    int times;
    printf("This program is to print consecutive digits based on inputs.\n");
    printf("Enter a number: ");
    scanf("%d", &times);
    for (int i = 0; i <= times; i++)
        if (i == times)
            printf("%d", i);
        else
            printf("%d, ", i);
    return 0;
}