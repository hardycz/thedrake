package budha.thedrake;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CapturedTroops {
    private final LinkedList<TroopInfo> capturedBlue;
    private final LinkedList<TroopInfo> capturedOrange;

    // Konstruktor vytvářející prázdné seznamy
    public CapturedTroops(){
        capturedBlue = new LinkedList<>();
        capturedOrange = new LinkedList<>();
    }

    public CapturedTroops(CapturedTroops other, TroopInfo info, PlayingSide side) {

        capturedBlue = new LinkedList<>();
        capturedOrange = new LinkedList<>();

        capturedBlue.addAll(other.capturedBlue);
        capturedOrange.addAll(other.capturedOrange);

        if(side == PlayingSide.BLUE){
            capturedBlue.addFirst(info);
        } else {
            capturedOrange.addFirst(info);
        }

    }

    // Vrací seznam zajatých jednotek pro daného hráče
    public List<TroopInfo> troops(PlayingSide side) {

        if(side == PlayingSide.BLUE){
            List<TroopInfo> unmodifiableList = Collections.unmodifiableList(capturedBlue);
            return unmodifiableList;

        } else {
            List<TroopInfo> unmodifiableList = Collections.unmodifiableList(capturedOrange);
            return unmodifiableList;
        }
    }

    // Přidává nově zajatou jednotku na začátek seznamu zajatých jednotek daného hráče.
    public CapturedTroops withTroop(PlayingSide side, TroopInfo info){

        return new CapturedTroops(this, info, side);

    }
}