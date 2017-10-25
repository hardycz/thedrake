package budha.thedrake;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CapturedTroops{
    private List<TroopInfo> troopsPlayer1;
    private List<TroopInfo> troopsPlayer2;
//TODO
// Konstruktor vytvářející prázdné seznamy
    public CapturedTroops(){
        troopsPlayer1 = new ArrayList<TroopInfo>();
        troopsPlayer2 = new ArrayList<TroopInfo>();
    }

// Vrací seznam zajatých jednotek pro daného hráče
    public List<TroopInfo> troops(PlayingSide side){
        return (side == PlayingSide.ORANGE)?
                Collections.unmodifiableList(troopsPlayer1):
                Collections.unmodifiableList(troopsPlayer2);
    }

// Přidává nově zajatou jednotku na začátek seznamu zajatých jednotek daného hráče.
    public CapturedTroops withTroop(PlayingSide side, TroopInfo info){
       CapturedTroops newCapturedTroops = new CapturedTroops();
       newCapturedTroops.cloneCapturedTroops();

    }
    // TODO
    cloneCapturedTroops(List<TroopInfo> troopsPlayer1, List<TroopInfo> troopsPlayer2){
        this.troopsPlayer1 = troopsPlayer1.clone();
    }
}