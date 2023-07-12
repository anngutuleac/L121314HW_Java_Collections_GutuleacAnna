package VotingSystem;
import java.util.ArrayList;

interface UnitStorageType {
    void add(UnitType unit);
    boolean contains(UnitType unit);
    void remove(UnitType unit);
}

abstract class UnitStorage implements UnitStorageType {
    private ArrayList<UnitType> units = new ArrayList<>();

    public void add(UnitType unit) {
        units.add(unit);
    }

    public boolean contains(UnitType unit) {
        return units.contains(unit);
    }

    public void remove(UnitType unit) {
        units.remove(unit);
    }

    public ArrayList<UnitType> getUnits() {
        return units;
    }
}
