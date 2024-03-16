// #include "../Lab2/Node.h"

using namespace std;

class Queue
{
private:
    Node *head = NULL, *ref;
    int length = 0;

public:
    Queue() {}

    void enqueue(int value)
    {
        ref = new Node(value);
        if (head == NULL)
        {
            head = ref;
            length++;
        }
        else
        {
            Node *temp = head;
            while (temp->ref != NULL)
            {
                temp = temp->ref;
            }
            temp->ref = ref;
            length++;
        }
    }

    void dequeue()
    {
        if (head != NULL)
        {
            Node *temp = head;
            head = head->ref;
            this->length--;
            delete temp;
        }
        else
            cout << "No data found to remove";
    }

    int size()
    {
        return this->length;
    }

    bool isEmpty()
    {
        return length == 0;
    }

    void destroy()
    {
        while (this->length != 0)
        {
            this->dequeue();
        }
    }

    int front()
    {
        int res;
        if (!(this->isEmpty()))
        {
            return this->head->item;
        }
        else
        {
            cout << "Can't provide you top value of an empty Queue";
            return false;
        }
    }

    Node *address()
    {
        Node *res;
        if (!(this->isEmpty()))
        {
            return this->head;
        }
        else
        {
            cout << "Can't provide you top value of an empty Queue";
            return NULL;
        }
    }

    int rare()
    {
        int res;
        if (!(this->isEmpty()))
        {
            return this->head->item;
        }
        else
        {
            cout << "Can't provide you top value of an empty Queue";
            return false;
        }
    }

    Node *rareAddress()
    {
        Node *res;
        if (!(this->isEmpty()))
        {
            return this->head;
        }
        else
        {
            cout << "Can't provide you top value of an empty Queue";
            return NULL;
        }
    }

    void display()
    {
        if (length > 0)
        {

            Node *temp = head;
            while (temp != NULL)
            {
                cout << temp->item << "\t";
                temp = temp->ref;
            }
            cout << endl;
        }
        else
            cout << "The Queue is currently empty\n";
    }
};