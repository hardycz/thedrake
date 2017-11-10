
package budha.thedrake.media;

import budha.thedrake.game.MiddleGameState;
import budha.thedrake.game.PlacingGuardsGameState;
import budha.thedrake.game.PlacingLeadersGameState;
import budha.thedrake.game.VictoryGameState;

public interface GameStateMedia<T> {
	public T putPlacingLeadersGameState(PlacingLeadersGameState state);
	public T putPlacingGuardsGameState(PlacingGuardsGameState state);
	public T putMiddleGameState(MiddleGameState state);
	public T putFinishedGameState(VictoryGameState state);
}

