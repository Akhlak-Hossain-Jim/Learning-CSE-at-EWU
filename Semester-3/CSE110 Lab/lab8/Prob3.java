import java.util.Scanner;

public class Prob3 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.print("An array is declared.\nEnter an index to see the value: ");
        int a = inp.nextInt();
        try {
            System.out.print("Value at index " + a + " is " + arr[a]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        inp.close();
    }
}
