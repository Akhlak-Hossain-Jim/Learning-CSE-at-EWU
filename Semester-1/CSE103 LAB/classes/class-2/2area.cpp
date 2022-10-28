#include <stdio.h>

int main()
{
    int length, breadth, area;
    printf("This program is to find area of a given rectangle.\n");
    printf("Enter the length: ");
    scanf("%d", &length);
    printf("Enter the breadth: ");
    scanf("%d", &breadth);
    area = length * breadth;
    printf("The area is %d.", area);
    return 0;
}
