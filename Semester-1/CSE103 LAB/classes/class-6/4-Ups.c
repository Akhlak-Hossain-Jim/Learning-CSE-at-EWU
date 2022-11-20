#include <stdio.h>

int main()
{
    int temps[7], ups = 0;
    printf("This program  can input last seven days temperature and display in how many days the temperature is increased than that of immediate previous day.\n");
    for (int i = 0; i < 7; i++)
    {
        printf("Enter day %d's temperature: ", i + 1);
        scanf("%d", &temps[i]);
        if (i > 0 && temps[i] > temps[i - 1])
        {
            ups++;
        }
    }
    printf("Temperature increased %d times.", ups);
    return 0;
}