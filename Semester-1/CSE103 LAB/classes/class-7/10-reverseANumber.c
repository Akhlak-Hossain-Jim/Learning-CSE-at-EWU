#include <stdio.h>

int revFunc(int num, int rev);

int main()
{
    int num, rev;
    printf("This program to read an integer number and print the reverse of that number using recursion.\nEnter the number to reverse: ");
    scanf("%d", &num);
    rev = revFunc(num, 0);
    printf("Reverse of digits of %d = %d", num, rev);
    return 0;
}

int revFunc(int num, int rev)
{
    if (num == 0)
    {
        return 0;
    }
    else
    {
        return revFunc(num / 10, rev * 10 + num % 10);
    }
}