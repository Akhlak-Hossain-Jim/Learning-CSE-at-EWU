import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Prob3 {
    public static void main(String[] args) throws IOException {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a file path with '.txt' extension to read: ");
        String txtName = inp.next();
        File txtFile = new File(txtName);
        if (txtFile.exists()) {
            Scanner txtReader = new Scanner(txtFile);
            FileOutputStream datFile = new FileOutputStream(txtName + ".dat");
            DataOutputStream w = new DataOutputStream(datFile);

            while (txtReader.hasNext()) {
                String s = txtReader.nextLine();
                w.writeUTF(s);
            }
            txtReader.close();
            w.close();
            System.out.println("A binary file successfully written at path '" + txtName + ".dat' ");
        } else {
            System.out.println("No file found in " + txtName);
        }
        inp.close();
    }
}
