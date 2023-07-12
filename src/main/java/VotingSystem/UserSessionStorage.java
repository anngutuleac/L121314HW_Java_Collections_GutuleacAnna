package VotingSystem;

class UserSessionStorage extends UnitStorage {
    User[] users() {
        User[] arr = new User[getUnits().size()];
        arr = getUnits().toArray(arr);
        return arr;
    }
}
