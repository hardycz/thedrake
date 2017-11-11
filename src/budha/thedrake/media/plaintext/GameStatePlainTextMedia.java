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
    // TODO
    @Override
    public Void putPlacingLeadersGameState(PlacingLeadersGameState state) {
        PrintWriter w = writer();
        // TYP
        w.println("LEADERS");
        // Pocet strazi
        int guards = 4;
        for(TroopInfo troop : state.troopStacks().troops(PlayingSide.BLUE))
            if(troop.name()=="Clubman") guards--;
        for(TroopInfo troop : state.troopStacks().troops(PlayingSide.ORANGE))
            if(troop.name()=="Clubman") guards--;
        w.println(guards);
        // Kdo je zrovna na tahu
        w.println(state.sideOnTurn().name());
        // Obsahy zasobniku
        state.troopStacks().putToMedia(troopStacksMedia);
        // Pozice vudcu
        state.leaders().putToMedia(leadersMedia);
        //
        state.board().putToMedia(boardMedia);

        return null;
    }

    @Override
    public Void putPlacingGuardsGameState(PlacingGuardsGameState state) {
        PrintWriter w = writer();
        // TYP
        w.println("GUARDS");
        // Pocet strazi
        // placeholder - TBD
        // Kdo je zrovna na tahu
        w.println(state.sideOnTurn().name());
        // Obsahy zasobniku
        state.troopStacks().putToMedia(troopStacksMedia);

        return null;
    }

    @Override
    public Void putMiddleGameState(MiddleGameState state) {
        PrintWriter w = writer();
        // TYP
        w.println("MIDDLE");
        // Pocet strazi
        // placeholder - TBD
        // Kdo je zrovna na tahu
        w.println(state.sideOnTurn().name());
        // Obsahy zasobniku
        state.troopStacks().putToMedia(troopStacksMedia);

        return null;
    }

    @Override
    public Void putFinishedGameState(VictoryGameState state) {
        PrintWriter w = writer();
        // TYP
        w.println("VICTORY");
        // Pocet strazi
        // placeholder - TBD
        // Kdo je zrovna na tahu
        w.println(state.sideOnTurn().name());
        // Obsahy zasobniku
        state.troopStacks().putToMedia(troopStacksMedia);

        return null;
    }
}
