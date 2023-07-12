package VotingSystem;

class CandidateManager {
    private CandidateStorageType storage = new CandidateStorage();

    void add(Candidate candidate) {
        if (storage.contains(candidate)) {
            System.out.println("Такой кандидат уже существует");
            return;
        }
        storage.add(candidate);
        System.out.println("Кандидат " + candidate.getName() + " успешно добавлен");
    }

    void remove(Candidate candidate) {
        if (!storage.contains(candidate)) {
            System.out.println("Кандидат " + candidate.getName() + " не найден");
            return;
        }
        storage.remove(candidate);
        System.out.println("Кандидат " + candidate.getName() + " успешно удален");
    }

    Candidate[] candidates() {
        return storage.candidates();
    }
}
