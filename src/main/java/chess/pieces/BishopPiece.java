package chess.pieces;

import base.Piece;

public class BishopPiece extends Piece {
	
	public BishopPiece(String team) {
		setName("Bishop");
		setSymbol('B');
		setTeam(team);
	}

	public void getPathList() {
		return;
	}
}
