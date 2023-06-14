import java.util.Scanner;

class RandomValues {
    public static void main(String[] args) {
        System.out.print("This program is about Initializing arrays with random values.\nEnter the array length:");
        Scanner inp = new Scanner (System.in);
        int n=inp.nextInt();
        int [] array = new int[n];
        for(int i =0;i<n;i++){
            array[i]=(int)(Math.random()*100);
        }
        System.out.println("The randomly generated array is:");
        for(int el: array){
            System.out.println(el);
        }
    }
}