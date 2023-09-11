import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class List implements Serializable {
    int index;
    int MaxSize = 10;
    int[] Data;

    public List() {
        this.index = -1;
        this.MaxSize = 10;
        this.Data = new int[this.MaxSize];
    }

    public List(int MaxSize) {
        this.index = -1;
        this.MaxSize = MaxSize;
        this.Data = new int[this.MaxSize];
    }

    public void push(int data) {
        this.index++;
        if (this.index < MaxSize) {
            this.Data[index] = data;
        } else {
            System.err.println("You are trying to add more data than you created the object for.");
        }
    }

    public void pop() {
        this.Data[index] = 0;
        if (this.index > 0) {
            index--;
        } else {
            System.err.println("No data available to remove.");
        }
    }

    public void display() {
        String s = "[";
        for (int i = 0; i <= this.index; i++) {
            if (i == this.index) {
                String a = this.Data[i] + "]";
                s += a;
            } else {
                String a = this.Data[i] + ", ";
                s += a;
            }
        }
        System.out.println(s);
    }

    public int top() {
        return this.Data[this.index];
    }
}

public class Prob4 {
    public static void main(String[] args) throws IOException {
        List l1 = new List();
        List l2 = new List();
        List l3 = new List();
        List l4 = new List();
        List l5 = new List();

        l1.push(1);
        l1.push(2);
        l1.push(3);
        l1.push(4);
        l1.push(5);
        l1.display();
        l1.pop();
        l1.display();

        l2.push(10);
        l2.push(20);
        l2.push(30);
        l2.push(40);
        l2.push(50);

        l3.push(100);
        l3.push(200);
        l3.push(300);
        l3.push(400);
        l3.push(500);

        l4.push(1000);
        l4.push(2000);
        l4.push(3000);
        l4.push(4000);
        l4.push(5000);

        l5.push(10000);
        l5.push(20000);
        l5.push(30000);
        l5.push(40000);
        l5.push(50000);

        FileOutputStream f = new FileOutputStream("Lab08_04.dat");
        ObjectOutputStream w = new ObjectOutputStream(f);
        w.writeObject(l1);
        w.writeObject(l2);
        w.writeObject(l3);
        w.writeObject(l4);
        w.writeObject(l5);
        w.close();
    }
}
