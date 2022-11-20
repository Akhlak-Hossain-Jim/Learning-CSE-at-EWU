#include <stdio.h>

int main()
{
    int rows, cols, A[100][100], B[100][100], C[100][100];
    printf("This program is to find the subtract of two matrix.\nPlease be aware, we are taking two matrixs with a same row and column \nEnter the row number/s of the matrixs: ");
    scanf("%d", &rows);
    printf("Enter the column number/s of the matrixs: ");
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
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                printf("Enter the value of B%d%d: ", i + 1, j + 1);
                scanf("%d", &B[i][j]);
            }
        }
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        for (int i = 0; i < rows; i++)
        {
            printf("\n");
            for (int j = 0; j < cols; j++)
            {
                printf("%d   ", C[i][j]);
            }
        }
    }
    else
        printf("This program is not considering more than 100x100 matrix.");
    return 0;
}