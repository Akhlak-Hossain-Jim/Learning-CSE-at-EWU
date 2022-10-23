#include <stdio.h>

int main()
{
    int BS;
    float GS, HRA, DA;
    printf("This program is to output Gross salary.\n");
    printf("Enter the basic salary: ");
    scanf("%d", &BS);
    if (BS <= 10000)
    {
        HRA = 0.20;
        DA = 0.80;
        GS = BS + (BS * HRA) + (BS * DA);
        printf("%f is the Gross salary.", GS);
    }
    else if (BS <= 20000)
    {
        HRA = 0.25;
        DA = 0.90;
        GS = BS + (BS * HRA) + (BS * DA);
        printf("%f is the Gross salary.", GS);
    }
    else
    {
        HRA = 0.30;
        DA = 0.95;
        GS = BS + (BS * HRA) + (BS * DA);
        printf("%f is the Gross salary.", GS);
    }
    return 0;
}