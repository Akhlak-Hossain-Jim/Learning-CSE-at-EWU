#include <iostream>
using namespace std;

class Rectangle
{
private:
    double height;
    double width;

public:
    Rectangle(){};
    Rectangle(double height, double width)
    {
        this->height = height;
        this->width = width;
    }
    void setHeight(double h)
    {
        height = h;
    }
    void setWidth(double w)
    {
        width = w;
    }
    double getHeight()
    {
        return height;
    }
    double getWidth()
    {
        return width;
    }
    void displayArea()
    {
        double area = height * width;
        cout << " Area: " << area;
    }
};

int main()
{
    int runner = 0;
    double n1, n2;

    cout << "\nFind area of a rectangle (Static allocation).\n";
    cout << "\nEnter width: ";
    cin >> n1;
    cout << "Enter height: ";
    cin >> n2;

    Rectangle rBasic;
    rBasic.setWidth(n1);
    rBasic.setHeight(n2);
    rBasic.displayArea();

    cout << "\nFind area of a rectangle (Dynamic allocation).\n";
    cout << "\nEnter width: ";
    cin >> n1;
    cout << "Enter height: ";
    cin >> n2;

    Rectangle *rD;
    rD = new Rectangle(n2, n1);
    rD->displayArea();
    delete rD;

    int als;
    cout << "\nArray of rectangle (Static allocation).\n";
    cout << "Enter array length: ";
    cin >> als;
    Rectangle rsArr[als];
    for (int i = 0; i < als; i++)
    {
        cout << "\nEnter width: ";
        cin >> n1;
        cout << "Enter height: ";
        cin >> n2;
        Rectangle ref;
        ref.setWidth(n1);
        ref.setHeight(n2);
        rsArr[i] = ref;
    }
    for (int i = 0; i < als; i++)
        rsArr[i].displayArea();

    int ald;
    cout << "\nArray of rectangle (Dynamic allocation).\n";
    cout << "Enter array length: ";
    cin >> ald;
    Rectangle *rdArr[ald];
    for (int i = 0; i < ald; i++)
    {
        cout << "\nEnter width: ";
        cin >> n1;
        cout << "Enter height: ";
        cin >> n2;
        rdArr[i] = new Rectangle(n2, n1);
    }
    for (int i = 0; i < ald; i++)
        rdArr[i]->displayArea();

    return 0;
}