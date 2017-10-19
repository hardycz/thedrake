package budha.thedrake;

/**
 * Created by havrda on 12/10/2017.
 */
public class TroopInfo {
    private final String name;
    private final Offset2D frontPivot;
    private final Offset2D backPivot;
    // Konstruktor
    public TroopInfo(String name, Offset2D frontPivot, Offset2D backPivot){
        this.name = name;
        this.frontPivot= frontPivot;
        this.backPivot = backPivot;
    }
    // Konstruktor, který nastaví lícový i rubový pivot na stejnou hodnotu
public TroopInfo(String name, Offset2D pivot) {
    this(name, pivot, pivot);
}
    // Konstruktor, který nastaví lícový i rubový pivot na hodnotu [1, 1]
public TroopInfo(String name){
    this(name, new Offset2D(1,1));
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
