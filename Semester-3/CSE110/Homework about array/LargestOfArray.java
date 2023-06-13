import java.util.Scanner;

class LargestOfArray {
    public static void main(String[] args) {
        System.out.println("This program is about Finding the largest element.\n");
        Scanner inp = new Scanner (System.in);
        System.out.print("Enter the array length, n: ");
        int n = inp.nextInt();
        int [] array=new int[n];
        int l=0;
        for(int i =0;i<array.length;i++){
            System.out.print("Enter "+(i+1)+"th element: ");
            array[i]=inp.nextInt();
            if (array[i]>l)
                l = array[i];
        }
        System.out.println("The largest value from the given numbers is: "+l);
    }
}