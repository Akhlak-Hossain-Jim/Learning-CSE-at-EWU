#include <stdio.h>

int main()
{
    int n, result = 0;
    double cgpa;
    printf("This program is to find group of people secured at least 3.5 CGPA.\n");
    printf("Enter the total number of students to consider: ");
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        printf("Enter person %d's CGPA: ", i + 1);
        scanf("%lf", &cgpa);
        if (3.5 <= cgpa)
            result++;
    }
    printf("%d People secured at least 3.5 CGPA", result);
    return 0;
}