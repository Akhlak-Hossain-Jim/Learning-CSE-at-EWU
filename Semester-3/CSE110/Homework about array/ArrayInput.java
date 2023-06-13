import java.util.Scanner;

class ArrayInput {
    public static void main(String[] args) {
        System.out.println("This program is about Initializing arrays with input values\n");
        int [] array=new int[5];
        Scanner inp = new Scanner (System.in);
        for(int i =0;i<array.length;i++){
            System.out.print("Enter "+(i+1)+"th element: ");
            array[i]=inp.nextInt();
        }
        for(int i =0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}