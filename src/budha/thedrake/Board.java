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

        for(Tile t : tiles){

        }
    }

    // Rozměr hrací desky
    public int dimension(){
        return this.boardDimension;
    }

    // Vrací dlaždici na zvolené pozici. Pokud je pozice mimo desku, vyhazuje IllegalArgumentException
    public Tile tileAt(TilePosition position){
        if(!contains(position))
            throw new IllegalArgumentException();

    }

    // Ověřuje, že pozice se nachází na hrací desce
    public boolean contains(TilePosition... positions){

        for(TilePosition t : positions){
            if(t.column() > boardDimension)
                return false;
            else if(t.row() > boardDimension)
                return false;
        }
        return true;
    }

    // Vytváří novou hrací desku s novými dlaždicemi
    public Board withTiles(Tile... tiles){



    }
}

