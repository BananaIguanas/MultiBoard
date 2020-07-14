package chess.pieces;

import base.Piece;

public class KingPiece extends Piece {
	
	public KingPiece(String team) {
		setName("King");
		setSymbol('K');
		setTeam(team);
	}

	public void getPathList() {
		return;
	}
}
