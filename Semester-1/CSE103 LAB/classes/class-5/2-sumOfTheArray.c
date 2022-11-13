#include <stdio.h>

int main()
{
    int n, sum = 0;
    int arr[100];
    printf("This program is to find the sum of an array.\nEnter the array length: ");
    scanf("%d", &n);
    if (n < 101)
    {
        for (int i = 0; i < n; i++)
        {
            printf("Enter the value for %d place in array: ", i);
            scanf("%d", &arr[i]);
            sum += arr[i];
        }
        printf("The sum of the array is: %d", sum);
    }
    else
        printf("Can't consider more than 100 length of array.");
    return 0;
}