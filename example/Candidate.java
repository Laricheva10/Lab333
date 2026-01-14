package labs;

public class Candidate {
    private String name;
    private int votes;
    
    public Candidate(String name) {
        this.name = name;
        this.votes = 0;
    }
    
    public Candidate(String name, int votes) {
        this.name = name;
        this.votes = votes;
    }
    
    public String getName() {
        return name;
    }
    
    public int getVotes() {
        return votes;
    }
    
    public void addVote() {
        votes++;
    }
    
    public void addVotes(int n) {
        votes += n;
    }
}
