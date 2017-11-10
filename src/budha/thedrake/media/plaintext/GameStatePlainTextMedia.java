package budha.thedrake.media.plaintext;

import budha.thedrake.game.MiddleGameState;
import budha.thedrake.game.PlacingGuardsGameState;
import budha.thedrake.game.PlacingLeadersGameState;
import budha.thedrake.game.VictoryGameState;
import budha.thedrake.media.GameStateMedia;
import budha.thedrake.media.PrintMedia;

import java.io.OutputStream;

public class GameStatePlainTextMedia extends PrintMedia implements GameStateMedia<Void> {
    //TODO
    public GameStatePlainTextMedia(OutputStream stream) {
        super(stream);
    }

    @Override
    public Void putPlacingLeadersGameState(PlacingLeadersGameState state) {
        return null;
    }

    @Override
    public Void putPlacingGuardsGameState(PlacingGuardsGameState state) {
        return null;
    }

    @Override
    public Void putMiddleGameState(MiddleGameState state) {
        return null;
    }

    @Override
    public Void putFinishedGameState(VictoryGameState state) {
        return null;
    }
}
