#include <stdio.h>

int main()
{
    int radius, length, volume_of_cube;
    float volume_of_sphere;
    printf("This program is to calculate the volume of a sphere and a cube.\n");
    printf("Enter the radius: ");
    scanf("%d", &radius);
    printf("Enter the length: ");
    scanf("%d", &length);
    volume_of_sphere = (4 * 3.14 * radius * radius * radius) / 3;
    volume_of_cube = length * length * length;
    printf("Volume of the sphere with a radius of %d unit is %f unit cube.\nVolume of the cube with a length of %d unit is %d unit cube", radius, volume_of_sphere, length, volume_of_cube);
    return 0;
}