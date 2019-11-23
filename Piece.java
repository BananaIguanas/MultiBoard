abstract public class Piece {

	protected String pieceName;
	protected char pieceSymbol;
	protected String team;

	protected String getName() {
		return pieceName;
	}

	protected char getSymbol() {
		return pieceSymbol;
	}

	protected String getTeam() {
		return team;
	}

	protected void setName(String name) {
		this.pieceName = name;
	}

	protected void setSymbol(char sym) {
		this.pieceSymbol = sym;
	}

	protected void setTeam(String team) {
		this.team = team;
	}
}
