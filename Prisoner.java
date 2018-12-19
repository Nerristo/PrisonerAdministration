public class Prisoner {
    private String name = "";
    private String crime = "";
    private int age = 0;
    private int sentenceTime = 0;
    private boolean solitary = false;
    private boolean inCell = false;

    public Prisoner(String name, String crime, int age, int sentenceTime, boolean solitary) {
        this.name = name;
        this.crime = crime;
        this.age = age;
        this.sentenceTime = sentenceTime;
        this.solitary = solitary;
        this.inCell = false;
    }

    @Override
    public String toString() {
        return "Name: " + name + " --- Crime: " + crime + " --- Age: " + age + " --- Sentence Time: " + sentenceTime +
                " --- Solitary: " + solitary + "\n";
    }

    public String getName() {
        return name;
    }

    public String getCrime() {
        return crime;
    }

    public int getAge() {
        return age;
    }

    public int getSentenceTime() {
        return sentenceTime;
    }

    public boolean isSolitary() {
        return solitary;
    }

    public void setInCell() {
        this.inCell = true;
    }

    public boolean isInCell() {
        return inCell;
    }
}

// https://pastebin.com/7bf4nBuc
// https://stackoverflow.com/questions/10168066/how-to-print-out-all-the-elements-of-a-list-in-java/26901895