#include <stdio.h>

int main()
{
    int n, search, result;
    int arr[100];
    printf("This program is to find a number from an array by linear search\nEnter the array length: ");
    scanf("%d", &n);
    if (n < 101)
    {
        for (int i = 0; i < n; i++)
        {
            printf("Enter the value for %d place in array: ", i);
            scanf("%d", &arr[i]);
        }
        printf("Enter the value to find: ");
        scanf("%d", &search);
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == search)
            {
                printf("Found the %d value at the index of %d in the array.", search, i);
                break;
            }
            else if (arr[i] != search && i == n - 1)
                printf("No item found as %d.", search);
        }
    }
    else
        printf("Can't consider more than 100 length of array.");
    return 0;
}