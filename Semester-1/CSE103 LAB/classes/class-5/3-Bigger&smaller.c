#include <stdio.h>

int main()
{
    int n, big = 0, small = 0;
    int arr[100];
    printf("This program is to find the Biggest and the Smallest value of an array.\nEnter the array length: ");
    scanf("%d", &n);
    if (n < 101)
    {
        for (int i = 0; i < n; i++)
        {
            printf("Enter the value for %d place in array: ", i);
            scanf("%d", &arr[i]);
        }
        for (int i = 0; i < n; i++)
        {
            if (i == 0)
            {
                if (big < arr[i])
                    big = arr[i];
                else if (small > arr[i])
                    small = arr[i];
            }
            else
            {
                if (big < arr[i])
                    big = arr[i];
                else if (small > arr[i])
                    small = arr[i];
            }
        }
        printf("Biggest value is: %d\nSmallest value is: %d", big, small);
    }
    else
        printf("Can't consider more than 100 length of array.");
    return 0;
}