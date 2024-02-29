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
            cout << "\t\t09. Destroy Stack\n";
            cout << "\t\t10. Get top value\n";
            cout << "\t\t11. Get top address\n";
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
                cout << "\n\n\t\t\tCurrent Stack:\t";
                st->display();
                cout << "\t\t\tPerforming reverse operation operation..." << endl;
                ReverseStack(st);
                cout << "\t\t\tNew Stack     :\t";
                st->display();
            }
            else
                cout << "\t\t\tThe Stack is currently Empty add some node to perform this operation";
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
                cout << "\n\n\t\t\tCurrent Stack:\t";
                st->display();
                cout << "\t\t\tPerforming pop operation operation..." << endl;
                st->Pop();
                cout << "\t\t\tNew Stack     :\t";
                st->display();
            }
            else
                cout << "\t\t\tThe Stack is currently Empty add some node to perform this operation";
            input = 0;
            break;
        }

        case 7:
        {
            if (!(st->isEmpty()))
            {
                cout << "\n\n\t\t\tCurrent length of stack:\t";
                cout << st->Length();
            }
            else
                cout << "\t\t\tThe Stack is currently Empty add some node to perform this operation";
            input = 0;
            break;
        }

        case 8:
        {
            cout << "\n\n\t\t\tThe Stack is currently ";
            if ((st->isEmpty()))
                cout << "Empty\n";
            else
                cout << "not Empty";
            input = 0;
            break;
        }

        case 9:
        {
            if (!(st->isEmpty()))
            {
                cout << "\n\n\t\t\tCurrent Stack:\t";
                st->display();
                cout << "\t\t\tDestroying the Stack..." << endl;
                st->destroy();
                cout << "\t\t\tNew Stack: ";
                st->display();
            }
            else
                cout << "\t\t\tThe Stack is currently Empty add some node to perform this operation";
            input = 0;
            break;
        }

        case 10:
        {
            if (!(st->isEmpty()))
            {
                cout << "\n\n\t\t\tTop Value of the Current Stack:\t";
                cout << st->Top();
            }
            else
                cout << "\t\t\tThe Stack is currently Empty add some node to perform this operation";
            input = 0;
            break;
        }

        case 11:
        {
            if (!(st->isEmpty()))
            {
                cout << "\n\n\t\t\tTop Address of the Current Stack:\t";
                cout << st->TopAddress();
            }
            else
                cout << "\t\t\tThe Stack is currently Empty add some node to perform this operation";
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