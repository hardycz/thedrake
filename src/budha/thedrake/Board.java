package budha.thedrake;

/**
 * Created by havrda on 16/10/2017.
 */
public class Board {
    private final Tile playingBoard[][];
    private final int boardDimension;

    // Konstruktor. Vytvoří čtvercovou hrací desku zadaného rozměru se specefikovanými dlaždicemi.
    // Všechny ostatní dlažice se berou jako prázdné.
    public Board(int dimension, Tile... tiles){
        this.playingBoard = new Tile[dimension][dimension];
        this.boardDimension = dimension;

        for(int i = 0; i < boardDimension; ++i){
            for(int j = 0; j < boardDimension; ++j){
                playingBoard[i][j] = new EmptyTile(new TilePosition(i,j));
            }
        }
        for(Tile t : tiles){
            playingBoard[t.position().i][t.position().j] = t;
        }
    }

    // Rozměr hrací desky
    public int dimension(){
        return this.boardDimension;
    }

    // Vrací dlaždici na zvolené pozici. Pokud je pozice mimo desku, vyhazuje IllegalArgumentException
    public Tile tileAt(TilePosition position){
        if(this.contains(position)){
            return playingBoard[position.i][position.j];
        }else{
            throw new IllegalArgumentException();
        }
    }
    // Ověřuje, že pozice se nachází na hrací desce
    public boolean contains(TilePosition... positions){
        for(TilePosition t : positions){
            if(t.i >= boardDimension || t.i<0){
                return false;
            }
            else if(t.j >= boardDimension || t.j<0){
                return false;
            }
        }
        return true;
    }
    // Vytváří novou hrací desku s novými dlaždicemi
    public Board withTiles(Tile... tiles){
        Board newBoard = new Board(boardDimension);
        newBoard.copyBoard(playingBoard);
        newBoard.insertToBoard(tiles);
        return newBoard;
    }
    public void copyBoard(Tile newBoard[][]){
        for(int i = 0; i < boardDimension; i++)
            playingBoard[i] = newBoard[i].clone();
    }
    public void insertToBoard(Tile... tiles){
        for(Tile t : tiles){
            playingBoard[t.position().i][t.position().j] = t;
        }
    }
}