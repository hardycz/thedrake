package budha.thedrake;

import java.util.List;


public interface TheDrakeSetup {
    public List<TroopInfo> troops();
    // TODO
    // Vrátí info jednotky podle jména jednotky
    public TroopInfo infoByName(String name);
}