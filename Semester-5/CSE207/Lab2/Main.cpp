#include <iostream>
#include "SLL.h"
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
            cout << "\t\t02. Add an item at the beginning\n";
            cout << "\t\t03. Add an item to a specific index\n";
            cout << "\t\t04. Check if an item is present\n";
            cout << "\t\t05. Check list size\n";
            cout << "\t\t06. Check if the list is empty\n";
            cout << "\t\t07. Get an item by index\n";
            cout << "\t\t08. Get index of an item\n";
            cout << "\t\t09. Remove the first item from the list\n";
            cout << "\t\t10. Remove the last item from the list\n";
            cout << "\t\t11. Remove item from a specific index\n";
            cout << "\t\t12. Reverse the list\n";
            cout << "\t\t13. Sort the list\n";
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
            int addB;
            cout << "\n\n\t\t\tEnter an Integer value to add beginning of the list: ";
            cin >> addB;
            sll->addBeginning(addB);
            cout << "\t\t\t";
            sll->display();
            input = 0;
            break;
        }
        case 3:
        {
            int indP, addI;
            cout << "\n\n\t\t\tEnter index to add: ";
            cin >> indP;
            cout << "\t\t\tEnter an Integer value to add: ";
            cin >> addI;
            cout << "\t\t\t";
            sll->addTo(indP, addI);
            sll->display();
            input = 0;
            break;
        }
        case 4:
        {
            int search;
            cout << "\n\n\t\t\tEnter an Integer to look for: ";
            cin >> search;
            cout << "\t\t\t";
            if (sll->contains(search))
                cout << search << " exists in the List.";
            else
                cout << search << " does not exist in the List.";
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
        case 7:
        {
            int getI;
            cout << "\n\n\t\t\tEnter an Integer index value get item: ";
            cin >> getI;
            cout << "\t\t\t";
            try
            {
                cout << "Value found at index of " << getI << " is: " << sll->get(getI);
            }
            catch (const exception &e)
            {
                cerr << "Nothing found at the index of: " << getI;
            }
            input = 0;
            break;
        }
        case 8:
        {
            int getInd;
            cout << "\n\n\t\t\tEnter an Integer value get item index: ";
            cin >> getInd;
            cout << "\t\t\t";
            try
            {
                cout << getInd << " found at index of " << sll->indexOf(getInd);
            }
            catch (const exception &e)
            {
                cerr << e.what() << endl;
            }
            input = 0;
            break;
        }
        case 9:
        {
            cout << "\n\n\t\t\tPrevious:\t";
            sll->display();
            sll->removeFirst();
            cout << "\t\t\tNew     :\t \t";
            sll->display();
            input = 0;
            break;
        }
        case 10:
        {
            cout << "\n\n\t\t\tPrevious:\t";
            sll->display();
            sll->removeLast();
            cout << "\t\t\tNew     :\t";
            sll->display();
            input = 0;
            break;
        }
        case 11:
        {
            int reI;
            cout << "\n\n\t\t\tEnter an index to remove from: ";
            cin >> reI;
            cout << "\n\n\t\t\tPrevious:\t";
            sll->display();
            sll->remove(reI);
            cout << "\t\t\tNew     :\t";
            sll->display();
            input = 0;
            break;
        }
        case 12:
        {
            cout << "\t\t\tPerforming Reverse operation..." << endl;
            cout << "\n\n\t\t\tPrevious:\t";
            sll->display();
            sll->reverse();
            cout << "\t\t\tNew     :\t";
            sll->display();
            input = 0;
            break;
        }
        case 13:
        {
            cout << "\n\n\t\t\tPrevious:\t";
            sll->display();
            cout << "\n\n\t\tPerforming Sorting operation...\n\n";
            cout << "\t\t\tNew     :\t";
            sll->sort();
            sll->display();
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
}
