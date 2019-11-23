public class Board {
	
	protected static final String ANSI_RESET = "\u001B[0m";
	protected static final String ANSI_BLUE = "\u001B[34m";
	protected static final String ANSI_RED = "\u001B[31m";

	/*
	 * We do things with rows first and then columns. Y represents rows.
	 * X represents columns.
	 */
	
	protected Piece[][] board;
	protected int dimX;
	protected int dimY;
	protected String xBorder;
	protected String yBorder;
	protected char nullChar;

	public Board(int dimY, int dimX, char nullChar) {
		this.board = new Piece[dimY][dimX];
		this.dimX = dimX;
		this.dimY = dimY;
		this.xBorder = "< " + new String(new char[dimX]).replace("\0", "- ") + ">";
		this.yBorder = "|";
		this.nullChar = nullChar;
	} 
	
	// Get a piece on the board.
	protected Piece getPiece(int y, int x) {
		return board[y][x];
	}

	// Get a piece's symbol on the board.
	protected char getPieceSymbol(int y, int x) {
		if (getPiece(y, x) == null) {
			return nullChar;
		} else {
			return getPiece(y, x).getSymbol();
		}	
	}

	// Get a piece's name on the board.
	protected String getPieceName(int y, int x) {
		if (getPiece(y, x) == null) {
			return "Empty";
		} else {
			return getPiece(y, x).getName();
		}
	}

	// Add a piece onto the board. Does not replace existing pieces.
	protected void addPiece(int y, int x, Piece piece) {
		if (getPiece(y, x) == null) {
			board[y][x] = piece;
		} else {
			System.out.printf("Cannot add piece at (%d, %d). Currently existing piece: %c - %s\n", y, x, getPieceSymbol(x, y), getPieceName(x,y));
		}
	}

	// Remove a piece from the board.
	protected void removePiece(int y, int x) {
		if (getPiece(y, x) == null) {
			System.out.printf("No piece exists at location (%d, %d).\n", y, x);
		} else {
			board[y][x] = null;
		}
	}
	
	// Prints the state of the board.	
	protected void printBoard() {
		System.out.println(xBorder);
		// For every row.
		for (int i = 0; i < dimY; i++) {
			System.out.print(yBorder + " ");
			// For every column.
			for (int j = 0; j < dimX; j++) {
				char pieceSymbol = getPieceSymbol(i, j);
				// If the symbol isn't representing an empty spot, colour it blue.
				if (pieceSymbol == nullChar) {
					System.out.print(pieceSymbol + " ");
				} else {
					System.out.print(ANSI_BLUE + pieceSymbol + ANSI_RESET + " ");
				}
			}
			System.out.println(yBorder);
		}
		System.out.println(xBorder);
	}

	/*
	 * Main method is for debugging. Remove later.
	 */
	
	//public static void main(String[] args) {
	//	Board emptyBoard = new Board(8, 8, '+');
	//	PawnPiece pawn = new PawnPiece();

	//	emptyBoard.printBoard();
	//	emptyBoard.addPiece(2, 3, pawn);
	//	emptyBoard.printBoard();
	//	emptyBoard.addPiece(3, 4, pawn);
	//	emptyBoard.printBoard();
	//	emptyBoard.removePiece(2, 3);
	//	emptyBoard.printBoard();
	//	emptyBoard.removePiece(2, 3);
	//	emptyBoard.printBoard();
	//	emptyBoard.addPiece(7, 7, pawn);
	//	emptyBoard.printBoard();
	//	emptyBoard.addPiece(7, 7, pawn);
	//	emptyBoard.printBoard();
	//}
}
