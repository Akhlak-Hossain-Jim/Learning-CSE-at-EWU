#include <iostream>
#include "Node.h"
using namespace std;

class SLL
{
private:
    Node *head = NULL, *ref;
    int length = 0;

public:
    SLL() {}

    void add(int value)
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

    void addBeginning(int value)
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

    void addTo(int position, int value)
    {
        try
        {
            if (position == 0)
                this->addBeginning(value);
            else if (position < length - 1)
            {
                Node *neue = new Node(value);
                Node *prev = head, *current = head;

                for (int i = 1; i <= position; i++)
                {
                    prev = current;
                    current = current->ref;
                }
                prev->ref = neue;
                neue->ref = current;
                length++;
            }
            else if (position == (length))
                this->add(value);
            else
                throw invalid_argument("Query length is 'Out of bound'.");
        }
        catch (const std::exception &e)
        {
            std::cerr << e.what() << "\n\t\t\t";
        }
    }

    bool contains(int value)
    {
        Node *temp = head;
        while (temp != NULL)
        {
            if (temp->item == value)
            {
                return true;
            }
            else
            {
                temp = temp->ref;
            }
        }
        return false;
    }

    int size()
    {
        return length;
    }

    bool isEmpty()
    {
        return length == 0;
    }

    int get(int position)
    {
        int res;
        if (((length > 0) && (position < length) && (position >= 0)))
        {
            Node *temp = head;
            for (int i = 1; i <= position; i++)
            {
                temp = temp->ref;
            }
            res = temp->item;
            return res;
        }
        else
            throw invalid_argument("No Item fond at the provided index: " + position);
    }

    Node *getHead()
    {
        return head;
    }
    void setHead(Node *n)
    {
        head = n;
    }

    int indexOf(int value)
    {
        Node *temp = head;
        int indx = 0;
        bool found = false;
        while (temp != NULL)
        {
            if (temp->item == value)
            {
                found = true;
                break;
            }
            else
            {
                indx++;
                temp = temp->ref;
            }
        }
        if (found)
            return indx;
        else
            throw invalid_argument("Item not found");
    }

    void removeFirst()
    {
        try
        {
            if (head != NULL)
            {
                head = head->ref;
                this->length--;
            }
            else
                throw invalid_argument("No data found to remove");
        }
        catch (const std::exception &e)
        {
            std::cerr << e.what() << '\n';
        }
    }

    void removeLast()
    {
        try
        {
            if (head != NULL)
            {
                if (length == 1)
                {
                    head = NULL;
                    this->length--;
                }
                else
                {
                    Node *temp = head;
                    Node *last;
                    while (temp->ref != NULL)
                    {
                        last = temp;
                        temp = temp->ref;
                    }
                    last->ref = NULL;
                    this->length--;
                }
            }
            else
                throw invalid_argument("No data found to remove");
        }
        catch (const exception &e)
        {
            cerr << e.what() << '\n';
        }
    }

    void remove(int position)
    {
        try
        {
            if (head != NULL && (position < length))
            {
                if (length == 0)
                {
                    head = NULL;
                    this->length--;
                }
                else if (position == 0)
                {
                    this->removeFirst();
                }
                else if (position == length - 1)
                {
                    this->removeLast();
                }
                else
                {
                    Node *temp = head;
                    for (int i = 1; i < position; i++)
                    {
                        temp = temp->ref;
                    }
                    Node *next = temp->ref->ref;
                    temp->ref = next;
                    this->length--;
                }
            }
            else
                throw invalid_argument("No data found to remove");
        }
        catch (const exception &e)
        {
            cerr << e.what() << '\n';
        }
    }

    void reverse()
    {
        if (length > 0)
        {
            Node *nH = NULL;
            Node *temp = head;
            for (int i = 0; i < length; i++)
            {
                Node *iItem = temp, *iPrev;
                for (int j = 0; j < length - 1 - i; j++)
                {
                    iPrev = iItem;
                    iItem = iItem->ref;
                }
                if (nH == NULL)
                {
                    nH = iItem;
                    iPrev->ref = NULL;
                }
                else
                {
                    Node *temp3 = nH;
                    while (temp3->ref != NULL)
                    {
                        temp3 = temp3->ref;
                    }
                    temp3->ref = iItem;
                    iPrev->ref = NULL;
                }
            }
            this->head = nH;
        }
        else
            cerr << "Add some element first to do reverse operation";
    }

    void sort()
    {
        if (length > 0)
        {
            for (int i = 0; i < this->length - 1; i++)
            {
                Node *current = this->head, *next = current->ref;
                for (int j = 0; j < this->length - i - 1; j++)
                {
                    if (current->item > next->item)
                    {
                        int tem = current->item;
                        current->item = next->item;
                        next->item = tem;
                    }
                    current = next;
                    next = next->ref;
                }

                // for (int j = 0; j < this->length - i - 1; j++)
                // {
                //     if (this->get(j) > this->get(j + 1))
                //     {
                //         int tem = this->get(j);
                //         this->replace(j, this->get(j + 1));
                //         this->replace(j + 1, tem);
                //     }
                // }
            }
        }
        else
            cerr << "Add some items first to perform sort";
    }

    void replace(int index, int value)
    {
        Node *temp = this->head;
        for (int i = 0; i <= index; i++)
        {
            temp = temp->ref;
        }
        temp->item = value;
    }

    void swap(int i1, int i2)
    {
        if ((i1 >= 0 && i1 < length) && (i2 >= 0 && i2 < length))
        {
            Node *i1P, *i1C = this->head;
            for (int i = 1; i <= i1; i++)
            {
                i1P = i1C;
                i1C = i1C->ref;
            }
            Node *i2P, *i2C = this->head;
            for (int i = 1; i <= i2; i++)
            {
                i2P = i2C;
                i2C = i2C->ref;
            }
            Node *temp = i1C->ref;
            i2P->ref = i1C;
            i1C->ref = i2C->ref;
            i1P->ref = i2C;
            i2C->ref = temp;
        }
        else
            cout << "One of the index is out of bound";
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
            cout << "Add some value to perform display\n";
    }
};