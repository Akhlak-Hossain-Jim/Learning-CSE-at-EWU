#include <stdio.h>

int main()
{
    int temps[7], total = 0;
    float avrg;
    printf("This program can input last seven days temperature into an array and display the average temperature.\n");
    for (int i = 0; i < 7; i++)
    {
        printf("Enter day %d's temperature: ", i + 1);
        scanf("%d", &temps[i]);
        total += temps[i];
    }
    avrg = (float)total / 7;
    printf("Average temperature = %f", avrg);
    return 0;
}