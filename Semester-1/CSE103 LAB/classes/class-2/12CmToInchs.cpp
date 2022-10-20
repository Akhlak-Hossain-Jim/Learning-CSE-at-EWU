#include <stdio.h>

int main()
{
    int cm;
    float inches;
    printf("Input the length in cm: ");
    scanf("%d", &cm);
    inches = cm / 2.54;
    printf("%d sm means %finches", cm, inches);
    return 0;
}