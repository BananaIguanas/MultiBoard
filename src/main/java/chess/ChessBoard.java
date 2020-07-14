package chess;

import base.Piece;
import base.Board;
import chess.pieces.*;

public class ChessBoard extends Board {
	
	// List of piece instances which we can use to reference.
	
	// Blue Pieces
	private final Piece bluePawn = new PawnPiece("Blue");
	private final Piece blueKing = new KingPiece("Blue");
	private final Piece blueQueen = new QueenPiece("Blue");
	private final Piece blueBishop = new BishopPiece("Blue");
	private final Piece blueRook = new RookPiece("Blue");
	private final Piece blueKnight = new KnightPiece("Blue");

	// Red Pieces
	private final Piece redPawn = new PawnPiece("Red");
	private final Piece redKing = new KingPiece("Red");
	private final Piece redQueen = new QueenPiece("Red");
	private final Piece redBishop = new BishopPiece("Red");
	private final Piece redRook = new RookPiece("Red");
	private final Piece redKnight = new KnightPiece("Red");

	public ChessBoard() {
		super(8, 8, "12345678", "ABCDEFGH", '+');
		setBoard();
	}
	
	// Set the initial board state and pieces.
	private void setBoard() {
		// Set the pawns.
		for (int j = 0; j < dimX; j++) {
			addPiece(1, j, redPawn);
		   	addPiece(6, j, bluePawn);	
		}

		// Set the rooks
		addPiece(0, 0, redRook);
		addPiece(0, 7, redRook);
		addPiece(7, 0, blueRook);
		addPiece(7, 7, blueRook);

		// Set the knights.
		addPiece(0, 1, redKnight);
		addPiece(0, 6, redKnight);
		addPiece(7, 1, blueKnight);
		addPiece(7, 6, blueKnight);

		// Set bishops.
		addPiece(0, 2, redBishop);
		addPiece(0, 5, redBishop);
		addPiece(7, 2, blueBishop);
		addPiece(7, 5, blueBishop);

		// Set the queens.
		addPiece(0, 3, redQueen);
		addPiece(7, 3, blueQueen);

		// Set the kings.
		addPiece(0, 4, redKing);
		addPiece(7, 4, blueKing);
	}
	
	// Returns true if successful. Checks if the move is valid as well.
	protected boolean movePiece(int startX, int startY, int finY, int finX) {
		return false;
	}

	@Override
	protected void printSpec(int i, int j) {
		Piece piece = getPiece(i, j);
		char pieceSymbol = getPieceSymbol(i, j);
		// If the symbol isn't representing an empty spot, colour it by its team.
		if (pieceSymbol == nullChar) {
			System.out.print(pieceSymbol + " ");
		} else if (piece.getTeam() == "Blue"){
			System.out.print(ANSI_BLUE + pieceSymbol + ANSI_RESET + " ");
		} else if (piece.getTeam() == "Red"){
			System.out.print(ANSI_RED + pieceSymbol + ANSI_RESET + " ");
		}
	}

}
