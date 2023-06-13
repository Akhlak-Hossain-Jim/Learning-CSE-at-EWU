import java.util.Scanner;

class SmallestIndexOfLargestInArray {
    public static void main(String[] args) {
        System.out.println("This program is about Finding the largest element.\n");
        Scanner inp = new Scanner (System.in);
        System.out.print("Enter the array length, n: ");
        int n = inp.nextInt();
        int [] array=new int[n];
        int l=0;
        int li=0;
        for(int i =0;i<array.length;i++){
            System.out.print("Enter "+(i+1)+"th element: ");
            array[i]=inp.nextInt();
            if (array[i]>l)
                l = array[i];
        }
        for (int i=0; i<array.length;i++){
            if (l == array[i]){
              li=i;
              break;
            }
        }
        System.out.println("The smallest index of largest value from the given numbers is: "+li);
    }
}