// #include "../Lab2/SLL.h"
#include "Solutions.hpp"

using namespace std;

int main()
{
    SLL *sll = new SLL();
    int input = 0;
    cout << "Creating an Linked List...\nAlmost there...\n";
    while (input != -1)
    {
        switch (input)
        {
        case 0:
        {
            cout << "\n\n";
            cout << "\tChoose an option from below:\n";
            cout << "\t\t01. Add an item\n";
            cout << "\t\t02. Traverse and get Smallest value\n";
            cout << "\t\t03. Traverse and remove negative nodes\n";
            cout << "\t\t04. Traverse and removes next of negative node.\n";
            cout << "\t\t05. Append another List.\n";
            cout << "\t\t06. Swap two nodes\n";
            cout << "\t\t14. Display all item from the list\n";
            cout << "\t\t100. Exit the program\n";
            cout << "\n\t\tEnter an option(Integer value): ";
            cin >> input;
            break;
        }
        case 1:
        {
            int add;
            cout << "\n\n\t\t\tEnter an Integer value to add: ";
            cin >> add;
            sll->add(add);
            cout << "\t\t\t";
            sll->display();
            input = 0;
            break;
        }
        case 2:
        {
            if (!(sll->isEmpty()))
            {
                cout << "\n\n\t\t\tPrevious:\t";
                sll->display();
                cout << "\t\t\tPerforming traverse operation operation..." << endl;
                sll->reverse();
                cout << "\t\t\tNew     :\t";
                sll->display();
                cout << "\t\t\tLooking for smallest ...\n\t\t\tThe smallest value is: " << smallestValue(sll);
            }
            else
                cout << "Add some items first to perform traverse and getting smallest value.";
            input = 0;
            break;
        }
        case 3:
        {
            if (!(sll->isEmpty()))
            {
                cout << "\n\n\t\t\tPrevious:\t";
                sll->display();
                cout << "\t\t\tPerforming traverse operation operation..." << endl;
                sll->reverse();
                cout << "\t\t\tNew     :\t";
                sll->display();
                cout << "\t\t\tLooking for negative values and removing them ...\n";
                removeSmallerThanZero(sll);
                cout << "\t\t\tNew     :\t";
                sll->display();
            }
            else
                cout << "Add some items first to perform traverse and remove negative nodes";
            input = 0;
            break;
        }
        case 4:
        {
            if (!(sll->isEmpty()))
            {
                cout << "\n\n\t\t\tPrevious:\t";
                sll->display();
                cout << "\t\t\tPerforming traverse operation operation..." << endl;
                sll->reverse();
                cout << "\t\t\tNew     :\t";
                sll->display();
                cout << "\t\t\tLooking for negative values and removing them ...\n";
                removeNextOfZero(sll);
                cout << "\t\t\tNew     :\t";
                sll->display();
            }
            else
                cout << "Add some items first to perform traverse and remove next of negative nodes";
            input = 0;
            break;
        }
        case 5:
        {
            cout << "\n\n\t\tCreating a new list... \n\t\t\tEnter a list length: ";
            int len;
            cin >> len;
            SLL *sll2 = new SLL();
            for (int i = 0; i < len; i++)
            {
                int te;
                cout << "\t\t\tEnter the " << i + 1 << " th value: ";
                cin >> te;
                sll2->add(te);
            }
            cout << "\n\n\t\tThe list: \n\t\t\t";
            sll2->display();
            cout << "\n\n\t\tAppending the list... ";
            for (int i = 0; i < len; i++)
            {
                sll->add(sll2->get(i));
            }
            cout << "\n\t\t\tList becomes:\n\t\t\t";
            sll->display();
            input = 0;
            break;
        }
        case 6:
        {
            cout << "\n\n\t\t\t";
            if (!(sll->isEmpty()))
            {
                int i1, i2;
                cout << "\n\t\t\tEnter the 1st index: ";
                cin >> i1;
                cout << "\n\t\t\tEnter the 2nd index: ";
                cin >> i2;
                cout << "\n\n\t\tPerforming swap operation...\n";
                sll->swap(i1, i2);
                cout << "\n\t\t\tThe list becomes:\n\t\t\t";
                sll->display();
            }
            else
                cout << "\n\t\tThe list is empty.";
            input = 0;
            break;
        }
        case 14:
        {
            cout << "\n\n\t\t\tThe List:\n\t";
            cout << "\t\t\t";
            sll->display();
            input = 0;
            break;
        }
        case 100:
        {
            cout << "\n\n\t\t\tThanks for using the program.\n\t\t\tExiting the program.\n\n";
            input = -1;
            break;
        }
        default:
        {
            input = 0;
            break;
        }
        }
    }
    return 0;
}