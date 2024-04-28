
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
    if (n != NULL && i < l)
    {
        Node *sm = n;
        Node *smPrev = NULL;
        Node *prev = NULL;
        Node *temp = sm->ref;
        for (int j = i; j < l - 1; j++)
        {
            if (sm->item > temp->item)
            {
                sm = temp;
                smPrev = prev;
            }
            prev = temp;
            temp = temp->ref;
        }
        cout << "\t" << sm->item;
        if (current == sm)
        {
            sortRecursion(n->ref, i + 1, l);
        }
        else
        {
            if (smPrev == NULL)
            {
                Node *smr = sm->ref;
                current->ref = sm->ref;
                sm->ref = current;
                n = sm;
            }
            else
            {
                Node *ct = current;
                Node *ctr = current->ref;
                smPrev->ref = current;
                current->ref = sm->ref;
                sm->ref = ctr;
                n = sm;
            }
            sortRecursion(n->ref, i + 1, l);
            if (i == 0)
            {
                current->ref = NULL;
            }
        }
    }
}
SLL *sortedList(SLL *req)
{
    Node *head = req->getHead();
    sortRecursion(head, 0, req->size());
    return req;
}