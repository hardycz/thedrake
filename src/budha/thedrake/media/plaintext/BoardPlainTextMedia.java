package budha.thedrake.media.plaintext;

import java.io.OutputStream;
import java.io.PrintWriter;

import budha.thedrake.game.Board;
import budha.thedrake.game.Tile;
import budha.thedrake.media.BoardMedia;
import budha.thedrake.media.PrintMedia;

public class BoardPlainTextMedia extends PrintMedia implements BoardMedia<Void> {
	private final TilePlainTextMedia tileMedia;
	private final CapturedTroopsPlainTextMedia capturedMedia;
	
	public BoardPlainTextMedia(OutputStream stream) {
		super(stream);
		this.tileMedia = new TilePlainTextMedia(stream);
		this.capturedMedia = new CapturedTroopsPlainTextMedia(stream);
	}
	
	@Override
	public Void putBoard(Board board) {
		PrintWriter w = writer();

		w.println(board.dimension());
		for(Tile tile : board) {
			tile.putToMedia(tileMedia);
			w.println();
		}
		
		capturedMedia.putCapturedTroops(board.captured());
		
		return null;
	}
}
