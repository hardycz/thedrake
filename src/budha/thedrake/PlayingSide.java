package budha.thedrake;

/**
 * Created by havrda on 12/10/2017.
 */
public enum PlayingSide {
    ORANGE, BLUE{
        @Override
        public PlayingSide opposite() {
            return ORANGE;
        }
    };

    public PlayingSide opposite() {
        return BLUE;
    }
}
