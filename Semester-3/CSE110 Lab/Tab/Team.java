package Tab;

import java.util.ArrayList;

public class Team {
    private String name;
    private String institution;
    private ArrayList<Debater> Members = new ArrayList<Debater>();
    private Score score;

    public Team() {
    }

    public Team(String n, String in, Debater a, Debater b, Debater c) {
        this.name = n;
        this.institution = in;
        Members.add(a);
        Members.add(b);
        Members.add(c);
    }

    public String getName() {
        return name;
    }

    public String getInstitution() {
        return institution;
    }

    public Score getScore() {
        return score;
    }

    public void display() {
    }
}
