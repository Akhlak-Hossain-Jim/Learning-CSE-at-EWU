package Tab;

import java.util.ArrayList;

public class MatchUp {
    private Team Gov;
    private Team Opp;
    private String Room;
    private ArrayList<Adjudicator> Judges = new ArrayList<Adjudicator>();

    public MatchUp(Team a, Team b, String r) {
        Gov = a;
        Opp = b;
        Room = r;
    }

    public void AddJudge(Adjudicator a) {
        Judges.add(a);
    }

    public void RemoveJudge(Adjudicator a) {
        for (int i = 0; i < Judges.size(); i++) {
            if (Judges.get(i).getName() == a.getName()) {
                Judges.remove(i);
            }
        }
    }

    private String displayAdj() {
        String a = "";
        for (int i = 0; i < Judges.size(); i++) {
            a += Judges.get(i).getName();
            if (i != Judges.size() - 1) {
                a += ", ";
            }
        }
        return a;
    }

    public void display() {
        System.out.println(Gov.getName() + "\t" + Room + "\t" + Opp.getName() + "\t" + displayAdj());
    }
}
