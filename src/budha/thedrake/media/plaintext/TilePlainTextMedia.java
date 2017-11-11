package budha.thedrake.media.plaintext;

import budha.thedrake.game.EmptyTile;
import budha.thedrake.game.TroopTile;
import budha.thedrake.media.PrintMedia;
import budha.thedrake.media.TileMedia;

import java.awt.print.PrinterAbortException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class TilePlainTextMedia extends PrintMedia implements TileMedia<Void>{
    //TODO
    public TilePlainTextMedia(OutputStream stream) {
        super(stream);
    }
    @Override
    public Void putTroopTile(TroopTile tile) {
        PrintWriter w = writer();
        w.printf("%s %s %s",tile.troop().info().name(),tile.troop().side().name(),tile.troop().face().toString());
        return null;
    }

    @Override
    public Void putEmptyTile(EmptyTile tile) {
        PrintWriter w = writer();
        w.printf("empty");
        return null;
    }
}
