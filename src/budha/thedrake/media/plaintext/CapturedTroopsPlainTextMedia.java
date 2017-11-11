package budha.thedrake.media.plaintext;

import budha.thedrake.game.CapturedTroops;
import budha.thedrake.game.PlayingSide;
import budha.thedrake.game.TroopInfo;
import budha.thedrake.media.CapturedTroopsMedia;
import budha.thedrake.media.PrintMedia;

import java.io.OutputStream;
import java.io.PrintWriter;

public class CapturedTroopsPlainTextMedia extends PrintMedia implements CapturedTroopsMedia<Void> {
    //TODO
    public CapturedTroopsPlainTextMedia(OutputStream stream) {
        super(stream);
    }
    @Override
    public Void putCapturedTroops(CapturedTroops captured) {
        PrintWriter w = writer();
        // BLUE
        w.printf("Captured BLUE: %d\n",captured.troops(PlayingSide.BLUE).size());
        for(TroopInfo troop : captured.troops(PlayingSide.BLUE))
            w.println(troop.name());
        // ORANGE
        w.printf("Captured ORANGE: %d",captured.troops(PlayingSide.ORANGE).size());
        for(TroopInfo troop : captured.troops(PlayingSide.ORANGE))
            w.printf("\n%s",troop.name());
        return null;
    }
}
