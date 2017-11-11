package budha.thedrake.media.plaintext;

import budha.thedrake.game.BothLeadersPlaced;
import budha.thedrake.game.NoLeadersPlaced;
import budha.thedrake.game.OneLeaderPlaced;
import budha.thedrake.game.PlayingSide;
import budha.thedrake.media.LeadersMedia;
import budha.thedrake.media.PrintMedia;

import java.io.OutputStream;
import java.io.PrintWriter;

public class LeadersPlainTextMedia extends PrintMedia implements LeadersMedia<Void> {
    //TODO
    public LeadersPlainTextMedia(OutputStream stream) {
        super(stream);
    }
    @Override
    public Void putNoLeadersPlaced(NoLeadersPlaced leaders) {
        PrintWriter w = writer();
        w.println("NL");
        return null;
    }

    @Override
    public Void putOneLeaderPlaced(OneLeaderPlaced leaders) {
        PrintWriter w = writer();
        if (leaders.isPlaced(PlayingSide.BLUE)) w.printf("OL %s\n",leaders.position(PlayingSide.BLUE).toString());
            else w.printf("OL X %s\n",leaders.position(PlayingSide.ORANGE).toString());
        return null;
    }

    @Override
    public Void putBothLeadersPlaced(BothLeadersPlaced leaders) {
        PrintWriter w = writer();
        w.printf("BL %s %s\n",leaders.position(PlayingSide.BLUE).toString(),leaders.position(PlayingSide.ORANGE).toString());
        return null;
    }
}
