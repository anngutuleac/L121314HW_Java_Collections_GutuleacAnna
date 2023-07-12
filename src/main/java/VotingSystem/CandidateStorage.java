package VotingSystem;

class CandidateStorage extends UnitStorage {
    Candidate[] candidates() {
        Candidate[] arr = new Candidate[getUnits().size()];
        arr = getUnits().toArray(arr);
        return arr;
    }
}
