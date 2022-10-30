#include <stdio.h>

int main()
{
    int n, mark, passed = 0;
    double Percentage;
    printf("This program is to find Percentage of passed students from some students given number.\n");
    printf("Enter total number of students to compare: ");
    scanf("%d", &n);
    if (n > 0)
    {
        for (int i = 0; i < n; i++)
        {
            printf("Enter the mark of student %d: ", i + 1);
            scanf("%d", &mark);
            if (mark > 59)
                passed++;
        }
        Percentage = (double)passed / n;
        printf("Passed Students Percentage: %lf", Percentage);
    }
    else
        printf("Can't compare less then 1 student.");
    return 0;
}