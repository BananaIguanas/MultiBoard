package chess.pieces;

import base.Piece;

public class QueenPiece extends Piece {
	
	public QueenPiece(String team) {
		setName("Queen");
		setSymbol('Q');
		setTeam(team);
	}

	public void getPathList() {
		return;
	}
}
