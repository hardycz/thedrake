package budha.thedrake.game;

import budha.thedrake.media.GameStateMedia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MiddleGameState extends BaseGameState {

    public MiddleGameState( Board board,
                            TroopStacks troopStacks,
                            BothLeadersPlaced leaders,
                            PlayingSide sideOnTurn){
        super(board, troopStacks, leaders, sideOnTurn);
    }

    @Override
    public BothLeadersPlaced leaders() {
        return (BothLeadersPlaced)super.leaders();
    }

    @Override
    public List<Move> allMoves() {
        List<Move> result = new ArrayList<>();
        for(Tile tile : board()) {
            result.addAll(boardMoves(tile.position()));
        }
        result.addAll(stackMoves());
        return result;
    }

    @Override
    public List<Move> boardMoves(TilePosition position) {
        Troop troop;
        List<BoardChange> boardChanges;
        List<TroopAction> actions;
        List<Move> tmp = new ArrayList<>();
        Tile tile = board().tileAt(position);

        if(!tile.hasTroop()) {
            return Collections.emptyList();
        } else {
            troop = tile.troop();
            if(troop.side() != sideOnTurn()) {
                return Collections.emptyList();
            }
        }

        actions = troop.info().actions(troop.face());
        boardChanges = new ArrayList<>();

        for(TroopAction action : actions) {
            boardChanges = action.changesFrom(position, sideOnTurn(), board());
            for(BoardChange change : boardChanges){
                tmp.add(new BoardMove(this, change));
            }
        }


        return tmp;
    }

    @Override
    public List<Move> stackMoves() {
        List<Move> result = new ArrayList<>();
        for(Tile target : board()) {
            if(canPlaceFromStack(target.position())) {
                result.add(new PlaceFromStack(this, target.position()));
            }
        }
        return result;
    }

    @Override
    public boolean isVictory() {
        return false;
    }

    public boolean canPlaceFromStack(TilePosition target) {
        Troop troop = troopStacks().peek(sideOnTurn());
        if(!board().canPlaceTo(troop, target)) {
            return false;
        }

        if(troop.side() != sideOnTurn()){
            return false;
        }

        boolean hasLeaderAsNeigbour = false;
        hasLeaderAsNeigbour |= tryNeighbour(target, 0, 1);
        hasLeaderAsNeigbour |= tryNeighbour(target, 0, -1);
        hasLeaderAsNeigbour |= tryNeighbour(target, 1, 0);
        hasLeaderAsNeigbour |= tryNeighbour(target, -1, 0);

        return hasLeaderAsNeigbour;
    }

    public MiddleGameState placeFromStack(TilePosition target) {
        Troop troop = troopStacks().peek(sideOnTurn());
        return new MiddleGameState( board().withTiles(
                                    new TroopTile(target, troop)),
                                    troopStacks().pop(sideOnTurn()),
                                    leaders(),
                                    sideOnTurn().opposite());
    }
    private boolean tryNeighbour(TilePosition origin, int xStep, int yStep) {
        TilePosition tmp = origin.step(xStep, yStep);
        if(board().contains(tmp)){
            return board().tileAt(tmp).hasTroop() && (board().tileAt(tmp).troop().side() == sideOnTurn());

        }
        return false;
    }
    @Override
    public <T> T putToMedia(GameStateMedia<T> media) {
        return media.putMiddleGameState(this);
    }
}
