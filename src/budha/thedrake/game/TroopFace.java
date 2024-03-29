package budha.thedrake.game;

public enum TroopFace {
    FRONT, BACK {
        @Override
        public TroopFace flipped() {
            return FRONT;
        }
        @Override
        public String toString(){
            return new String("FRONT");
        }
    };
    public TroopFace flipped() {
        return BACK;
    }
    public String toString(){
        return new String("BACK");
    }
}