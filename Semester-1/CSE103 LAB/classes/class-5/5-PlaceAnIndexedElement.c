// Online C compiler to run C program online
#include <stdio.h>

int main()
{
    int n, index, value;
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
        arr[index] = value;
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