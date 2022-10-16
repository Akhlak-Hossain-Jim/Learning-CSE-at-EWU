#include <stdio.h>

int main()
{
    int r, h;
    float v;
    const float pi = 3.14;
    printf("input the radius\n");
    scanf("%d", &r);
    printf("input the height\n");
    scanf("%d", &h);
    v = pi * r * r * h;
    printf("The volume is %f", v);
    return 0;
}