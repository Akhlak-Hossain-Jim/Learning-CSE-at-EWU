#include "../Lab2/SLL.h"
#include "Solutions.hpp"

using namespace std;

int main()
{
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
            cout << "\t\t01. Find GCD of 2 numbers\n";
            cout << "\t\t02. Print numbers in decending order till 1\n";
            cout << "\t\t03. Print numbers in ascending order till n\n";
            cout << "\t\t04. Sum of Fibonacci sequence from n\n";
            cout << "\t\t05. Delete nth node from SLL\n";
            cout << "\t\t06. Sort SLL using recursion\n";
            cout << "\t\t100. Exit the program\n";
            cout << "\n\t\tEnter an option(Integer value): ";
            cin >> input;
            break;
        }

        case 1:
        {
            int n1, n2;
            cout << "\n\n\t\t\tEnter 1st Integer: ";
            cin >> n1;
            cout << "\t\t\tEnter 2nd Integer: ";
            cin >> n2;
            cout << "\n\n\t\t\t GCD of " << n1 << " & " << n2 << " is: " << GCD(n1, n2) << endl;
            input = 0;
            break;
        }

        case 2:
        {
            cout << "\n\n\t\t\tPrinting numbers in decending order:\t";
            int num2;
            cout << "\n\t\t\tEnter an Integer: ";
            cin >> num2;
            cout << "\t\t\tValue: ";
            printDescendingOrder(num2);
            input = 0;
            break;
        }

        case 3:
        {
            cout << "\n\n\t\t\tPrinting numbers in Ascending order:\t";
            int num3;
            cout << "\n\t\t\tEnter an Integer: ";
            cin >> num3;
            cout << "\t\t\tValue: ";
            printAscendingOrder(num3);
            input = 0;
            break;
        }

        case 4:
        {
            cout << "\n\n\t\t\tPrinting Sum of Fibonacci sequence from n:\t";
            int num4;
            cout << "\n\t\t\tEnter an Integer: ";
            cin >> num4;
            cout << "\t\t\tValue: " << sumOfFibonacci(num4, 0, 1);
            input = 0;
            break;
        }

        case 5:
        {
            cout << "\n\n\t\t\tDeleting n-th node of a given linked list using recursion:\t";
            int sllL;
            cout << "\n\t\t\tEnter the length of Linked List: ";
            cin >> sllL;
            SLL *sll = new SLL();
            for (int i = 0; i < sllL; i++)
            {
                cout << "\t\t\tEnter " << i + 1 << "th item: ";
                int x;
                cin >> x;
                sll->add(x);
            }
            cout << "\n\t\tThe Linked List: ";
            sll->display();
            int index;
            cout << "\n\t\t\tEnter index to remove: ";
            cin >> index;
            cout << "\n\t\t\tRemoving " << index << "th node:\n";
            cout << "\n\t\t\tNew List:\n";
            sll = deleteNthItemOfSLL(sll, index);
            sll->display();
            cout << endl;
            input = 0;
            break;
        }

        case 6:
        {
            cout << "\n\n\t\t\tSorting a given linked list using recursion:\t";
            int sllL;
            cout << "\n\t\t\tEnter the length of Linked List: ";
            cin >> sllL;
            SLL *sll = new SLL();
            for (int i = 0; i < sllL; i++)
            {
                cout << "\t\t\tEnter " << i + 1 << "th item: ";
                int x;
                cin >> x;
                sll->add(x);
            }
            cout << "\n\t\t\tThe Linked List: ";
            sll->display();
            cout << "\n\t\t\tSorting the list:\n";
            cout << "\n\t\t\tNew List:";
            // sortRecursion(sll->getHead(), 0, sllL);
            sll = sortedList(sll);
            // sll->display();
            cout << endl;
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