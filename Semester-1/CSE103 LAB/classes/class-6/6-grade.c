#include <stdio.h>

int main()
{
    int results[100], grades[4] = {0, 0, 0, 0}, n, most = 0, index;
    char GRADE[4] = {'A', 'B', 'C', 'D'};
    printf("This program  can input some students marks and display which grades are achieved by most of the students (Grades are A, B, C, and D)\nEnter the array length: ");
    scanf("%d", &n);
    if (n < 101)
    {
        for (int i = 0; i < n; i++)
        {
            printf("Enter the result of person %d: ", i + 1);
            scanf("%d", &results[i]);
            if (results[i] >= 90 && results[i] <= 100)
            {
                grades[0]++;
                continue;
            }
            else if (results[i] >= 80 && results[i] <= 89)
            {
                grades[1]++;
                continue;
            }
            else if (results[i] >= 70 && results[i] <= 79)
            {
                grades[2]++;
                continue;
            }
            else if (results[i] >= 60 && results[i] <= 69)
            {
                grades[3]++;
                continue;
            }
        }
        for (int i = 0; i < 4; i++)
        {
            if (most < grades[i])
            {
                most = grades[i];
                index = i;
            }
        }
        printf("Most people got.\n%c", GRADE[index]);
    }
    else
        printf("Can't consider more than 100 length of array.");
    return 0;
}