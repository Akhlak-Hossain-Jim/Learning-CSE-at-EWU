#include <stdio.h>

int main()
{
    int rows, cols, A[100][100], B[100][100];
    printf("This program is to find the transpose matrix.\nEnter the row number/s of the matrix: ");
    scanf("%d", &rows);
    printf("Enter the column number/s of the matrix: ");
    scanf("%d", &cols);
    if (rows < 101 && cols < 101)
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                printf("Enter the value of A%d%d: ", i + 1, j + 1);
                scanf("%d", &A[i][j]);
            }
        }
        for (int i = 0; i < cols; i++)
        {
            for (int j = 0; j < rows; j++)
            {
                B[i][j] = A[j][i];
                printf("%d   ", B[i][j]);
            }
            printf("\n");
        }
    }
    else
        printf("This program is not considering more than 100x100 matrix.");
    return 0;
}