package VotingSystem;

interface UserManagerType {
    void authorize(User user);
    void register(User user);
    void logOut(User user);
    void delete(User user);
    void vote(User user, Candidate candidate);
    User[] authorizedUsers();
    boolean isAuthorized(User user);
}

class UserManager implements UserManagerType {
    private UnitStorage storage = new UnitStorage();
    private UnitStorage sessionStorage = new UnitStorage();

    public void authorize(User user) {
        if (storage.contains(user)) {
            addToSessionStorage(user);
        } else {
            System.out.println("Ошибка в имени пользователя или в пароле");
        }
    }

    public void register(User user) {
        if (storage.containsByName(user)) {
            System.out.println("Пользователь " + user.getName() + " уже существует");
            return;
        }
        storage.add(user);
        System.out.println("Пользователь " + user.getName() + " успешно зарегистрирован");
    }

    public void logOut(User user) {
        if (!sessionStorage.contains(user)) {
            System.out.println("Пользователь " + user.getName() + " не авторизирован");
            return;
        }
        sessionStorage.remove(user);
        System.out.println("Пользователь " + user.getName() + " вышел из системы");
    }

    public void delete(User user) {
        if (!storage.contains(user)) {
            System.out.println("Пользователь " + user.getName() + " не существует");
            return;
        }
        logOut(user);
        storage.remove(user);
        System.out.println("Пользователь " + user.getName() + " удален из системы");
    }

    public void vote(User user, Candidate candidate) {
        if (candidate == null) { return; }
        if (!sessionStorage.contains(user)) {
            System.out.println("Пользователь " + user.getName() + " не авторизирован для голосования");
            return;
        }
        if (user.hasVoted()) {
            System.out.println("Пользователь " + user.getName() + " уже проголосовал");
            return;
        }
        user.vote(candidate);
        System.out.println("Пользователь " + user.getName() + " проголосовал за " + candidate.getName());
    }

    public User[] authorizedUsers() {
        User[] arr = new User[sessionStorage.getUnits().size()];
        arr = sessionStorage.getUnits().toArray(arr);
        return arr;
    }

    public boolean isAuthorized(User user) {
        return sessionStorage.contains(user);
    }

    private void addToSessionStorage(User user) {
        if (sessionStorage.contains(user)) {
            System.out.println("Пользователь " + user.getName() + " уже авторизирован");
            return;
        }
        sessionStorage.add(user);
        System.out.println("Пользователь " + user.getName() + " успешно авторизирован");
    }
}