#include <stdio.h>

int main()
{
    int n, index;
    int arr[100];
    printf("This program is to delete an element with a specific index from an array.\nEnter the array length: ");
    scanf("%d", &n);
    if (n < 101)
    {
        for (int i = 0; i < n; i++)
        {
            printf("Enter the value for %d index in the array: ", i);
            scanf("%d", &arr[i]);
        }
        printf("Enter the index of the value to be removed: ");
        scanf("%d", &index);
        n--;
        for (int i = index; i < n; i++)
        {
            arr[i] = arr[i + 1];
        }
        printf("The array is: ");
        for (int i = 0; i < n; i++)
        {
            printf("%d  ", arr[i]);
        }
    }
    else
        printf("Can't consider more than 100 length of array.");
    return 0;
}