#include <stdio.h>

int main()
{
    int n, arr[100], small, index;
    printf("This program is to find the smallest value and it\'s index from the entered Array.\nEnter the array length: ");
    scanf("%d", &n);
    if (n < 101)
    {
        for (int i = 0; i < n; i++)
        {
            printf("Enter the value for %d index in the array: ", i);
            scanf("%d", &arr[i]);
            if (i == 0)
            {
                small = arr[i];
                index = i;
            }
            else if (small > arr[i])
            {
                small = arr[i];
                index = i;
            }
        }
        printf("The smallest value is %d at index %d.", small, index);
    }
    else
        printf("This program is not considering more than 100 length of array.");
    return 0;
}