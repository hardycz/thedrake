package budha.thedrake.media;

import budha.thedrake.game.EmptyTile;
import budha.thedrake.game.TroopTile;

public interface TileMedia<T> {
	public T putTroopTile(TroopTile tile);	
	public T putEmptyTile(EmptyTile tile);
}
