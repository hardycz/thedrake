package budha.thedrake.game;

import budha.thedrake.media.TroopStacksMedia;

import java.util.List;

public interface TroopStacks {
    public Troop peek(PlayingSide side);
    public TroopStacks pop(PlayingSide side);
    public List<TroopInfo> troops(PlayingSide side);
    public int guards();
    public <T> T putToMedia(TroopStacksMedia<T> media);
}