package VotingSystem;

class User implements UnitType {
    private String username;
    private String password;
    private Candidate selectedCandidate = null;
    private int minNameLength = 4;
    private int minPassLength = 8;

    User(String username, String password) throws IllegalArgumentException {
        if (username.length() < minNameLength) { throw new IllegalArgumentException("Имя пользователя должно содержать не менее " + minNameLength + " символов!"); }
        if (password.length() < minPassLength) { throw new IllegalArgumentException("Пароль должен содержать не менее " + minPassLength + " символов!"); }
        this.username = username;
        this.password = password;
    }

    void vote(Candidate candidate) {
        selectedCandidate = candidate;
        selectedCandidate.increaseVote();
    }

    boolean hasVoted() {
        return selectedCandidate != null;
    }

    public String getName() {
        return username;
    }

    public String description() {
        if (selectedCandidate != null) {
            return username + " (Выбраный кандидат: " + selectedCandidate.getName() + ")";
        } else {
            return username + " (Кандидат не выбран)";
        }
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof User)) { return false; }
        User user = (User)obj;
        return username == user.username && password == user.password;
    }
}
