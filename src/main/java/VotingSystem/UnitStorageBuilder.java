package VotingSystem;

import java.util.ArrayList;

class UnitStorageBuilder {
    static UnitStorageType build() {
        ArrayList<UnitType> units = new ArrayList<>();
        UnitStorageType storage = new UnitStorage(units);
        return storage;
    }
}
