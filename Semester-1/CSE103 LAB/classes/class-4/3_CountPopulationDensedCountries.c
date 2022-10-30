#include <stdio.h>

int main()
{
    int n, area, population, denser = 0;
    float density;
    printf("This program is to find number of population denser countries from some given number countries population and area.\n");
    printf("Enter total number of countries to compare: ");
    scanf("%d", &n);
    if (n > 0)
    {
        for (int i = 0; i < n; i++)
        {
            printf("Enter the area of the country %d: ", i + 1);
            scanf("%d", &area);
            printf("Enter the population of the country %d: ", i + 1);
            scanf("%d", &population);
            density = (float)population / area;
            if (density > 500)
                denser++;
        }
        printf("Number of countries which's population density is more than 500 is: %d", denser);
    }
    else
        printf("Can't compare less then 1 country.");
    return 0;
}