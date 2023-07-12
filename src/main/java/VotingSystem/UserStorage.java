package VotingSystem;
import java.util.ArrayList;

class UserStorage implements UserStorageType {
    private ArrayList<User> users = new ArrayList<User>();

    public void add(User user) {
        users.add(user);
    }

    public boolean contains(User user) {
        return users.contains(user);
    }

    public void remove(User user) {
        users.remove(user);
    }

    public boolean containsByUsername(User user) {
        for (User u: users) {
            if (u.getUsername() == user.getUsername()) { return true; }
        }
        return false;
    }
}
