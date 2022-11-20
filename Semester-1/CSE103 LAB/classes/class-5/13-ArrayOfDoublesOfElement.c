#include <stdio.h>

int main()
{
    int value, arr[10];
    printf("This program is to present a special kind of Array.\nTo see it, Enter the first value: ");
    scanf("%d", &value);
    printf("The Array: ");
    for (int i = 0; i < 10; i++)
    {
        if (i == 0)
        {
            arr[i] = value;
        }
        else
        {
            value *= 2;
            arr[i] = value;
        }
        printf("%d  ", arr[i]);
    }
    return 0;
}