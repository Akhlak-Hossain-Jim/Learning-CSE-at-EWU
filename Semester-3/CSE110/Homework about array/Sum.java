import java.util.Scanner;

class SummingArray {
    public static void main(String[] args) {
        System.out.println("This program is about Summing all elements.");
        Scanner inp = new Scanner (System.in);
        System.out.print("Enter the array length, n: ");
        int n = inp.nextInt();
        int [] array=new int[n];
        int sum=0;
        for(int i =0;i<array.length;i++){
            System.out.print("Enter "+(i+1)+"th element: ");
            array[i]=inp.nextInt();
            sum+=array[i];
        }
        System.out.println("The sum of the given numbers are: "+sum);
    }
}