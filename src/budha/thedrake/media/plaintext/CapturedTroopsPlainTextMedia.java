package budha.thedrake.media.plaintext;

import budha.thedrake.game.CapturedTroops;
import budha.thedrake.media.CapturedTroopsMedia;
import budha.thedrake.media.PrintMedia;

import java.io.OutputStream;

public class CapturedTroopsPlainTextMedia extends PrintMedia implements CapturedTroopsMedia<Void> {
    //TODO
    public CapturedTroopsPlainTextMedia(OutputStream stream) {
        super(stream);
    }
    @Override
    public Void putCapturedTroops(CapturedTroops captured) {
        return null;
    }
}
