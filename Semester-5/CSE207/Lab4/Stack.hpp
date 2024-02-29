// #include "../Lab2/Node.h"

class Stack
{
private:
    Node *head = NULL, *ref;
    int length = 0;

public:
    Stack() {}

    void Push(int value)
    {
        Node *neue = new Node(value);
        if (head == NULL)
        {
            head = neue;
            length++;
        }
        else
        {
            Node *temp = head;
            head = neue;
            neue->ref = temp;
            length++;
        }
    }

    void Pop()
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

    int Length()
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
            this->Pop();
        }
    }

    int Top()
    {
        int res;
        if (!(this->isEmpty()))
        {
            return this->head->item;
        }
        else
        {
            cout << "Can't provide you top value of an empty Stack";
            return false;
        }
    }

    Node *TopAddress()
    {
        Node *res;
        if (!(this->isEmpty()))
        {
            return this->head;
        }
        else
        {
            cout << "Can't provide you top value of an empty Stack";
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
            cout << "The Stack is currently empty\n";
    }
};