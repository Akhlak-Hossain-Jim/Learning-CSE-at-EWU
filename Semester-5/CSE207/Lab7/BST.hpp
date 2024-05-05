#include <iostream>
using namespace std;

class Node
{
public:
    int item;
    Node *L;
    Node *R;
    Node(int v)
    {
        this->item = v;
        L = R = NULL;
    }
};

class BST
{
private:
    Node *root = NULL;

    // static Node *Smallest, *Largest;

public:
    static Node *insert(Node *r, int value)
    {
        if (r == NULL)
        {
            r = new Node(value);
        }
        else if (value >= r->item)
        {
            r->R = insert(r->R, value);
        }
        else
        {
            r->L = insert(r->L, value);
        }

        return r;
    }

    static Node *insertNode(Node *r, Node *n)
    {
        if (r == NULL)
        {
            r = n;
        }
        else if (n->item >= r->item)
        {
            r->R = insertNode(r->R, n);
        }
        else
        {
            r->L = insertNode(r->L, n);
        }

        return r;
    }

    static void search(Node *r, int val)
    {
        if (r == NULL)
        {
            cout << "\t " << val << " is not in the tree.";
        }
        else if (val > r->item)
        {
            search(r->R, val);
        }
        else if (val < r->item)
        {
            search(r->L, val);
        }
        else if (val == r->item)
        {
            cout << "Found " << val << " in the Binary Search Tree.";
        }
    }

    static void InOrderDisplay(Node *r, int i)
    {
        if (i == 0 && r == NULL)
        {
            cout << "No data found, Add some data to view the data";
        }
        else if (r != NULL)
        {
            InOrderDisplay(r->L, i + 1);
            cout << "\t" << r->item;
            InOrderDisplay(r->R, i + 1);
        }
        else
            return;
    }

    static void PreOrderDisplay(Node *r, int i)
    {
        if (i == 0 && r == NULL)
        {
            cout << "No data found, Add some data to view the data";
        }
        else if (r != NULL)
        {
            cout << "\t" << r->item;
            PreOrderDisplay(r->L, i + 1);
            PreOrderDisplay(r->R, i + 1);
        }
    }

    static void PostOrderDisplay(Node *r, int i)
    {
        if (i == 0 && r == NULL)
        {
            cout << "No data found, Add some data to view the data";
        }
        else if (r != NULL)
        {
            PostOrderDisplay(r->L, i + 1);
            PostOrderDisplay(r->R, i + 1);
            cout << "\t" << r->item;
        }
    }

    static Node *Delete(Node *r, int val)
    {
        if (r == NULL)
        {
            cout << "\t " << val << " is not present in the tree.";
        }
        else if (val > r->item)
        {
            r->R = Delete(r->R, val);
        }
        else if (val < r->item)
        {
            r->L = Delete(r->L, val);
        }
        else if (val == r->item)
        {
            cout << "Found " << val << " in the Binary Search Tree. Performing Deletion Operation...";
            if (r->L == NULL && r->R == NULL)
                return NULL;
            else if (r->L == NULL || r->R == NULL)
            {
                if (r->L == NULL)
                    return r->R;
                else if (r->R == NULL)
                    return r->L;
            }
            else if (r->L != NULL && r->R != NULL)
            {
                Node *rootD = r->R;
                rootD = insertNode(rootD, r->L);
                return rootD;
            }
        }
        return r;
    }

    static Node *FindSmall(Node *r, int i)
    {
        Node *res = r;
        if (i == 0 && r == NULL)
            cout << "No data found, insert some items first";
        else if (r != NULL)
        {
            Node *lRes = FindSmall(r->L, i = 1);
            Node *rRes = FindSmall(r->R, i = 1);
            if ((res->item) > (lRes->item))
            {
                res = lRes;
            }
            if ((res->item) > (rRes->item))
            {
                res = rRes;
            }
        }
        return res;
    }

    static Node *FindLarge(Node *r, int i)
    {
        Node *res = r;
        if (i == 0 && r == NULL)
            cout << "No data found, insert some items first";
        else if (r != NULL)
        {
            Node *lRes = FindLarge(r->L, i = 1);
            Node *rRes = FindLarge(r->R, i = 1);
            if ((res->item) < (lRes->item))
            {
                res = lRes;
            }
            if ((res->item) < (rRes->item))
            {
                res = rRes;
            }
        }
        return res;
    }

    static int treeHeight(Node *r, int i)
    {
        if (i == 0 && r == NULL)
            return 0;
        else if (r != NULL)
        {
            int lD = treeHeight(r->L, i);
            int rD = treeHeight(r->R, i);
            if (lD > rD)
                return (lD + 1);
            else
                return (rD + 1);
        }
        return 0;
    }

    static void ItemPath(Node *r, int val)
    {
        if (r == NULL)
        {
            cout << "\t Ops! Looks like" << val << " was not inserted in the tree.";
        }
        else if (val > r->item)
        {
            cout << "\t" << r->item;
            ItemPath(r->R, val);
        }
        else if (val < r->item)
        {
            cout << "\t" << r->item;
            ItemPath(r->L, val);
        }
        else if (val == r->item)
        {
            cout << "\t" << r->item;
        }
    }
};