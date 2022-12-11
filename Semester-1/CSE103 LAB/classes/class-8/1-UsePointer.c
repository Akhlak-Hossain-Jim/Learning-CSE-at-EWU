#include <stdio.h>

int main()
{
    int v = 0, *p;
    p = &v;
    printf("v is %d by reference\n", v);
    *p = 5;
    printf("Now v is %d by pointer", *p);
    return 0;
}