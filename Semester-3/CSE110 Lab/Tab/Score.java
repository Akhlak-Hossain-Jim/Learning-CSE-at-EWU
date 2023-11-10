package Tab;

public class Score {
    private int round1;
    private int round2;
    private int round3;
    private int semifinal = -1;
    private int finalScore = -1;
    private int currentRound = 1;

    public Score() {
    }

    public void addScore(int val) {
        switch (currentRound) {
            case 1:
                round1 = val;
                currentRound++;
                break;
            case 2:
                round2 = val;
                currentRound++;
                break;
            case 3:
                round3 = val;
                currentRound++;
                break;
            case 4:
                semifinal = val;
                currentRound++;
                break;
            case 5:
                finalScore = val;
                currentRound++;
                break;
            default:
                break;
        }
    }

    public int getTotalScores() {
        return round1 + round2 + round3;
    }

    public void display() {
        System.out.println("Scores:");
        System.out.println("Round 1 : " + round1);
        System.out.println("Round 2 : " + round2);
        System.out.println("Round 3 : " + round3);
        if (semifinal == 0 || semifinal == 1) {
            System.out.println("Semifinal: " + semifinal);
        }
        if (finalScore == 0 || finalScore == 1) {
            System.out.println("Final       : " + finalScore);
        }
    }
}
