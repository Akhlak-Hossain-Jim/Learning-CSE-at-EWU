#include <stdio.h>

int main()
{
    int n, num, sum = 0;
    double avg;
    printf("This program to find the average of a list of numbers.\nEnter how many number to consider: ");
    scanf("%d", &n);
    for (int i = 1; i <= n; i++)
    {
        printf("Enter the %dno number: ", i);
        scanf("%d", &num);
        sum += num;
    }
    avg = (float)sum / n;
    printf("The average is: %lf", avg);
    return 0;
}