
int GCD(int n1, int n2)
{
    if (n2 != 0)

        return GCD(n2, n1 % n2);
    else
        return n1;
}

void printDescendingOrder(int i)
{
    if (i == 1)
    {
        cout << "\t 1";
    }
    else
    {
        cout << "\t" << i;
        printDescendingOrder(--i);
    }
}

void printAscendingOrder(int i)
{
    if (i == 1)
    {
        cout << "\t 1";
    }
    else
    {
        printAscendingOrder(--i);
        cout << "\t" << i + 1;
    }
}

int sumOF = 0;
int sumOfFibonacci(int i, int x, int y)
{
    if (i == x)
        return i;
    else
    {
        sumOfFibonacci(i, y, x + y);
        sumOF += y;
        return sumOF;
    }
}

void deleteRecursion(Node *n, int i)
{
    if (n->ref == NULL && i == 1)
        cout << "No such item";
    else if (n->ref != NULL && i == 1)
    {
        Node *ref = n;
        if (ref->ref->ref == NULL)
            ref->ref = NULL;
        else
        {
            Node *ref2 = ref->ref->ref;
            ref->ref = ref2;
        }
    }
    else
    {
        deleteRecursion(n->ref, i - 1);
    }
}
SLL *deleteNthItemOfSLL(SLL *req, int n)
{
    Node *head = req->getHead();
    deleteRecursion(head, n);
    return req;
}

void sortRecursion(Node *n, int i, int l)
{
    Node *current = n;
    if (n != NULL)
    {
        Node *sm = n;
        Node *temp = sm->ref;
        for (int j = i; j < l; j++)
        {
            if (sm->item > temp->item)
                sm = temp;
            temp = temp->ref;
        }
        if (current == sm)
        {
            sortRecursion(n->ref, i + 1, l);
        }
        else
        {
            sortRecursion(n->ref, i + 1, l);
        }
    }
}