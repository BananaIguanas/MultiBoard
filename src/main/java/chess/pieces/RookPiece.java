package chess.pieces;

import base.Piece;

public class RookPiece extends Piece {
	
	public RookPiece(String team) {
		setName("Rook");
		setSymbol('R');
		setTeam(team);
	}

	public void getPathList() {
		return;
	}
}
