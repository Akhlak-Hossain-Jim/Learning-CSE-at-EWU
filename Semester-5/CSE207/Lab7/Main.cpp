// #include <iostream>
#include "BST.hpp"
// using namespace std;

int main()
{
    // SLL *sll = new SLL();
    Node *root = NULL;
    int input = 0;
    cout << "Creating an Binary Search Tree...\nAlmost there...\n";
    while (input != -18429)
    {
        switch (input)
        {
        case 0:
        {
            cout << "\n\n";
            cout << "\tChoose an option from below:\n";
            cout << "\t\t01. Insert an item\n";
            cout << "\t\t02. Search for an item\n";
            cout << "\t\t03. Perform Traversal Operation\n";
            cout << "\t\t04. Delete an item\n";
            cout << "\t\t05. Check Smallest and the largest value\n";
            cout << "\t\t06. Height of the BST\n";
            cout << "\t\t07. Find Path of a node\n";
            // cout << "\t\t08. Display the tree\n";
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
            root = BST::insert(root, add);
            cout << "\t\t\t";
            BST::PostOrderDisplay(root, 0);
            input = 0;
            break;
        }
        case 2:
        {
            int search;
            cout << "\n\n\t\t\tEnter an Integer to search from the tree: ";
            cin >> search;
            cout << "\t\t\t";
            BST::search(root, search);
            input = 0;
            break;
        }
        case 3:
        {
            cout << "\n\n\t\t\tDoing In order traversal: ";
            BST::InOrderDisplay(root, 0);
            cout << "\n\n\t\t\tDoing Pre order traversal: ";
            BST::PreOrderDisplay(root, 0);
            cout << "\n\n\t\t\tDoing Post order traversal: ";
            BST::PostOrderDisplay(root, 0);
            input = 0;
            break;
        }
        case 4:
        {
            int del;
            cout << "\n\n\t\t\tEnter an Integer to Delete from the tree: ";
            cin >> del;
            cout << "\t\t\t";
            root = BST::Delete(root, del);
            cout << "\n\t\tNew Tree: ";
            cout << "\n\t\t\t";
            BST::PostOrderDisplay(root, 0);
            input = 0;
            break;
        }
        case 5:
        {
            cout << "\n\n\t\t\tThe tree: ";
            BST::PostOrderDisplay(root, 0);
            cout << "\n\t\t\tLooking for the Smallest and the Largest Value...";
            Node *l = BST::FindLarge(root, 0);
            Node *s = BST::FindSmall(root, 0);
            cout << "\n\t\t\tThe Smallest value on the Tree is: " << s->item << " | And The Largest Value is: " << l->item;
            input = 0;
            break;
        }
        case 6:
        {
            cout << "\n\n\t\t\tCounting the tree Height...";
            cout << "\n\t\t\t\tTree height is: " << BST::treeHeight(root, 0);
            input = 0;
            break;
        }
        case 7:
        {
            int pa;
            cout << "\n\n\t\t\tEnter an Integer to find its path: ";
            cin >> pa;
            cout << "\t\t\t";
            BST::ItemPath(root, pa);
            input = 0;
            break;
        }
        case 100:
        {
            cout << "\n\n\t\t\tThanks for using the program.\n\t\t\tExiting the program.\n\n";
            input = -18429;
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
