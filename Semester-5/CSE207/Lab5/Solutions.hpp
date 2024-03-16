#include "../Lab2/SLL.h"
#include "../Lab4/Stack.hpp"
#include "Queue.hpp"

using namespace std;

// Exercise 1
Queue *copy(Queue *qu)
{
    int n = qu->size();
    SLL *sll = new SLL();
    Queue *res = new Queue();

    for (int i = 0; i < n; i++)
    {
        sll->add(qu->front());
        qu->dequeue();
    }
    for (int i = 0; i < n; i++)
    {
        int x = sll->get(i);
        qu->enqueue(x);
        res->enqueue(x);
    }
    return res;
}

void categorizeQueue(Queue *qu)
{
    Queue *Copy = copy(qu);
    Queue *g1 = new Queue();
    Queue *g2 = new Queue();
    Queue *g3 = new Queue();
    Queue *g4 = new Queue();
    while (Copy->size() > 0)
    {
        if (Copy->front() < 18)
            g1->enqueue(Copy->front());
        else if (Copy->front() >= 18 && Copy->front() <= 35)
            g2->enqueue(Copy->front());
        else if (Copy->front() >= 36 && Copy->front() <= 45)
            g3->enqueue(Copy->front());
        else
            g4->enqueue(Copy->front());
        Copy->dequeue();
    }

    cout << "\t\t\tThe group1: ";
    g1->display();
    cout << "\t\t\tThe group2: ";
    g2->display();
    cout << "\t\t\tThe group3: ";
    g3->display();
    cout << "\t\t\tThe group4: ";
    g4->display();
}

Queue *DeleteNegetive(Queue *qu)
{
    Queue *Copy = copy(qu);
    Queue *res = new Queue();
    while (Copy->size() > 0)
    {
        if (Copy->front() > 0)
            res->enqueue(Copy->front());
        Copy->dequeue();
    }
    return res;
}

Queue *StackToQueue(Stack *st)
{
    Queue *res = new Queue();
    while (st->Length() != 0)
    {
        res->enqueue(st->Top());
        st->Pop();
    }
    return res;
}

Queue *ReverseQueue(Queue *qu)
{
    Queue *cp = copy(qu);
    int n = cp->size();
    SLL *sll = new SLL();
    Queue *res = new Queue();
    while (cp->size() != 0)
    {
        sll->addBeginning(cp->front());
        cp->dequeue();
    }
    for (int i = 0; i < n; i++)
    {
        res->enqueue(sll->get(i));
    }
    return res;
}

Stack *QueueToStack(Queue *qu)
{
    Queue *que = copy(qu);
    Stack *res = new Stack();
    while (que->size() != 0)
    {
        res->Push(que->front());
        que->dequeue();
    }
    return res;
}