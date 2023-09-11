import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Prob2 {
    public static void main(String[] args) throws Exception {
        String fileName = "Lab08_02.dat";
        File ref = new File(fileName);
        if (ref.exists()) {
            FileInputStream file = new FileInputStream(fileName);
            DataInputStream r = new DataInputStream(file);
            ArrayList<Integer> arr = new ArrayList<Integer>();
            ArrayList<String> arrS = new ArrayList<String>();
            for (int i = 0; i < 100; i++) {
                arr.add(r.readInt());
                System.out.println(arr.get(i));
                // r.readUTF();
            }
            while (r.available() != 0) {
                String a = r.readUTF();
                arrS.add(a);
                System.out.println(a);
            }
            r.close();
            FileOutputStream fileW = new FileOutputStream(fileName);
            DataOutputStream w = new DataOutputStream(fileW);
            for (int k : arr) {
                w.writeInt(k);
                // w.writeUTF(" |||| ");
            }
            for (String k : arrS) {
                w.writeUTF(k);
            }
            w.writeUTF("File already exists");
            w.close();
        } else {
            FileOutputStream fileW = new FileOutputStream(fileName);
            DataOutputStream w = new DataOutputStream(fileW);
            for (int i = 0; i < 100; i++) {
                w.writeInt((int) (Math.random() * 100));
                // w.writeUTF(" |||| ");
            }
            w.close();
        }
    }
}
