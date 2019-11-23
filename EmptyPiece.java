public class EmptyPiece extends Piece {
	
	public EmptyPiece() {
		setName("Empty Piece");
		setSymbol('E');
		setTeam("None");
	}

	public void getPathList() {
		return;
	}
}
