package VotingSystem;

class VotingSystemBuilder {
    static VotingSystemType build() {
        UserManagerType userManager = UserManagerBuilder.build();
        CandidateManagerType candidateManager = CandidateManagerBuilder.build();
        VotingSystemType votingSystem = new VotingSystem(userManager, candidateManager);

        return votingSystem;
    }
}
