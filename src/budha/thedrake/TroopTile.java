package budha.thedrake;

/**
 * Created by havrda on 19/10/2017.
 */
public class TroopTile extends Tile {
    Troop troop;
    public TroopTile(TilePosition position, Troop troop){
        super(position);
        this.troop = troop;
    }
    @Override
    public boolean acceptsTroop(Troop troop){
        return false;
    }
    @Override
    public boolean hasTroop(){
        return true;
    }
    @Override
    public Troop troop(){
        return troop;
    }
}
