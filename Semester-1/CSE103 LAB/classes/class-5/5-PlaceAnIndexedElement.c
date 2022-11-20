#include <stdio.h>

int main()
{
    int n, index, value, store1, store2;
    int arr[100];
    printf("This program is to place an element to a specific index of an array.\nEnter the array length: ");
    scanf("%d", &n);
    if (n < 101)
    {
        for (int i = 0; i < n; i++)
        {
            printf("Enter the value for %d place in array: ", i);
            scanf("%d", &arr[i]);
        }
        printf("Enter the index to place the value: ");
        scanf("%d", &index);
        printf("Enter the value: ");
        scanf("%d", &value);
        n++;
        store1 = arr[index];
        arr[index] = value;
        for (int i = index + 1; i < n; i++)
        {
            store2 = arr[i];
            arr[i] = store1;
            store1 = store2;
        }
        printf("The array is: ");
        for (int i = 0; i < n; i++)
        {
            printf("%d,", arr[i]);
        }
    }
    else
        printf("Can't consider more than 100 length of array.");
    return 0;
}