package budha.thedrake.media.plaintext;

import budha.thedrake.game.BasicTroopStacks;
import budha.thedrake.media.PrintMedia;
import budha.thedrake.media.TroopStacksMedia;

import java.io.OutputStream;

public class TroopStacksPlainTextMedia extends PrintMedia implements TroopStacksMedia<Void>{
    //TODO

    public TroopStacksPlainTextMedia(OutputStream stream) {
        super(stream);
    }
    @Override
    public Void putBasicTroopStacks(BasicTroopStacks stacks) {
        return null;
    }
}
