package VotingSystem;

class UserStorage extends UnitStorage {
    boolean containsByName(UnitType unit) {
        for (UnitType u: getUnits()) {
            if (u.getName() == unit.getName()) { return true; }
        }
        return false;
    }
}
