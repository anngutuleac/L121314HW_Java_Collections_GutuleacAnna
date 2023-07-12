package VotingSystem;

interface UserStorageType {
    void add(User user);
    boolean contains(User user);
    void remove(User user);
    default boolean containsByUsername(User user) {
        return false;
    }
    default User[] users() { return null; }
}
