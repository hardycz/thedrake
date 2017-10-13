package budha.thedrake;

/**
 * Created by havrda on 12/10/2017.
 */
public class Troop {
    private final TroopInfo info;
    private final PlayingSide side;
    private final TroopFace face;
    //
    //
    // Konstruktor
    public Troop(TroopInfo info, PlayingSide side, TroopFace face){
        this.info = info;
        this.side = side;
        this.face = face;
    }
    // Info o jednotce
    public TroopInfo info(){
        return info;
    }
    // Barva, za kterou jednotka hraje
    public PlayingSide side(){
        return side;
    }
    // Kterou stranou je jednotka otočena nahoru
    public TroopFace face(){
        return face;
    }
    // Pivot té strany, kterou je zrovna jednotka otočena nahoru
    public Offset2D pivot(){
        return info.pivot(face);
    }
    // Vytvoří jednotku, která má stejné vlastnosti jako tato, jen je otočena druhou stranou nahoru.
    public Troop flipped(){
        return new Troop(info, side, (face==TroopFace.BACK)?TroopFace.FRONT:TroopFace.BACK);
    }
}
