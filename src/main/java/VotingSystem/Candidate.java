package VotingSystem;

enum Party {
    PCRM, PLDM, PCUS, PDM
}

class Candidate {
    private long id;
    private String name;
    private Party party;
    private int voteNumber = 0;

    Candidate(long id, String name, Party party) throws IllegalArgumentException {
        if (id <= 0) { throw new IllegalArgumentException("Идентификатор кандидата должен быть валидным!"); }
        if (name.length() == 0) { throw new IllegalArgumentException("Имя кандидата не должно быть пустым!"); }
        if (party == null) { throw new IllegalArgumentException("Кандидат должен принадлежать какой-либо партии!"); }
        this.id = id;
        this.name = name;
        this.party = party;
    }

    String getName() {
        return name;
    }

    int getVoteNumber() {
        return voteNumber;
    }

    String info() {
        return name + " - " + party + " (Количество голосов: " + voteNumber + ")";
    }

    void increaseVote() {
        voteNumber++;
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof Candidate)) { return false; }
        Candidate candidate = (Candidate)obj;
        return id == candidate.id;
    }
}
