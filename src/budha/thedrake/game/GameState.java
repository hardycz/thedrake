package budha.thedrake.game;

import java.util.List;

public interface GameState {
	public Board board();
  public TroopStacks troopStacks();
  public PlayingSide sideOnTurn();
  public Leaders leaders();
  public boolean isVictory();
  
  public List<Move> allMoves();
  public List<Move> boardMoves(TilePosition position);
  public List<Move> stackMoves();
  //TODO
  //V rozhraních Leaders, TroopStacks, GameState a Tile vytvořte metodu pro ukládání do příslušného média
//    public <T> T putToMedia(NěcoMedia<T> media);

}
