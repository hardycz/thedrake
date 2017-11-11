package budha.thedrake.media.plaintext;

import budha.thedrake.game.*;
import budha.thedrake.media.GameStateMedia;
import budha.thedrake.media.PrintMedia;

import java.io.OutputStream;
import java.io.PrintWriter;

public class GameStatePlainTextMedia extends PrintMedia implements GameStateMedia<Void> {
    //TODO
    private final BoardPlainTextMedia boardMedia;
    private final TroopStacksPlainTextMedia troopStacksMedia;
    private final LeadersPlainTextMedia leadersMedia;

    public GameStatePlainTextMedia(OutputStream stream) {
        super(stream);
        this.boardMedia = new BoardPlainTextMedia(stream);
        this.troopStacksMedia= new TroopStacksPlainTextMedia(stream);
        this.leadersMedia= new LeadersPlainTextMedia(stream);
    }
    public Void putUniversal(BaseGameState state){
        PrintWriter w = writer();
        // Pocet strazi
        w.println(state.troopStacks().guards());
        // Kdo je zrovna na tahu
        w.println(state.sideOnTurn().name());
        // Obsahy zasobniku
        state.troopStacks().putToMedia(troopStacksMedia);
        // Pozice vudcu
        state.leaders().putToMedia(leadersMedia);
        // Vypis board
        state.board().putToMedia(boardMedia);
        return null;
    }
    // TODO
    @Override
    public Void putPlacingLeadersGameState(PlacingLeadersGameState state) {
        PrintWriter w = writer();
        // TYP hry
        w.println("LEADERS");
        // Vypis
        putUniversal(state);
        return null;
    }

    @Override
    public Void putPlacingGuardsGameState(PlacingGuardsGameState state) {
        PrintWriter w = writer();
        // TYP hry
        w.println("GUARDS");
        // Vypis
        putUniversal(state);
        return null;
    }

    @Override
    public Void putMiddleGameState(MiddleGameState state) {
        PrintWriter w = writer();
        // TYP hry
        w.println("MIDDLE");
        // Vypis
        putUniversal(state);
        return null;
    }

    @Override
    public Void putFinishedGameState(VictoryGameState state) {
        PrintWriter w = writer();
        // TYP hry
        w.println("VICTORY");
        // Vypis
        putUniversal(state);

        return null;
    }
}
