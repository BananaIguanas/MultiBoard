public class ChessBoard extends Board {
	
	private final Piece bluePawn = new PawnPiece("Blue");
	private final Piece blueKing = new KingPiece("Blue");
	private final Piece redPawn = new PawnPiece("Red");
	private final Piece redKing = new KingPiece("Red");


	public ChessBoard() {
		super(8, 8, '+');
		setBoard();
	}

	private void setBoard() {
		// Set the pawns.
		for (int j = 0; j < dimX; j++) {
			addPiece(1, j, redPawn);
		   	addPiece(6, j, bluePawn);	
		}

		// Set the kings.
		addPiece(0, 4, redKing);
		addPiece(7, 4, blueKing);
	}

	// Prints the state of the board. Find a better way to do this. Maybe lambda expressions to pass functionality?
	@Override
	protected void printBoard() {
		System.out.println(xBorder);
		// For every row.
		for (int i = 0; i < dimY; i++) {
			System.out.print(yBorder + " ");
			// For every column.
			for (int j = 0; j < dimX; j++) {
				Piece piece = getPiece(i, j);
				char pieceSymbol = getPieceSymbol(i, j);
				// If the symbol isn't representing an empty spot, colour it by its team.
				if (pieceSymbol == nullChar) {
					System.out.print(nullChar + " ");
				} else if (piece.getTeam() == "Blue"){
					System.out.print(ANSI_BLUE + pieceSymbol + ANSI_RESET + " ");
				} else if (piece.getTeam() == "Red"){
					System.out.print(ANSI_RED + pieceSymbol + ANSI_RESET + " ");
				}
			}
			System.out.println(yBorder);
		}
		System.out.println(xBorder);
	}

	/*
	 * Main method is for debugging. Remove later.
	 */
	
	public static void main(String[] args) {
		ChessBoard emptyBoard = new ChessBoard();

		emptyBoard.printBoard();
	}
}
