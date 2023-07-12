package VotingSystem;
import java.util.ArrayList;

interface CandidateStorageType {
    void add(Candidate candidate);
    boolean contains(Candidate candidate);
    void remove(Candidate candidate);
    Candidate[] candidates();
}

class CandidateStorage implements CandidateStorageType {
    private ArrayList<Candidate> candidates = new ArrayList<Candidate>();

    public void add(Candidate candidate) {
        candidates.add(candidate);
    }

    public boolean contains(Candidate candidate) {
        return candidates.contains(candidate);
    }

    public void remove(Candidate candidate) {
        candidates.remove(candidate);
    }

    public Candidate[] candidates() {
        Candidate[] arr = new Candidate[candidates.size()];
        arr = candidates.toArray(arr);
        return arr;
    }
}
