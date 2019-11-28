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
	protected char[] xVals; // Not fully implemented with printBoard yet. Do later.
	protected char[] yVals;
	protected String xBorder;
	protected String yBorder;
	protected char nullChar;


	public Board(int dimY, int dimX, String yVals, String xVals, char nullChar) {
		this.board = new Piece[dimY][dimX];
		this.dimX = dimX;
		this.dimY = dimY;
		this.xVals = xVals.toCharArray();
		this.yVals = yVals.toCharArray();
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

	// The printing specifications/conditions for the board.
	protected void printSpec(int i, int j) {
		char pieceSymbol = getPieceSymbol(i, j);
		// If the symbol isn't representing an empty spot, colour it blue.
		if (pieceSymbol == nullChar) {
			System.out.print(pieceSymbol + " ");
		} else {
			System.out.print(ANSI_BLUE + pieceSymbol + ANSI_RESET + " ");
		}
	}
	
	// Prints the top part of the board.
	protected void printXBorderTop() {
		// Print the values if they exist. Add space before border.
		if (xVals.length != 0) {
			System.out.print("   ");
			for (char c : xVals) {
				System.out.print(c + " ");
			}
			System.out.print(" \n ");
		}
		// Print the border.
		System.out.println(xBorder);
	}
	
	// Prints the bottom part of the board.
	protected void printXBorderBottom() {
		if (xVals.length != 0) {
			// If there are values, print the border first, then the values. Add space before border.
			System.out.println(" " + xBorder);
			System.out.print("   ");
			for (char c : xVals) {
				System.out.print(c + " ");
			}
			System.out.print(" \n");
		} else {
			// If there are not, just print the border.
			System.out.println(xBorder);
		}
	}
	
	// Prints the left part of the board.	
	protected void printYBorderLeft(int cntr) {
		if (yVals.length != 0) {
			System.out.print(yVals[cntr]);
		}
		System.out.print(yBorder + " ");
	}

	// Prints the right part of the board.
	protected void printYBorderRight(int cntr) {
		if (yVals.length != 0) {
			System.out.print(yBorder);
			System.out.println(yVals[cntr]);
		} else {
			System.out.println(yBorder);
		}
	}

	// Prints the entire board. Must provide print specifications.
	protected void printBoard() {
		printXBorderTop();
		// For every row.
		for (int i = 0; i < dimY; i++) {
			printYBorderLeft(i);
			// For every column.
			for (int j = 0; j < dimX; j++) {
				printSpec(i, j);
			}
			printYBorderRight(i);
		}
		printXBorderBottom();
	}

}
