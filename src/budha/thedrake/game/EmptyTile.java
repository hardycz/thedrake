package budha.thedrake.game;

import budha.thedrake.media.TileMedia;

/**
 * Created by havrda on 19/10/2017.
 */
public class EmptyTile extends Tile {
    public EmptyTile(TilePosition position){
        super(position);
    }
    @Override
    public boolean acceptsTroop(Troop troop){
        return true;
    }
    @Override
    public boolean hasTroop(){
        return false;
    }
    @Override
    public Troop troop(){
     throw new UnsupportedOperationException();
    }
    @Override
    public <T> T putToMedia(TileMedia<T> media) {
        return media.putEmptyTile(this);
    }
}
