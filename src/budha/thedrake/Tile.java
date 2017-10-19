package budha.thedrake;

/**
 * Created by havrda on 16/10/2017.
 */

public abstract class Tile {
    TilePosition position;
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
}



