#include <stdio.h>

int main()
{
    int sub1, sub2, sub3, sub4, sub5, total, average;
    printf("This program is to calculate total and average of entered 5 subjects number.\n");
    printf("Enter the number of subject 1: ");
    scanf("%d", &sub1);
    printf("Enter the number of subject 2: ");
    scanf("%d", &sub2);
    printf("Enter the number of subject 3: ");
    scanf("%d", &sub3);
    printf("Enter the number of subject 4: ");
    scanf("%d", &sub4);
    printf("Enter the number of subject 5: ");
    scanf("%d", &sub5);
    total = sub1 + sub2 + sub3 + sub4 + sub5;
    average = (total * 100) / 500;
    printf("Total number = %d\nIt is %dpercent of your total marks", total, average);
    return 0;
}