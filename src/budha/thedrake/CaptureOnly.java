package budha.thedrake;

//TODO
//Volat metody ze tridy board

public class CaptureOnly extends BoardChange{

    public CaptureOnly(Board initialBoard, TilePosition origin, TilePosition target){
        super(initialBoard,origin,target);
    }
    @Override
    public Board resultBoard() {
        return null;
    }
}
