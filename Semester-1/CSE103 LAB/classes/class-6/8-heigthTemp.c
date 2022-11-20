#include <stdio.h>

int main()
{
    int temps[7], most = 0, times = 0;
    printf("This program can input last seven days temperature into an array and display the highest temperature. How many days that highest is found.\n");
    for (int i = 0; i < 7; i++)
    {
        printf("Enter day %d's temperature: ", i + 1);
        scanf("%d", &temps[i]);
        if (most < temps[i])
        {
            most = temps[i];
        }
    }
    for (int i = 0; i < 7; i++)
    {
        if (most == temps[i])
        {
            times++;
        }
    }
    printf("%d %d", most, times);
    return 0;
}