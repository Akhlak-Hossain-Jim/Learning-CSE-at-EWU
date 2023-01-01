#include <stdio.h>
#include <ctype.h>
#include <string.h>

struct menu
{
    int code;
    char name[40];
    double price;
    int inStock;
};
struct sold
{
    int code;
    char name[40];
    double price;
    int quantity;
};

struct menu COFFEEs[8] = {
    {1, "Americano", 120.4, 23},
    {2, "Americano", 120.4, 23},
    {3, "Americano", 120.4, 23},
    {4, "Americano", 120.4, 23},
    {5, "Americano", 120.4, 23},
    {6, "Americano", 120.4, 23},
    {7, "Americano", 120.4, 23},
    {8, "Americano", 120.4, 23},
};

void info()
{
    printf("Loading................\n\n\n\n");
    printf("\t\tWELCOME to COFFEE SHOP MANAGEMENT APP\n");
    printf("\n%c\t\t\tCreated by\n\n", ' ');
    printf("%c\t\tName:\tAklhak Hossain\t\tId:\t2022-3-60-057\n", ' ');
    printf("%c\t\tName:\tSaba Tasnim Khan\tId:\t2022-3-60-049\n", ' ');
    printf("%c\t\tName:\tHasnay Hasin\t\tId:\t2022-3-60-038\n", ' ');
    printf("%c\t\tName:\tAnika Tahseen\t\tId:\t2022-3-60-037\n", ' ');
    printf("\n\n\n \t\tSelect an Option:\n");
    printf("%c\t\t\t1. Print Item list.\n", ' ');
    printf("%c\t\t\t9. Exit\n", ' ');
    return;
}

void printList()
{
    printf("\n\n");
    printf("------------------------------------------\n\t\t| ID | Name\t| Price\t| In Stock\t|\n ------------------------------------------\n");
    for (int i = 0; i < 8; i++)
    {
        printf("\t\t|  %d | %s\t| %lf\t| %d\t|\n", COFFEEs[i].code, COFFEEs[i].name, COFFEEs[i].price, COFFEEs[i].inStock);
        printf(" \t\t------------------------------------------\n");
    }
    return;
}

int main()
{
    int identifier;
    info();
    printf("\n \t\tSelect: ");
    scanf("%d", &identifier);

    while (identifier)
    {
        if (identifier == 1)
        {
            printList();
            identifier = 200;
            printf("\n \t\tPlace an order\n \t\t\t: ");
        }
        else if (identifier == 9)
        {
            printf("Closing app.......");
            break;
        }
    }
    return 0;
}