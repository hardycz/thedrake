package budha.thedrake;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CapturedTroops {
    private List<TroopInfo> troopsPlayerOne;
    private List<TroopInfo> troopsPlayerTwo;

    //TODO
// Konstruktor vytvářející prázdné seznamy
    public CapturedTroops() {
        troopsPlayerOne = new ArrayList<TroopInfo>();
        troopsPlayerTwo = new ArrayList<TroopInfo>();
    }

    // Vrací seznam zajatých jednotek pro daného hráče
    public List<TroopInfo> troops(PlayingSide side) {
        return (side == PlayingSide.ORANGE) ?
                Collections.unmodifiableList(troopsPlayerOne):
                Collections.unmodifiableList(troopsPlayerTwo);
    }

    // Přidává nově zajatou jednotku na začátek seznamu zajatých jednotek daného hráče.
    public CapturedTroops withTroop(PlayingSide side, TroopInfo info) {
        CapturedTroops newCapturedTroops = new CapturedTroops();
        newCapturedTroops.cloneCapturedTroops(this.troopsPlayerOne, this.troopsPlayerTwo);
        newCapturedTroops.addTroopToList(side, info);
        return newCapturedTroops;
    }
    private void cloneCapturedTroops(List<TroopInfo> oldTroopsPlayerOne, List<TroopInfo> oldTroopsPlayerTwo) {
        Collections.copy(this.troopsPlayerOne, oldTroopsPlayerOne);
        Collections.copy(this.troopsPlayerTwo, oldTroopsPlayerTwo);
    }

    private void addTroopToList(PlayingSide side, TroopInfo info){
        if(side == PlayingSide.ORANGE) troopsPlayerOne.add(info);
            else troopsPlayerTwo.add(info);
    }
}