#include <iostream>
using namespace std;

class Node
{
public:
    int item;
    Node *ref;
    Node() {}
    Node(int item)
    {
        this->item = item;
        ref = NULL;
    }
};