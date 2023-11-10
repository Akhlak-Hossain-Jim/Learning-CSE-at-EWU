package Tab;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tab {
    public static void main(String[] args) throws IOException {
        String[] sa = {
                "AUSTDC",
                "AUSTDC Satkahon",
                "Mithila",
                "Saif",
                "Hamim Inteser ",
                "BAUDS",
                "BAUDS Bijoy 71",
                "Saykat Kumar Debnath",
                "Nubah Nashita Farihat",
                "Asif Iqbal",
                "BUDS",
                "BUDS Droho",
                "Masum Mahmud ",
                "Rafiqul Islam Eamin",
                "Sieum Zaman",
                "BUPDC",
                "BUP 01",
                "Zil Jawsan ",
                "Alvi Tonoy",
                "Arafat limon ",
                "BUTEXDC",
                "BUTEXDC Bunon",
                "Avishek",
                "Ahnaf Sharar Hossain",
                "Barshan",
                "CU",
                "CUDS A",
                "Tanzim Ahamed",
                "Mehedi Hasan Emon ",
                "Arafat Hossain ",
        };
        String[] ins = {
                "DCU",
                "JnUDS",
                "UIUDC",
                "CUSD",
                "BUTEXDC",
                "PUDS",
                "JUDO",
                "KDS",
                "JnUDS",
                "JnUDS ",
                "RU",
                "DUDS",
                "JUDO",
                "JUDO",
                "PUDS",
                "DU",
                "BUTEX",
                "RUETDC",
                "BNDP",
                "NSTUDS ",
                "PUDS",
                "FDF",
                "DCU",
                "BRUDF",
                "CUDS",
                "SUDS",
                "SBMCDF",
                "EWUDC",
                "BRU",
                "DUDS",
                "SUDS",
                "BGPSC",
                "DCN, DCDS",
                "DCDS",
                "BSMRSTU ",
                "KNGC DC",
        };
        String[] na = {
                "Md. Hasib Khan",
                "TI Hridoy",
                "MM Tasnim ",
                "Sadaf",
                "Dipu",
                "Soumen Sarker",
                "Farhan Anjum",
                "Hridoy",
                "Sobuj Raihan",
                "Sharmin Sultana Nishi ",
                "Sadhan Mukherjee ",
                "Tahmid Al Muddassir Chowdhury ",
                "Shafi Mahmud Sagor",
                "Zillal Hossain Sourav",
                "Nik",
                "Sanjana Afrin Aishy",
                "Mirazul Islam Chowdhury ",
                "Irteza Nur Alba",
                "Md Shahidul Islam",
                "MD. Fahad ",
                "Shakib Hossain ",
                "Aynul islam Ayon",
                "Md Mozzammel Masum ",
                "Shanim Ahmmed",
                "Syed Shahriar Rahman ",
                "Rownak Jahan Mona",
                "Naima Zaman Suti",
                "Swamitra Ghosh ",
                "Sabbir Istiak Ahmed",
                "Ummay Suhala ",
                "Shadman Shakib",
                "Sadia Islam Rimi ",
                "Md. Arman Hossain",
                "Ruhan",
                "Md. Emon Hossain ",
                "Mahbubr Rahman ",
        };
        FileOutputStream f = new FileOutputStream("data.dat");
        DataOutputStream w = new DataOutputStream(f);
        w.writeInt(6);
        for (String s : sa) {
            w.writeUTF(s);
        }
        w.writeInt(36);
        for (int i = 0; i < 36; i++) {
            w.writeUTF(ins[i]);
            w.writeUTF(na[i]);
            if (i < 16)
                w.writeDouble(0.8);
            else if (i < 32)
                w.writeDouble(0.6);
            else
                w.writeDouble(0.4);
        }
        w.close();
    }
}
