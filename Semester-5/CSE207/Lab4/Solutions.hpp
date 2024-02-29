#include "../Lab2/SLL.h"
#include "Stack.hpp"

using namespace std;

// Exercise 2
Stack *copy(Stack *st)
{
    int n = st->Length();
    SLL *sll = new SLL();
    Stack *res = new Stack();
    for (int i = 0; i < n; i++)
    {
        sll->add(st->Top());
        st->Pop();
    }
    for (int i = n - 1; i >= 0; i--)
    {
        int x = sll->get(i);
        st->Push(x);
        res->Push(x);
    }
    return res;
}

// Exercise 3
void ConvertToBinary(int value)
{
    Stack *st = new Stack();
    int x = abs(value);
    while (x != 0)
    {
        st->Push(x % 2);
        x = x / 2;
    }
    while (st->Length() != 0)
    {
        cout << st->Top();
        st->Pop();
    }
}

// Exercise 4
void ReverseStack(Stack *st)
{
    SLL *sll = new SLL();
    while (st->Length() != 0)
    {
        sll->add(st->Top());
        st->Pop();
    }
    while (sll->size() != 0)
    {
        st->Push(sll->get(0));
        sll->removeFirst();
    }
}

// Exercise 5
void ParenthesisParsing(string str)
{
    bool res = true;
    Stack *st = new Stack();
    int n = str.length(), i;
    for (i = 0; i < n; i++)
    {
        if (str[i] == '(')
            st->Push(1);
        else if (str[i] == '{')
            st->Push(2);
        else if (str[i] == '[')
            st->Push(3);
        else if (str[i] == ')')
        {
            if (((st->Length() != 0) && (st->Top() == 1)))
            {
                st->Pop();
            }
            else
            {
                res = false;
                break;
            }
        }
        else if (str[i] == '}')
        {
            if (((st->Length() != 0) && (st->Top() == 2)))
            {
                st->Pop();
            }
            else
            {
                res = false;
                break;
            }
        }
        else if (str[i] == ']')
        {
            if (((st->Length() != 0) && (st->Top() == 3)))
            {
                st->Pop();
            }
            else
            {
                res = false;
                break;
            }
        }
    }
    if (res && st->Length() == 0)
        cout << "Equation Bracket pair is correct.";
    else
        cout << "Equation Bracket pair is wrong.";
}