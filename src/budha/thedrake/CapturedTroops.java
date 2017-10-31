package budha.thedrake;

import com.sun.tools.javac.code.Type;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CapturedTroops {
    private final List<TroopInfo> capturedOrange;
    private final List<TroopInfo> capturedBlue;

    // Konstruktor vytvářející prázdné seznamy
    public CapturedTroops() {
        capturedOrange = new ArrayList<TroopInfo>();
        capturedBlue = new ArrayList<TroopInfo>();
    }
    public CapturedTroops(List<TroopInfo> oldOrange, List<TroopInfo> oldBlue, PlayingSide side, TroopInfo info) {
        capturedOrange = new ArrayList<>(oldOrange);
        capturedBlue = new ArrayList<>(oldBlue);
        if(side == PlayingSide.ORANGE) capturedOrange.add(0,info);
            else capturedBlue.add(0,info);
    }
    // Vrací seznam zajatých jednotek pro daného hráče
    public List<TroopInfo> troops(PlayingSide side) {
        return (side == PlayingSide.ORANGE) ?
                Collections.unmodifiableList(capturedOrange):
                Collections.unmodifiableList(capturedBlue);
    }

    // Přidává nově zajatou jednotku na začátek seznamu zajatých jednotek daného hráče.
    public CapturedTroops withTroop(PlayingSide side, TroopInfo info) {
        return new CapturedTroops(capturedOrange,capturedBlue,side,info);
    }
}