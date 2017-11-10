package budha.thedrake.game;

import budha.thedrake.media.LeadersMedia;

public interface Leaders {
    public boolean isPlaced(PlayingSide side);
    public boolean leaderOn(PlayingSide side, TilePosition position);
    public TilePosition position(PlayingSide side);
    //TODO
    //V rozhraních Leaders, TroopStacks, GameState a Tile vytvořte metodu pro ukládání do příslušného média
    public <T> T putToMedia(LeadersMedia<T> media);
}