package VotingSystem;

interface CandidateStorageType {
    void add(Candidate candidate);
    boolean contains(Candidate candidate);
    void remove(Candidate candidate);
    Candidate[] candidates();
}
