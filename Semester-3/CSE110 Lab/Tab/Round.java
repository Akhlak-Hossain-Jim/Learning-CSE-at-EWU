package Tab;

import java.util.ArrayList;

public class Round {
    private int roundNo;
    private String motion;

    private ArrayList<Team> Teams = new ArrayList<Team>();
    private ArrayList<Adjudicator> Adj = new ArrayList<Adjudicator>();
    private ArrayList<MatchUp> MatchUps = new ArrayList<MatchUp>();

    public Round(int no, ArrayList<Team> t, ArrayList<Adjudicator> a) {
        roundNo = no;
        Teams = t;
        Adj = a;
        Sorter();
    }

    private void Sorter() {
        for (int i = 0; i < Teams.size() - 1; i++) {
            for (int j = 0; j < Teams.size() - i - 1; j++) {
                if (Teams.get(j).getScore().getTotalScores() > Teams.get(j + 1).getScore().getTotalScores()) {
                    Team cpr = Teams.get(j);
                    Teams.set(i, Teams.get(i + 1));
                    Teams.set(i + 1, cpr);
                }
            }
        }
        for (int i = 0; i < Adj.size() - 1; i++) {
            for (int j = 0; j < Adj.size() - i - 1; j++) {
                if (Adj.get(j).getScore().getTotalScores() > Adj.get(j + 1).getScore().getTotalScores()) {
                    Adjudicator cpr = Adj.get(j);
                    Adj.set(i, Adj.get(i + 1));
                    Adj.set(i + 1, cpr);
                }
            }
        }
    }

    public void Generate() {
        int q = 0;
        System.out.println("\t:::::::::Generating matchup for " + RoundNoDisplay());
        System.out.println("\tGovernment" + "\t" + "Opposition" + "Place" + "\t" + "Adjudicators");
        for (int i = Teams.size() - 1; i >= 0; i -= 2) {
            MatchUps.add(new MatchUp(Teams.get(i), Teams.get(i - 1), ("0" + q)));
            MatchUps.get(q).AddJudge(Adj.get(Adj.size() - 1 - q));
            // MatchUps.get(q).display();
            q++;
        }
        System.out.println("\t:::::::::Matchup generation completed for " + RoundNoDisplay());
    }

    private String RoundNoDisplay() {
        switch (roundNo) {
            case 1:
                return "Round 1";
            case 2:
                return "Round 2";
            case 3:
                return "Round 3";
            case 4:
                return "Semi Finals";
            case 5:
                return "Finals";
            default:
                return "";
        }
    }

    public void displayMatchUp() {
        System.out.println("\t**********Match UP for round" + roundNo + "**********");
        System.out.println("\tGovernment" + "\t" + "Opposition" + "Place" + "\t" + "Adjudicators");
        for (int i = 0; i < MatchUps.size(); i++) {
            MatchUps.get(i).display();
        }
    }

    public String getMotion() {
        return motion;
    }

    public void setMotion(String motion) {
        this.motion = motion;
    }
}
