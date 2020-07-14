package base;

abstract public class Piece {

	protected String pieceName;
	protected char pieceSymbol;
	protected String team;

	public String getName() {
		return pieceName;
	}

	public char getSymbol() {
		return pieceSymbol;
	}

	public String getTeam() {
		return team;
	}

	public void setName(String name) {
		this.pieceName = name;
	}

	public void setSymbol(char sym) {
		this.pieceSymbol = sym;
	}

	public void setTeam(String team) {
		this.team = team;
	}
}
