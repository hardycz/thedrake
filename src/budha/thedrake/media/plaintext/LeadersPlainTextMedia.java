package budha.thedrake.media.plaintext;

import budha.thedrake.game.BothLeadersPlaced;
import budha.thedrake.game.NoLeadersPlaced;
import budha.thedrake.game.OneLeaderPlaced;
import budha.thedrake.media.LeadersMedia;
import budha.thedrake.media.PrintMedia;

import java.io.OutputStream;

public class LeadersPlainTextMedia extends PrintMedia implements LeadersMedia<Void> {
    //TODO
    public LeadersPlainTextMedia(OutputStream stream) {
        super(stream);
    }
    @Override
    public Void putNoLeadersPlaced(NoLeadersPlaced leaders) {
        return null;
    }

    @Override
    public Void putOneLeaderPlaced(OneLeaderPlaced leaders) {
        return null;
    }

    @Override
    public Void putBothLeadersPlaced(BothLeadersPlaced leaders) {
        return null;
    }
}
