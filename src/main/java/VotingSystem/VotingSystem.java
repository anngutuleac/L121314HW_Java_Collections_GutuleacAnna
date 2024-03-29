package VotingSystem;

interface VotingSystemType {
    void add(Candidate candidate);
    void remove(Candidate candidate);
    void authorize(User user);
    void register(User user);
    void logOut(User user);
    void delete(User user);
    void vote(User user, Candidate candidate);
    void printCandidates();
    void printAuthorizedUsers();
    void printHighestVotedCandidate();
}

class VotingSystem implements VotingSystemType {
    private UserManagerType userManager;
    private CandidateManagerType candidatesManager;

    VotingSystem(UserManagerType userManager, CandidateManagerType candidatesManager) throws IllegalArgumentException {
        if (userManager == null || candidatesManager == null) { throw new IllegalArgumentException("Передан нулевой параметр при инициализации!"); }
        this.userManager = userManager;
        this.candidatesManager = candidatesManager;
    }

    public void add(Candidate candidate) {
        candidatesManager.add(candidate);
    }

    public void remove(Candidate candidate) {
        candidatesManager.remove(candidate);
    }

    public void authorize(User user) {
        userManager.authorize(user);
    }

    public void register(User user) {
        userManager.register(user);
    }

    public void logOut(User user) {
        userManager.logOut(user);
    }

    public void delete(User user) {
        userManager.delete(user);
    }

    public void vote(User user, Candidate candidate) {
        if (userManager.isAuthorized(user)) {
            userManager.vote(user, candidate);
        } else {
            System.out.println("Пользователь " + user.getName() + " не авторизирован для голосования");
        }
    }

    public void printCandidates() {
        print(candidatesManager.candidates());
    }

    public void printAuthorizedUsers() {
        print(userManager.authorizedUsers());
    }

    public void printHighestVotedCandidate() {
        int defaultVoteNumber = 0;
        int maxVoteNumber = defaultVoteNumber;
        int maxVotedCandidateIndex = 0;
        Candidate[] candidates = candidatesManager.candidates();
        for (int i = 0; i < candidates.length; i++) {
            Candidate candidate = candidates[i];
            if (candidate.getVoteNumber() > maxVoteNumber) {
                maxVoteNumber = candidate.getVoteNumber();
                maxVotedCandidateIndex = i;
            }
        }
        if (maxVoteNumber == defaultVoteNumber) { return; }
        Candidate candidate = candidates[maxVotedCandidateIndex];
        System.out.println("Кандидат с наибольшим количеством голосов: " + candidate.description());
    }

    private void print(UnitType[] unitTypes) {
        for (int i = 0; i < unitTypes.length; i++) {
            UnitType unitType = unitTypes[i];
            System.out.println((i + 1) + ". " + unitType.description());
        }
    }
}
