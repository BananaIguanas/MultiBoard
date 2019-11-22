abstract public class Piece {

	protected String pieceName;
	protected char pieceSymbol;

	protected String getName() {
		return pieceName;
	}

	protected char getSymbol() {
		return pieceSymbol;
	}

	protected void setName(String name) {
		this.pieceName = name;
	}

	protected void setSymbol(char sym) {
		this.pieceSymbol = sym;
	}
}
