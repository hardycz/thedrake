package budha.thedrake.game;

public class TilePosition {
	public final int i;
	public final int j;

	public TilePosition(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public TilePosition(char column, int row) {
		this.i = iFromColumn(column);
		this.j = jFromRow(row);
	}

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
        	return true;
		}
		if(obj == null){
            return false;
        }
        TilePosition other = (TilePosition) obj;
		if(!(other.i == i)){
		    return false;
        }
        if(!(other.j == j)){
		    return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + j;
        return result;
    }

    public TilePosition(String pos) {
		this(pos.charAt(0), Integer.parseInt(pos.substring(1)));
	}

	public char column() {
		return (char) ('a' + i);
	}

	public int row() {
		return j + 1;
	}

	public TilePosition step(int columnStep, int rowStep) {
		return new TilePosition(i + columnStep, j + rowStep);
	}

	public TilePosition step(Offset2D step) {
		return step(step.x, step.y);
	}

	public TilePosition stepByPlayingSide(Offset2D dir, PlayingSide side) {
		if(side == PlayingSide.BLUE) {
			return step(dir);
		}

		return step(dir.yFlipped());
	}

	public boolean isNextTo(TilePosition pos) {
		if(this.i == pos.i && Math.abs(this.j - pos.j) == 1)
			return true;

		if(this.j == pos.j && Math.abs(this.i - pos.i) == 1)
			return true;

		return false;
	}

	public boolean equalsTo(int i, int j) {
		return this.i == i && this.j == j;
	}

	public boolean equalsTo(char column, int row) {
		return this.i == iFromColumn(column) && this.j == jFromRow(row);
	}

	private int iFromColumn(char column) {
		return column - 'a';
	}

	private int jFromRow(int row) {
		return row - 1;
	}

	@Override
	public String toString() {
		return String.format("%c%d", column(), row());
	}
}