// Online C compiler to run C program online
#include <stdio.h>

int main()
{
    int n, reversed[100];
    int arr[100];
    printf("This program is to find the reverse Array of an array.\nEnter the array length: ");
    scanf("%d", &n);
    if (n < 101)
    {
        for (int i = 0; i < n; i++)
        {
            printf("Enter the value for %d place in array: ", i);
            scanf("%d", &arr[i]);
        }
        printf("The array is: ");
        for (int i = 0; i < n; i++)
        {
            printf("%d,", arr[i]);
        }
        for (int i = 0; i < n; i++)
        {
            reversed[n - i - 1] = arr[i];
        }
        printf("The reversed array is: ");
        for (int i = 0; i < n; i++)
        {
            printf("%d,", reversed[i]);
        }
    }
    else
        printf("Can't consider more than 100 length of array.");
    return 0;
}