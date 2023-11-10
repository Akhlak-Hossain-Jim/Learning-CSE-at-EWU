package Tab;

public class Adjudicator extends Participants {
    private double initialPoint;

    private Score score;

    public Adjudicator() {
    }

    public Adjudicator(String n, String In, double ip) {
        super(n, In);
        this.initialPoint = ip;
    }

    public double getInitialPoint() {
        return initialPoint;
    }

    public Score getScore() {
        return score;
    }

    public void display() {
        System.out.println();
    }
}
