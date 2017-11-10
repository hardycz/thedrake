package budha.thedrake.media;

import budha.thedrake.game.BothLeadersPlaced;
import budha.thedrake.game.NoLeadersPlaced;
import budha.thedrake.game.OneLeaderPlaced;

public interface LeadersMedia<T> {
	public T putNoLeadersPlaced(NoLeadersPlaced leaders);
	public T putOneLeaderPlaced(OneLeaderPlaced leaders);
	public T putBothLeadersPlaced(BothLeadersPlaced leaders);
}
