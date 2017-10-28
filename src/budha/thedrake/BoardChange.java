package budha.thedrake;

public abstract class BoardChange {
    protected Board initialBoard;
    protected TilePosition origin;
    protected TilePosition target;
    //TODO
/*
 * Konstruktor, který bere hrací desku, ze které vycházíme a poté
 * dvě souřadnice, jedna, ze které tah vychází a druhá, na kterou
 * tah směřuje.
 */
//Vytvořte tři implementace třídy BoardChange: StepOnly, CaptureOnly a StepAndCapture. Implemenujte je tak, že pouze volají příslušné metody ve třídě Board.
    protected BoardChange(Board initialBoard, TilePosition origin, TilePosition target){
        this.initialBoard = initialBoard;
        this.origin = origin;
        this.target = target;
    }

    // Gettry
    public Board initialBoard(){
        return initialBoard;
    }

    public TilePosition origin(){
        return origin;
    }

    public TilePosition target(){
        return target;
    }

    /*
     * Metoda, která vrací novou hrací desku vyrobenou podle toho,
     * jaký tah zrovna provádíme.
     */
    public abstract Board resultBoard(){

    }
//
}