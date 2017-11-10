package budha.thedrake.media.plaintext;

import budha.thedrake.game.BasicTroopStacks;
import budha.thedrake.game.PlayingSide;
import budha.thedrake.game.TroopInfo;
import budha.thedrake.game.TroopStacks;
import budha.thedrake.media.PrintMedia;
import budha.thedrake.media.TroopStacksMedia;

import java.io.OutputStream;
import java.io.PrintWriter;

public class TroopStacksPlainTextMedia extends PrintMedia implements TroopStacksMedia<Void>{
    //TODO
    public TroopStacksPlainTextMedia(OutputStream stream) {
        super(stream);
    }
    // TODO - test prepsani basictroopstacks na troopstacks...
    @Override
    public Void putBasicTroopStacks(BasicTroopStacks stacks) {
        PrintWriter w = writer();
        w.print("BLUE stack:");
        for(TroopInfo troop : stacks.troops(PlayingSide.BLUE)){
            w.printf(" %s",troop.name());
        }
        w.print("\nORANGE stack:");
        for(TroopInfo troop : stacks.troops(PlayingSide.BLUE)){
            w.printf(" %s",troop.name());
        }
        return null;
    }
}
