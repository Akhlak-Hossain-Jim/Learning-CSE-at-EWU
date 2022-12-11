#include <stdio.h>

int main()
{
    int a = 0, b = 0, *pa, *pb, sum;
    pa = &a;
    pb = &b;
    printf("Enter the first value: ");
    scanf("%d", pa);
    printf("Enter the second value: ");
    scanf("%d", pb);
    sum = *pa + *pb;
    printf("%d + %d = %d", *pa, *pb, sum);
    return 0;
}