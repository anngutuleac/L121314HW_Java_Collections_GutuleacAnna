package VotingSystem;

interface CandidateManagerType {
    void add(Candidate candidate);
    void remove(Candidate candidate);
    Candidate[] candidates();
}

class CandidateManager implements CandidateManagerType {
    private UnitStorageType storage;

    CandidateManager(UnitStorageType storage) throws IllegalArgumentException {
        if (storage == null) { throw new IllegalArgumentException("Передан нулевой параметр при инициализации!"); }
        this.storage = storage;
    }

    public void add(Candidate candidate) {
        if (storage.contains(candidate)) {
            System.out.println("Такой кандидат уже существует");
            return;
        }
        storage.add(candidate);
        System.out.println("Кандидат " + candidate.getName() + " успешно добавлен");
    }

    public void remove(Candidate candidate) {
        if (!storage.contains(candidate)) {
            System.out.println("Кандидат " + candidate.getName() + " не найден");
            return;
        }
        storage.remove(candidate);
        System.out.println("Кандидат " + candidate.getName() + " успешно удален");
    }

    public Candidate[] candidates() {
        Candidate[] arr = new Candidate[storage.getUnits().size()];
        arr = storage.getUnits().toArray(arr);
        return arr;
    }
}
