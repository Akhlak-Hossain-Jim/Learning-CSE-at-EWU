import java.util.Scanner;

class RandomShaffling {
    public static void main(String[] args) {
        System.out.print("This program is right shifting a specific indexed element from a givven array.\nEnter the array length:");
        Scanner inp = new Scanner (System.in);
        int n=inp.nextInt();
        int [] array = new int[n];
        for(int i =0;i<n;i++){
            System.out.print("Enter "+(i+1)+" th element: ");
            array[i]=inp.nextInt();
        }
        System.out.println("The given array is:");
        for(int el: array){
            System.out.print(el+"\t");
        }
        int prox=0;
        for (int i=0;i<n;i++){
            int a=(int)(Math.random()*n);
            int b = array[i];
            array[i]=array[a];
            array[a]=b;
        }
        
        System.out.println("\nThe randomly shaffled array is:");
        for(int el: array){
            System.out.print(el+"\t");
        }
    }
}