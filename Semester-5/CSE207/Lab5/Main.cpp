#include "Solutions.hpp"

using namespace std;

int main()
{
    Queue *que = new Queue();
    int input = 0;
    cout << "Initializing an Queue...\nAlmost there...\n";
    while (input != -123456789)
    {
        switch (input)
        {
        case 0:
        {
            cout << "\n\n";
            cout << "\tChoose an option from below:\n";
            cout << "\t\t01. Add Node\n";
            cout << "\t\t02. Copy Queue\n";
            cout << "\t\t03. Categorize elements in Queue\n";
            cout << "\t\t04. Delete all Negative Integer\n";
            cout << "\t\t05. Stack to Queue\n";
            cout << "\t\t06. Reverse a Queue\n";
            cout << "\t\t07. Queue to Stack\n";
            cout << "\t\t08. Queue size\n";
            cout << "\t\t09. Is Queue empty\n";
            cout << "\t\t10. Destroy Queue\n";
            cout << "\t\t11. Get front value\n";
            cout << "\t\t12. Get front address\n";
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
            que->enqueue(add);
            cout << "\t\t\t";
            que->display();
            input = 0;
            break;
        }

        case 2:
        {
            if (!(que->isEmpty()))
            {
                cout << "\n\n\t\t\tCurrent Queue     :\t";
                que->display();
                cout << "\t\t\tPerforming copy Queue operation..." << endl;
                Queue *Copy = copy(que);
                cout << "\t\t\tCopied Queue     :\t";
                Copy->display();
            }
            else
                cout << "Add some Node first to perform copy Queue";
            input = 0;
            break;
        }

        case 3:
        {
            cout << "\n\n\t\t\tCurrent Queue:\t";
            que->display();
            cout << "\t\t\tCategorizing elements in the Queue..." << endl;
            cout << "\t\t\tThe groups becomes: \n";
            categorizeQueue(que);
            cout << "\n";
            input = 0;
            break;
        }

        case 4:
        {
            if (!(que->isEmpty()))
            {
                cout << "\n\n\t\t\tCurrent Queue     :\t";
                que->display();
                cout << "\t\t\tPerforming delete operation for all negetive nodes..." << endl;
                Queue *New = DeleteNegetive(que);
                cout << "\t\t\tRefined Queue     :\t";
                New->display();
            }
            else
                cout << "\t\t\tThe Queue is currently Empty add some node to perform this operation";
            input = 0;
            break;
        }

        case 5:
        {
            int stl;
            cout << "\n\n\t\t\tEnter a Stack node length: ";
            cin >> stl;
            Stack *st = new Stack();
            for (int i = 0; i < stl; i++)
            {
                int k;
                cout << "\t\t\tEnter the " << i << " th node: ";
                cin >> k;
                st->Push(k);
            }
            cout << "\t\t\tThe Stack being: " << endl;
            st->display();
            cout << "\t\t\tThe program is converting the Stack to Queue...\n";
            Queue *neue = StackToQueue(st);
            cout << "\t\t\tThe Queue is: ";
            neue->display();
            cout << endl;
            input = 0;
            break;
        }

        case 6:
        {
            if (!(que->isEmpty()))
            {
                cout << "\n\n\t\t\tCurrent Queue:\t";
                que->display();
                cout << "\t\t\tPerforming reverse operation..." << endl;
                Queue *reverse = ReverseQueue(que);
                cout << "\t\t\tNew Queue     :\t";
                reverse->display();
            }
            else
                cout << "\t\t\tThe Queue is currently Empty add some node to perform this operation";
            input = 0;
            break;
        }

        case 7:
        {
            if (!(que->isEmpty()))
            {
                cout << "\n\n\t\t\tCurrent Queue:\t";
                que->display();
                cout << "\t\t\tConverting the Queue to Stack..." << endl;
                Stack *conv = QueueToStack(que);
                cout << "\t\t\tThe Stack     :\t";
                conv->display();
            }
            else
                cout << "\t\t\tThe Queue is currently Empty add some node to perform this operation";
            input = 0;
            break;
        }

        case 8:
        {
            if (!(que->isEmpty()))
            {
                cout << "\n\n\t\t\tCurrent length of Queue:\t";
                cout << que->size();
            }
            else
                cout << "\t\t\tThe Queue is currently Empty add some node to perform this operation";
            input = 0;
            break;
        }

        case 9:
        {
            cout << "\n\n\t\t\tThe Queue is currently ";
            if ((que->isEmpty()))
                cout << "Empty\n";
            else
                cout << "not Empty";
            input = 0;
            break;
        }

        case 10:
        {
            if (!(que->isEmpty()))
            {
                cout << "\n\n\t\t\tCurrent Queue:\t";
                que->display();
                cout << "\t\t\tDestroying the Queue..." << endl;
                que->destroy();
                cout << "\t\t\tNew Queue: ";
                que->display();
            }
            else
                cout << "\t\t\tThe Queue is currently Empty add some node to perform this operation";
            input = 0;
            break;
        }

        case 11:
        {
            if (!(que->isEmpty()))
            {
                cout << "\n\n\t\t\tTop Value of the Current Queue:\t";
                cout << que->front();
            }
            else
                cout << "\t\t\tThe Queue is currently Empty add some node to perform this operation";
            input = 0;
            break;
        }

        case 12:
        {
            if (!(que->isEmpty()))
            {
                cout << "\n\n\t\t\tTop Address of the Current Queue:\t";
                cout << que->address();
            }
            else
                cout << "\t\t\tThe Queue is currently Empty add some node to perform this operation";
            input = 0;
            break;
        }

        case 14:
        {
            cout << "\n\n\t\t\tThe List:\n\t";
            cout << "\t\t\t";
            que->display();
            input = 0;
            break;
        }

        case 100:
        {
            cout << "\n\n\t\t\tThanks for using the program.\n\t\t\tExiting the program.\n\n";
            input = -123456789;
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