#include <cstdlib>
#include "Solutions.hpp"

using namespace std;

int main()
{
    Stack *st = new Stack();
    int input = 0;
    cout << "Initializing an Stack...\nAlmost there...\n";
    while (input != -1)
    {
        switch (input)
        {
        case 0:
        {
            cout << "\n\n";
            cout << "\tChoose an option from below:\n";
            cout << "\t\t01. Add Node\n";
            cout << "\t\t02. Copy Stack\n";
            cout << "\t\t03. Convert decimal to Binary\n";
            cout << "\t\t04. Reverse the Stack\n";
            cout << "\t\t05. Validate a complex equation\n";
            cout << "\t\t06. Pop Node\n";
            cout << "\t\t07. Stack length\n";
            cout << "\t\t08. Is Stack empty\n";
            cout << "\t\t08. Destroy Stack\n";
            cout << "\t\t09. Get top value\n";
            cout << "\t\t10. Get top address\n";
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
            st->Push(add);
            cout << "\t\t\t";
            st->display();
            input = 0;
            break;
        }

        case 2:
        {
            if (!(st->isEmpty()))
            {
                cout << "\n\n\t\t\tCurrent Stack     :\t";
                st->display();
                cout << "\t\t\tPerforming copy Stack operation..." << endl;
                Stack *stCopy = copy(st);
                cout << "\t\t\tCopied Stack     :\t";
                stCopy->display();
            }
            else
                cout << "Add some Node first to perform copy stack";
            input = 0;
            break;
        }

        case 3:
        {
            int ctb;
            cout << "\n\n\t\t\tEnter a decimal number: ";
            cin >> ctb;
            cout << "\t\t\tConverting " << ctb << " to it's binary..." << endl;
            cout << "\t\t\tBinary of " << ctb << " is: ";
            ConvertToBinary(ctb);
            cout << "\n";
            input = 0;
            break;
        }

        case 4:
        {
            if (!(st->isEmpty()))
            {
                cout << "\n\n\t\t\tPrevious:\t";
                st->display();
                cout << "\t\t\tPerforming reverse operation operation..." << endl;
                ReverseStack(st);
                cout << "\t\t\tNew     :\t";
                st->display();
            }
            else
                cout << "Add some items first to perform traverse and remove negative nodes";
            input = 0;
            break;
        }

        case 5:
        {
            string ppc;
            cout << "\n\n\t\t\tEnter a decimal number: ";
            cin >> ppc;
            cout << "\t\t\tChecking bracket pair of " << ppc << endl;
            cout << "\t\t\tThe program says: ";
            ParenthesisParsing(ppc);
            cout << "\n";
            input = 0;
            break;
        }

        case 6:
        {
            if (!(st->isEmpty()))
            {
                // cout << "\n\n\t\t\tPrevious:\t";
                // st->display();
                // cout << "\t\t\tPerforming traverse operation operation..." << endl;
                // st->reverse();
                // cout << "\t\t\tNew     :\t";
                // st->display();
                // cout << "\t\t\tLooking for negative values and removing them ...\n";
                // removeSmallerThanZero(st);
                // cout << "\t\t\tNew     :\t";
                // st->display();
            }
            else
                cout << "Add some items first to perform traverse and remove negative nodes";
            input = 0;
            break;
        }

        case 7:
        {
            if (!(st->isEmpty()))
            {
                // cout << "\n\n\t\t\tPrevious:\t";
                // st->display();
                // cout << "\t\t\tPerforming traverse operation operation..." << endl;
                // st->reverse();
                // cout << "\t\t\tNew     :\t";
                // st->display();
                // cout << "\t\t\tLooking for negative values and removing them ...\n";
                // removeSmallerThanZero(st);
                // cout << "\t\t\tNew     :\t";
                // st->display();
            }
            else
                cout << "Add some items first to perform traverse and remove negative nodes";
            input = 0;
            break;
        }

        case 8:
        {
            if (!(st->isEmpty()))
            {
                // cout << "\n\n\t\t\tPrevious:\t";
                // st->display();
                // cout << "\t\t\tPerforming traverse operation operation..." << endl;
                // st->reverse();
                // cout << "\t\t\tNew     :\t";
                // st->display();
                // cout << "\t\t\tLooking for negative values and removing them ...\n";
                // removeSmallerThanZero(st);
                // cout << "\t\t\tNew     :\t";
                // st->display();
            }
            else
                cout << "Add some items first to perform traverse and remove negative nodes";
            input = 0;
            break;
        }

        case 9:
        {
            if (!(st->isEmpty()))
            {
                // cout << "\n\n\t\t\tPrevious:\t";
                // st->display();
                // cout << "\t\t\tPerforming traverse operation operation..." << endl;
                // st->reverse();
                // cout << "\t\t\tNew     :\t";
                // st->display();
                // cout << "\t\t\tLooking for negative values and removing them ...\n";
                // removeSmallerThanZero(st);
                // cout << "\t\t\tNew     :\t";
                // st->display();
            }
            else
                cout << "Add some items first to perform traverse and remove negative nodes";
            input = 0;
            break;
        }

        case 10:
        {
            if (!(st->isEmpty()))
            {
                // cout << "\n\n\t\t\tPrevious:\t";
                // st->display();
                // cout << "\t\t\tPerforming traverse operation operation..." << endl;
                // st->reverse();
                // cout << "\t\t\tNew     :\t";
                // st->display();
                // cout << "\t\t\tLooking for negative values and removing them ...\n";
                // removeSmallerThanZero(st);
                // cout << "\t\t\tNew     :\t";
                // st->display();
            }
            else
                cout << "Add some items first to perform traverse and remove negative nodes";
            input = 0;
            break;
        }

        case 14:
        {
            cout << "\n\n\t\t\tThe List:\n\t";
            cout << "\t\t\t";
            st->display();
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