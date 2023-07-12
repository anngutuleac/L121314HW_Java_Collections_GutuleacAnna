package VotingSystem;

class UserManager {
    private UserStorageType storage = new UserStorage();
    private UserStorageType sessionStorage = new UserSessionStorage();

    void authorize(User user) {
        if (storage.contains(user)) {
            addToSessionStorage(user);
        } else {
            System.out.println("Ошибка в имени пользователя или в пароле");
        }
    }

    void register(User user) {
        if (storage.containsByUsername(user)) {
            System.out.println("Пользователь " + user.getUsername() + " уже существует");
            return;
        }
        storage.add(user);
        System.out.println("Пользователь " + user.getUsername() + " успешно зарегистрирован");
    }

    void logOut(User user) {
        if (!sessionStorage.contains(user)) {
            System.out.println("Пользователь " + user.getUsername() + " не авторизирован");
            return;
        }
        sessionStorage.remove(user);
        System.out.println("Пользователь " + user.getUsername() + " вышел из системы");
    }

    void delete(User user) {
        if (!storage.contains(user)) {
            System.out.println("Пользователь " + user.getUsername() + " не существует");
            return;
        }
        logOut(user);
        storage.remove(user);
        System.out.println("Пользователь " + user.getUsername() + " удален из системы");
    }

    void vote(User user, Candidate candidate) {
        if (candidate == null) { return; }
        if (!sessionStorage.contains(user)) {
            System.out.println("Пользователь " + user.getUsername() + " не авторизирован для голосования");
            return;
        }
        if (user.hasVoted()) {
            System.out.println("Пользователь " + user.getUsername() + " уже проголосовал");
            return;
        }
        user.vote(candidate);
        System.out.println("Пользователь " + user.getUsername() + " проголосовал за " + candidate.getName());
    }

    User[] authorizedUsers() {
        return sessionStorage.users();
    }

    boolean isAuthorized(User user) {
        return sessionStorage.contains(user);
    }

    private void addToSessionStorage(User user) {
        if (sessionStorage.contains(user)) {
            System.out.println("Пользователь " + user.getUsername() + " уже авторизирован");
            return;
        }
        sessionStorage.add(user);
        System.out.println("Пользователь " + user.getUsername() + " успешно авторизирован");
    }
}