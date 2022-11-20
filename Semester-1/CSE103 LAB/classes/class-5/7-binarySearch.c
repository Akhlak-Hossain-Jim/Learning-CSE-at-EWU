#include <stdio.h>

int main()
{
    int n, step = 0, searchItem, searchIndex, mod;
    int arr[100];
    printf("This program is to find an element from an array by binary search.\nPlease be aware, the Array have to be sorted in ascending order. Or it might not work as expected.\nEnter the array length: ");
    scanf("%d", &n);
    if (n < 101)
    {
        for (int i = 0; i < n; i++)
        {
            printf("Enter the value for %d index in the array: ", i);
            scanf("%d", &arr[i]);
        }
        printf("Enter the index of the value to be searched: ");
        scanf("%d", &searchItem);
        searchIndex = n / 2;
        while (searchIndex >= 0 && searchIndex < n)
        {
            step++;
            if (arr[searchIndex] == searchItem)
            {
                printf("Found the item %d in the array after %d steps at index of %d.", searchItem, step, searchItem);
                break;
            }
            else
            {
                mod = searchIndex / 2;
                if (arr[searchIndex] > searchItem)
                {
                    searchIndex /= 2;
                }
                else
                {
                    searchIndex += mod;
                }
            }
        }
        if (searchIndex < 1)
            printf("Item not found.");
    }
    else
        printf("Can't consider more than 100 length of array.");
    return 0;
}