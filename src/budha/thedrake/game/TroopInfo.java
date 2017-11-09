package budha.thedrake.game;

import java.util.List;

/**
 * Created by havrda on 12/10/2017.
 */

public class TroopInfo {

    private final String name;
    private final Offset2D frontPivot;
    private final Offset2D backPivot;
    private final List<TroopAction> frontActions;
    private final List<TroopAction> backActions;
    // Konstruktor
    public TroopInfo(String name, Offset2D frontPivot, Offset2D backPivot, List<TroopAction> frontActions, List<TroopAction> backActions){
        this.name = name;
        this.frontPivot= frontPivot;
        this.backPivot = backPivot;
        this.frontActions = frontActions;
        this.backActions = backActions;
    }
    // Konstruktor, který nastaví lícový i rubový pivot na stejnou hodnotu
    public TroopInfo(String name, Offset2D pivot, List<TroopAction> frontActions, List<TroopAction> backActions) {
    this(name, pivot, pivot, frontActions, backActions);
}
    // Konstruktor, který nastaví lícový i rubový pivot na hodnotu [1, 1]
    public TroopInfo(String name, List<TroopAction> frontActions, List<TroopAction> backActions){
    this(name, new Offset2D(1,1), frontActions, backActions);
}
    //Přidejte do třídy metod, která vrací akce pro zadanou stranu jednotky.
    public List<TroopAction> actions(TroopFace face){
        return (face == TroopFace.FRONT) ? frontActions:backActions;
    }
    // Vrací jméno
    public String name(){
        return this.name;
    }
    // Vrací pivot na zadané straně jednotky
    public Offset2D pivot(TroopFace face){
        return (face == TroopFace.FRONT)?frontPivot:backPivot;
    }
}
