#include <stdio.h>

int main()
{
    int a = 0, b = 0, *pa, *pb, help;
    pa = &a;
    pb = &b;
    printf("Enter the first value: ");
    scanf("%d", pa);
    printf("Enter the second value: ");
    scanf("%d", pb);
    printf("First Value=%d\tSecond Value=%d\n", *pa, *pb);
    help = *pa;
    *pa = *pb;
    *pb = help;
    printf("First Value=%d\tSecond Value=%d\n", *pa, *pb);
    return 0;
}