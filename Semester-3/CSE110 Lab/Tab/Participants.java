package Tab;

public abstract class Participants {
    private String name;
    private String Id;
    private String institution;
    private static int assigner = 0;

    Participants() {
    }

    Participants(String n, String In) {
        this.name = n;
        this.institution = In;
        if (Participants.assigner < 10) {
            this.Id = "0" + Participants.assigner;
        } else {
            this.Id = "" + Participants.assigner;
        }
        assigner++;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void display();
}
