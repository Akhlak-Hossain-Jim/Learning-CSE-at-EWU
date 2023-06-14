import java.util.Scanner;

class RightShifting {
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
        System.out.print("\nEnter the you wanna right shift the array: ");
        int ind = inp.nextInt();
        for(int t=0;t<ind;t++){
            int prox=0;
            for (int i=0;i<n;i++){
                if (i==0){
                    prox=array[i];
                    array[0]=array[n-1];
                } else{
                    int a=array[i];
                    array[i]=prox;
                    prox=a;
                    // array[i]=array[i+1];
                }
            }
        }
        
        System.out.println("The shifted array is:");
        for(int el: array){
            System.out.print(el+"\t");
        }
    }
}