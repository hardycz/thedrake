package budha.thedrake.media.plaintext;

import budha.thedrake.game.EmptyTile;
import budha.thedrake.game.TroopTile;
import budha.thedrake.media.PrintMedia;
import budha.thedrake.media.TileMedia;

import java.io.OutputStream;

public class TilePlainTextMedia extends PrintMedia implements TileMedia<Void>{
    //TODO
    public TilePlainTextMedia(OutputStream stream) {
        super(stream);
    }
    @Override
    public Void putTroopTile(TroopTile tile) {
        return null;
    }

    @Override
    public Void putEmptyTile(EmptyTile tile) {
        return null;
    }
}
