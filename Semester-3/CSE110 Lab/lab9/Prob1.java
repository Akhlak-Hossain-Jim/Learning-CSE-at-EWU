import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Prob1 {
    public static void main(String[] args) throws Exception {
        File ref = new File("Lab08_01.txt");
        if (ref.exists()) {
            Scanner r = new Scanner(ref);
            ArrayList<Integer> arr = new ArrayList<Integer>();
            ArrayList<String> arrS = new ArrayList<String>();
            for (int i = 0; i < 100; i++) {
                arr.add(r.nextInt());
            }
            while (r.hasNext()) {
                arrS.add(r.nextLine());
            }
            r.close();
            PrintWriter w = new PrintWriter(ref);
            for (int k : arr) {
                w.print(k + " ");
            }
            for (String k : arrS) {
                w.println(k);
            }
            w.print("File already exists");
            w.close();
        } else {
            PrintWriter w = new PrintWriter(ref);
            for (int i = 0; i < 100; i++) {
                int a = (int) (Math.random() * 100);
                w.print(a + " ");
            }
            w.close();
        }
    }
}
