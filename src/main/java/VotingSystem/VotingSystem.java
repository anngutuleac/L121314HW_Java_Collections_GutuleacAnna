package VotingSystem;

class VotingSystem {
    private UserManager userManager = new UserManager();
    private CandidateManager candidatesManager = new CandidateManager();

    void add(Candidate candidate) {
        candidatesManager.add(candidate);
    }

    void remove(Candidate candidate) {
        candidatesManager.remove(candidate);
    }

    void authorize(User user) {
        userManager.authorize(user);
    }

    void register(User user) {
        userManager.register(user);
    }

    void logOut(User user) {
        userManager.logOut(user);
    }

    void delete(User user) {
        userManager.delete(user);
    }

    void printCandidates() {
        for (int i = 0; i < candidatesManager.candidates().length; i++) {
            Candidate candidate = candidatesManager.candidates()[i];
            System.out.println((i + 1) + ". " + candidate.info());
        }
    }

    void printAuthorizedUsers() {
        for (int i = 0; i < userManager.authorizedUsers().length; i++) {
            User user = userManager.authorizedUsers()[i];
            System.out.println((i + 1) + ". " + user.info());
        }
    }

    void vote(User user, Candidate candidate) {
        if (userManager.isAuthorized(user)) {
            userManager.vote(user, candidate);
        } else {
            System.out.println("Пользователь " + user.getUsername() + " не авторизирован для голосования");
        }
    }

    void printHighestVotedCandidate() {
        int defaultVoteNumber = 0;
        int maxVoteNumber = defaultVoteNumber;
        int maxVotedCandidateIndex = 0;
        for (int i = 0; i < candidatesManager.candidates().length; i++) {
            Candidate candidate = candidatesManager.candidates()[i];
            if (candidate.getVoteNumber() > maxVoteNumber) {
                maxVoteNumber = candidate.getVoteNumber();
                maxVotedCandidateIndex = i;
            }
        }
        if (maxVoteNumber == defaultVoteNumber) { return; }
        Candidate candidate = candidatesManager.candidates()[maxVotedCandidateIndex];
        System.out.println("Кандидат с наибольшим количеством голосов: " + candidate.info());
    }
}
