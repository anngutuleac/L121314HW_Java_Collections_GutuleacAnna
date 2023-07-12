package VotingSystem;
import java.util.ArrayList;

class UserSessionStorage implements UserStorageType {
    private ArrayList<User> userSessions = new ArrayList<User>();

    public void add(User user) {
        userSessions.add(user);
    }

    public boolean contains(User user) {
        return userSessions.contains(user);
    }

    public void remove(User user) {
        userSessions.remove(user);
    }

    public User[] users() {
        User[] arr = new User[userSessions.size()];
        arr = userSessions.toArray(arr);
        return arr;
    }

}
