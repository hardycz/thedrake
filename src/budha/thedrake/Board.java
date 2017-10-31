package budha.thedrake;

/**
 * Created by havrda on 16/10/2017.
 */
public class Board {
    private final Tile playingBoard[][];
    private final int boardDimension;
    private CapturedTroops capturedTroops;

    // Konstruktor. Vytvoří čtvercovou hrací desku zadaného rozměru se specifikovanými dlaždicemi.
    // Všechny ostatní dlažice se berou jako prázdné.
    public Board(int dimension, Tile... tiles){
        this.playingBoard = new Tile[dimension][dimension];
        this.boardDimension = dimension;
        this.capturedTroops = new CapturedTroops();

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

    // Getter pro zajate jednotky
    public CapturedTroops captured(){
        return capturedTroops;
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
        newBoard.copyBoard(playingBoard, capturedTroops);
        newBoard.insertToBoard(tiles);
        return newBoard;
    }

    // Kopirovani boardu - hraci desky a zajatych jednotek
    public void copyBoard(Tile newBoard[][], CapturedTroops oldCapturedTroops){
        for(int i = 0; i < boardDimension; i++)
            playingBoard[i] = newBoard[i].clone();
        capturedTroops = oldCapturedTroops;
    }

    // Vlozeni novych jednotek na hraci desku
    public void insertToBoard(Tile... tiles){
        for(Tile t : tiles){
            playingBoard[t.position().i][t.position().j] = t;
        }
    }
    // ukladani board atribut
    public Board withCaptureAndTiles(TroopInfo info, PlayingSide side, Tile... tiles){
        Board newBoard = this.withTiles(tiles);
        newBoard.captured().withTroop(side, info);
        return newBoard;
    }
    public boolean isThereTroopTile(TilePosition tile){
        try{
            tileAt(tile).hasTroop();
        } catch (Exception e){
            return false;
        }
        return true;
    }
    // Lze z dané pozice vzít jednotku, nebo-li, stojí na dané pozici nějaká jednotka?
    public boolean canTakeFrom(TilePosition origin){
        return ((contains(origin) && tileAt(origin) instanceof TroopTile));
    }

    // Lze na danou pozici postavit zadanou jednotku?
    public boolean canPlaceTo(Troop troop, TilePosition target){
        return ((contains(target) && tileAt(target) instanceof EmptyTile));
    }
    // Může zadaná jednotka zajmout na pozici target soupeřovu jednotku?
    public boolean canCaptureOn(Troop troop, TilePosition target) {
        return (contains(target) && (tileAt(target) instanceof TroopTile) && (tileAt(target).troop().side() != troop.side()));
    }
    /*
    * Stojí na políčku origin jednotka, která může zůstat na pozici origin
    * a zajmout soupeřovu jednotku na pozici target?
    */
    public boolean canCaptureOnly(TilePosition origin, TilePosition target){
        return (canTakeFrom(origin) && canCaptureOn(tileAt(origin).troop(), target));
    }
    /*
     * Může zadaná jednotka udělat krok z pozice origin na pozici target
     * bez toho, aby zajala soupeřovu jednotku?
     */
     public boolean canStepOnly(TilePosition origin, TilePosition target){
         return (canTakeFrom(origin) && (contains(target) && tileAt(target) instanceof EmptyTile));
     }

    /*
     * Může zadaná jednotka udělat krok z pozice origin na pozici target
     * s tím, že tak zajme soupeřovu jednotku?
     */
     public boolean canStepAndCapture(TilePosition origin, TilePosition target){
         return (canTakeFrom(origin) && canCaptureOn(tileAt(origin).troop(), target));
     }

    /*
     * Nová hrací deska, ve které jednotka na pozici origin se přesunula
     * na pozici target, kde zajala soupeřovu jednotku.
    */
    public Board stepAndCapture(TilePosition origin, TilePosition target) {
        Troop attacker = tileAt(origin).troop();
        Troop targetTroop = tileAt(target).troop();
        return withCaptureAndTiles(
                targetTroop.info(),
                targetTroop.side(),
                new EmptyTile(origin),
                new TroopTile(target, attacker.flipped()));
    }
    /*
     * Nová hrací deska, ve které jednotka na pozici origin se přesunula
     * na pozici target bez toho, aby zajala soupeřovu jednotku.
     */
    public Board stepOnly(TilePosition origin, TilePosition target){
        Troop troop = tileAt(origin).troop();

        return withTiles(
                new EmptyTile(origin),
                new TroopTile(target, troop.flipped()));
    }
    /*
     * Nová hrací deska, ve které jednotka zůstává stát na pozici origin
     * a zajme soupeřovu jednotku na pozici target.
     */
    public Board captureOnly(TilePosition origin, TilePosition target){
        Troop attacker = tileAt(origin).troop();
        Troop targetTroop = tileAt(target).troop();

        return withCaptureAndTiles(
                targetTroop.info(),
                targetTroop.side(),
                new EmptyTile(target),
                new TroopTile(origin, attacker.flipped()));
    }

}