#include <stdio.h>

int main()
{
    int principle, rate, TIME;
    float interest;
    printf("Input the principle\n");
    scanf("%d", &principle);
    printf("Input the rate\n");
    scanf("%d", &rate);
    printf("Input the time\n");
    scanf("%d", &TIME);
    interest = principle * rate * TIME / 100;
    printf("The simple Interest is %f", interest);
    return 0;
}