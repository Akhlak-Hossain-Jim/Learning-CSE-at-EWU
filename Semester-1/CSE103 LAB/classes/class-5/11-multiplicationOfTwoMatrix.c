#include <stdio.h>

int main()
{
    int dimension = 3, sum, A[3][3], B[3][3], C[3][3];
    printf("This program is to find the multiplication of two 3x3 matrix.\n");
    for (int i = 0; i < dimension; i++)
    {
        for (int j = 0; j < dimension; j++)
        {
            printf("Enter the value of A%d%d: ", i + 1, j + 1);
            scanf("%d", &A[i][j]);
        }
    }
    for (int i = 0; i < dimension; i++)
    {
        for (int j = 0; j < dimension; j++)
        {
            printf("Enter the value of B%d%d: ", i + 1, j + 1);
            scanf("%d", &B[i][j]);
        }
    }
    for (int i = 0; i < dimension; i++)
    {
        for (int j = 0; j < dimension; j++)
        {
            sum = 0;
            printf("\nC%d%d= ", i + 1, j + 2);
            for (int k = 0; k < dimension; k++)
            {
                sum += A[i][k] * B[k][j];
                if (k == dimension - 1)
                {
                    printf("A%d%d*B%d%d", i + 1, k + 1, k + 1, j + 1);
                }
                else
                {
                    printf("A%d%d*B%d%d+", i + 1, k + 1, k + 1, j + 1);
                }
            }
            C[i][j] = sum;
        }
    }
    for (int i = 0; i < dimension; i++)
    {
        printf("\n");
        for (int j = 0; j < dimension; j++)
        {
            printf("%d   ", C[i][j]);
        }
    }
    return 0;
}