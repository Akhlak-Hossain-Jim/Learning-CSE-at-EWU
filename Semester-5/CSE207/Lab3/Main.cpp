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
                removeSmallerThanZero(sll);
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
            cout << "\n\n\t\t\tThe list has " << sll->size() << " items.";
            input = 0;
            break;
        }
        case 6:
        {
            cout << "\n\n\t\t\t";
            if (sll->isEmpty())
                cout << "The list is empty.";
            else
                cout << "The list not empty.";
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