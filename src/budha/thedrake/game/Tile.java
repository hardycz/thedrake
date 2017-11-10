package budha.thedrake.game;

import budha.thedrake.media.TileMedia;

/**
 * Created by havrda on 16/10/2017.
 */

public abstract class Tile {
    protected TilePosition position;
    // Konstruktor, který očekává pozici dlaždice na hracím plánu
    protected Tile(TilePosition position) {
        this.position = position;
    }

    // Pozice dlaždice na hracím plánu
    public TilePosition position() {
        return position;
    }

    // Je možné na dlaždici postavit zadanou jednotku?
    public abstract boolean acceptsTroop(Troop troop);
    // Stojí na dlaždici nějaká jednotka?
    public abstract boolean hasTroop();
    // Jednotka, která na dlaždici zrovna stojí. Pokud tam žádná není, vyhazuje UnsupportedOperationException
    public abstract Troop troop();
    //V rozhraních Leaders, TroopStacks, GameState a Tile vytvořte metodu pro ukládání do příslušného média
    public abstract <T> T putToMedia(TileMedia<T> media);
}



