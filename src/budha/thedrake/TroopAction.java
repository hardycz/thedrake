package budha.thedrake;

import java.util.List;

//TODO
// Rozhraní má pouze jednu metodu changesFrom(). Jejím úkolem je vygenerovat všechny možné změny hrací desky board, které lze pomocí této akce provést z políčka origin pro hráče side.

public interface TroopAction {
    public List<BoardChange> changesFrom(TilePosition origin, PlayingSide side, Board board);
}