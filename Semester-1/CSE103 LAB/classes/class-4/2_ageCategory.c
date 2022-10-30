#include <stdio.h>

int main()
{
    int n, age, childs = 0, teens = 0, seniors = 0;
    printf("This program is to find group of childs, teens, seniors.\n");
    printf("Enter the number of peoples' age: ");
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        printf("Enter person %d's age: ", i + 1);
        scanf("%d", &age);
        if (age < 13)
            childs++;
        else if (age > 12 && age < 20)
            teens++;
        else if (age > 64)
            seniors++;
    }
    printf("Child: %d\nTeenager: %d\nSenior Citizen:%d", childs, teens, seniors);
    return 0;
}