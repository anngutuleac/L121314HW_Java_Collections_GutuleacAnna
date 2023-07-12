package VotingSystem;
import java.util.ArrayList;

interface UnitStorageType {
    void add(UnitType unit);
    boolean contains(UnitType unit);
    void remove(UnitType unit);
    ArrayList<UnitType> getUnits();
    boolean containsByName(UnitType unit);
}

class UnitStorage implements UnitStorageType {
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

    public boolean containsByName(UnitType unit) {
        for (UnitType u: units) {
            if (u.getName() == unit.getName()) { return true; }
        }
        return false;
    }
}
