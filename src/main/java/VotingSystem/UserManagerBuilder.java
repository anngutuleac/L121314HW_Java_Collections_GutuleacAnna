package VotingSystem;

class UserManagerBuilder {
    static UserManagerType build() {
        UnitStorageType storage = UnitStorageBuilder.build();
        UnitStorageType sessionStorage = UnitStorageBuilder.build();
        UserManagerType manager = new UserManager(storage, sessionStorage);
        return manager;
    }
}
