#include <stdio.h>

int main()
{
    int radius, length, volumeL;
    float volumeR;
    printf("Input the radius: ");
    scanf("%d", &radius);
    printf("Input the length: ");
    scanf("%d", &length);
    volumeR = (4 * 3.14 * radius * radius * radius) / 3;
    volumeL = length * length * length;
    printf("Volume of sphere with a radius of %d unit is %f unit cube \nVolume of cube with a length of %d unit is %d unit cube", radius, volumeR, length, volumeL);
    return 0;
}