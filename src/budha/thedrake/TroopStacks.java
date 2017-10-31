package budha.thedrake;

import java.util.List;
//TODO
//prohlednout implementaci

public interface TroopStacks {
    public Troop peek(PlayingSide side);
    public TroopStacks pop(PlayingSide side);
    public List<TroopInfo> troops(PlayingSide side);
}