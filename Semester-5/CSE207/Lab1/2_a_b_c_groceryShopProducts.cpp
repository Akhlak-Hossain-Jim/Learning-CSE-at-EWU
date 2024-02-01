#include <iostream>
using namespace std;

class Product
{
private:
    int id;
    string name;
    string brandName;
    string type;
    int quantity;
    double price;

public:
    Product() {}
    Product(int Id, string Name, string BN, string Ty, int q, double pr)
    {
        id = Id;
        name = Name;
        brandName = BN;
        type = Ty;
        quantity = q;
        price = pr;
    }
    void setAll(int Id, string Name, string BN, string Ty, int q, double pr)
    {
        id = Id;
        name = Name;
        brandName = BN;
        type = Ty;
        quantity = q;
        price = pr;
    }
    string getBrandName()
    {
        return brandName;
    }
    string getType()
    {
        return type;
    }
    int getQuantity()
    {
        return quantity;
    }
    int getPrice()
    {
        return price;
    }
    void display()
    {
        cout << "name:\t" << name << "\tprice:\t" << price << endl;
    }
};

void StaticAssign(int length)
{
    Product prodArr[length];
    for (int i = 0; i < length; i++)
    {
        Product ref;
        int id;
        string name;
        string brandName;
        string type;
        int quantity;
        double price;
        cout << "Enter " << i + 1 << "th product ID: ";
        cin >> id;
        cout << "Enter " << i + 1 << "th product Name: ";
        cin >> name;
        cout << "Enter " << i + 1 << "th product BrandName: ";
        cin >> brandName;
        cout << "Enter " << i + 1 << "th product Type: ";
        cin >> type;
        cout << "Enter " << i + 1 << "th product Quantity: ";
        cin >> quantity;
        cout << "Enter " << i + 1 << "th product Price: ";
        cin >> price;
        cout << endl;
        ref.setAll(id, name, brandName, type, quantity, price);
        prodArr[i] = ref;
    }
    for (int i = 0; i < length; i++)
    {
        if (prodArr[i].getPrice() > 40)
            prodArr[i].display();
    }
}

void DynamicAssign(int length)
{
    int options = 0;
    string input = "";
    Product *prodArr[length];
    for (int i = 0; i < length; i++)
    {
        int id;
        string name;
        string brandName;
        string type;
        int quantity;
        double price;
        cout << "Enter " << i + 1 << "th product ID: ";
        cin >> id;
        cout << "Enter " << i + 1 << "th product Name: ";
        cin >> name;
        cout << "Enter " << i + 1 << "th product BrandName: ";
        cin >> brandName;
        cout << "Enter " << i + 1 << "th product Type: ";
        cin >> type;
        cout << "Enter " << i + 1 << "th product Quantity: ";
        cin >> quantity;
        cout << "Enter " << i + 1 << "th product Price: ";
        cin >> price;
        cout << endl;
        prodArr[i] = new Product(id, name, brandName, type, quantity, price);
    }
    for (int i = 0; i < length; i++)
    {
        prodArr[i]->display();
    }
    while (!(options > 0 && options < 4))
    {
        cout << endl
             << "\tChoose an option:" << endl
             << "\t\t1. Search Product by Brand Name" << endl
             << "\t\t2. Calculate Total Asset by Type" << endl
             << "\t\t3. Calculate Total Asset" << endl
             << "Enter an option ID: ";
        cin >> options;
    }

    switch (options)
    {
    case 1:
    {
        cout << endl;
        cout << "Enter Brand Name: ";
        cin >> input;
        cout << endl;
        for (int i = 0; i < length; i++)
        {
            if (prodArr[i]->getBrandName() == input)
                prodArr[i]->display();
        }
        break;
    }
    case 2:
    {
        cout << endl;
        cout << "Enter Product Type: ";
        cin >> input;
        cout << endl;
        int totalAssetByType = 0;
        for (int i = 0; i < length; i++)
        {
            if (prodArr[i]->getType() == input)
                totalAssetByType += (prodArr[i]->getPrice() * prodArr[i]->getQuantity());
        }
        cout << endl
             << "\t Searched in all assets for type: " << input;
        cout << "\tFound total asset of: " << totalAssetByType;
        break;
    }
    case 3:
    {
        cout << endl;
        int totalAsset = 0;
        for (int i = 0; i < length; i++)
        {
            totalAsset += (prodArr[i]->getPrice() * prodArr[i]->getQuantity());
        }
        cout << "\tFound total asset of: " << totalAsset;
        break;
    }
    default:
        break;
    }
}

int main()
{
    int option = 0;
    int length = 0;
    while (option != 1 && option != 2)
    {
        cout << endl
             << "\tChoose an option:" << endl
             << "\t\t1. Static Assign" << endl
             << "\t\t2. Dynamic Assign" << endl
             << "Enter an option ID: ";
        cin >> option;
    }
    if (option == 1)
    {
        cout << "Enter total product number: ";
        cin >> length;
        cout << endl;
        StaticAssign(length);
    }
    else if (option == 2)
    {
        cout << "Enter total product number: ";
        cin >> length;
        cout << endl;
        DynamicAssign(length);
    }
    return 0;
}