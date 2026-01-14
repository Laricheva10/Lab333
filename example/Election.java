package labs;

public class Election {
    private Candidate[] candidates;
    private int count;

    public Election() {
        candidates = new Candidate[100];
        count = 0;
    }
    
    public void showCandidates() {
        if (count == 0) {
            System.out.println("Список кандидатов пуст");
            return;
        }
        
        for (int i = 0; i < count; i++) {
            System.out.println(candidates[i].getName() + ": " + candidates[i].getVotes() + " голосов");
        }
    }
    
    public void addCandidate(String name) {
        candidates[count] = new Candidate(name);
        count++;
        System.out.println("Добавлен: " + name);
    }
    
    public void addCandidateWithVotes(String name, int votes) {
        candidates[count] = new Candidate(name, votes);
        count++;
        System.out.println("Добавлен: " + name + " с " + votes + " голосами");
    }
    
    public int findCandidateByName(String name) {
        for (int i = 0; i < count; i++) {
            if (candidates[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    
    public void removeCandidate(String name) {
        int index = findCandidateByName(name);
        if (index == -1) return;
        
        for (int i = index; i < count - 1; i++) {
            candidates[i] = candidates[i + 1];
        }
        count--;
    }
    
    public void addVoteToCandidate(String name) {
        int index = findCandidateByName(name);
        if (index == -1) {
            System.out.println("Кандидат '" + name + "' не найден!");
            return;
        }
        candidates[index].addVote();
        System.out.println("Добавлен голос для: " + name);
    }
    
    public void addNVotesToCandidate(String name, int n) {
        int index = findCandidateByName(name);
        if (index == -1) {
            System.out.println("Кандидат '" + name + "' не найден!");
            return;
        }
        candidates[index].addVotes(n);
        System.out.println("Добавлено " + n + " голосов для: " + name);
    }
    
    public int getCandidateVotes(String name) {
        int index = findCandidateByName(name);
        if (index == -1) {
            return -1;
        }
        return candidates[index].getVotes();
    }
    
    public int getTotalVotes() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += candidates[i].getVotes();
        }
        return total;
    }
    
    public String getWinner() {
        Candidate winner = candidates[0];
        
        for (int i = 1; i < count; i++) {
            if (candidates[i].getVotes() > winner.getVotes()) {
                winner = candidates[i];
            }
        }
        
        return winner.getName();
    }
    
    public double getCandidatePercentage(String name) {
        int index = findCandidateByName(name);
        if (index == -1) {
            return -1;
        }
        
        int totalVotes = getTotalVotes();
        int candidateVotes = candidates[index].getVotes();
        
        return (candidateVotes * 100.0) / totalVotes;
    }
    
    public void showPercentageTable() {
        System.out.println("Кандидат - процент голосов");
        
        for (int i = 0; i < count; i++) {
            String имя = candidates[i].getName();
            double процент = getCandidatePercentage(имя);
            System.out.println(имя + " - " + String.format("%.1f", процент) + "%");
        }
    }
    
    public void removeCandidatesBelowThreshold(int threshold) {
        for (int i = count - 1; i >= 0; i--) {
            if (candidates[i].getVotes() < threshold) {
                for (int j = i; j < count - 1; j++) {
                    candidates[j] = candidates[j + 1];
                }
                count--;
            }
        }
    }
    
    public void countVotesFromArray(String[] votesArray) {
        for (int i = 0; i < votesArray.length; i++) {
            String name = votesArray[i];
            int index = findCandidateByName(name);
            if (index != -1) {
                candidates[index].addVote();
            }
        }
    }
}
