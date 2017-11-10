package budha.thedrake.media.plaintext;

import java.io.BufferedReader;
import java.io.IOException;

import budha.thedrake.game.EmptyTile;
import budha.thedrake.game.PlayingSide;
import budha.thedrake.game.TheDrakeSetup;
import budha.thedrake.game.Tile;
import budha.thedrake.game.TilePosition;
import budha.thedrake.game.Troop;
import budha.thedrake.game.TroopFace;
import budha.thedrake.game.TroopInfo;
import budha.thedrake.game.TroopTile;

public class TileFromPlainText {
	private final TheDrakeSetup setup;
	private final BufferedReader reader;
	
	public TileFromPlainText(TheDrakeSetup setup, BufferedReader reader) {
		this.setup = setup;
		this.reader = reader;
	}
	
	public Tile readTile(TilePosition position) throws IOException {
		String line = reader.readLine();
		
		if("empty".equals(line)) {
			return new EmptyTile(position);
		}
		
		String[] fields = line.split(" ");
		TroopInfo info = setup.infoByName(fields[0]);
		PlayingSide side = PlayingSide.valueOf(fields[1]); 
		TroopFace face = TroopFace.valueOf(fields[2]);
		Troop troop = new Troop(info, side, face);		
		return new TroopTile(position, troop);
	}
}
