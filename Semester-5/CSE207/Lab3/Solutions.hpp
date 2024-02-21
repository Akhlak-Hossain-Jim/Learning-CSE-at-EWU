#include "../Lab2/SLL.h"

// Problem 1 solution
int smallestValue(SLL *sll)
{
    int res = sll->get(0);
    int n = sll->size();
    for (int i = 1; i < n; i++)
    {
        if (sll->get(i) < res)
            res = sll->get(i);
    }
    return res;
}

// Problem 2 solution
void removeSmallerThanZero(SLL *sll)
{
    int n = sll->size(), i = 0;
    while (i < n)
    {
        if (sll->get(i) < 0)
        {
            sll->remove(i);
            n--;
        }
        else
            i++;
    }
}