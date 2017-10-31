package budha.thedrake;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CapturedTroops {
    private List<TroopInfo> capturedOrange;
    private List<TroopInfo> capturedBlue;

    // Konstruktor vytvářející prázdné seznamy
    public CapturedTroops() {
        capturedOrange = new ArrayList<TroopInfo>();
        capturedBlue = new ArrayList<TroopInfo>();
    }

    // Vrací seznam zajatých jednotek pro daného hráče
    public List<TroopInfo> troops(PlayingSide side) {
        return (side == PlayingSide.ORANGE) ?
                Collections.unmodifiableList(capturedOrange):
                Collections.unmodifiableList(capturedBlue);
    }

    // Přidává nově zajatou jednotku na začátek seznamu zajatých jednotek daného hráče.
    public CapturedTroops withTroop(PlayingSide side, TroopInfo info) {
        CapturedTroops newCapturedTroops = new CapturedTroops();
        newCapturedTroops.cloneCapturedTroops(this.capturedOrange, this.capturedBlue);
        newCapturedTroops.addTroopToList(side, info);
        return newCapturedTroops;
    }
    private void cloneCapturedTroops(List<TroopInfo> oldTroopsPlayerOne, List<TroopInfo> oldTroopsPlayerTwo) {
        this.capturedOrange = new ArrayList<>(oldTroopsPlayerOne);
        this.capturedBlue = new ArrayList<>(oldTroopsPlayerTwo);
    }

    private void addTroopToList(PlayingSide side, TroopInfo info){
        if(side == PlayingSide.ORANGE) capturedOrange.add(0,info);
        else capturedBlue.add(0,info);
    }
}