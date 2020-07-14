package chess.pieces;

import base.Piece;

public class PawnPiece extends Piece {
	
	public PawnPiece(String team) {
		setName("Pawn");
		setSymbol('P');
		setTeam(team);
	}

	public void getPathList() {
		
	}
}
