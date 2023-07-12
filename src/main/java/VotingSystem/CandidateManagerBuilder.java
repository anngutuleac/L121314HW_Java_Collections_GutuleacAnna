package VotingSystem;

class CandidateManagerBuilder {
    static CandidateManagerType build() {
        UnitStorageType storage = UnitStorageBuilder.build();
        CandidateManagerType manager = new CandidateManager(storage);
        return manager;
    }
}
