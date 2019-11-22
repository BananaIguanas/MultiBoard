public class Board {
	
	private Piece[][] boardState;
	private int dimX;
	private int dimY;
	private String xBorder;
	private String yBorder;
	private char nullChar;

	public Board(int dimX, int dimY, char nullChar) {
		this.boardState = new Piece[dimX][dimY];
		this.dimX = dimX;
		this.dimY = dimY;
		this.xBorder = "+ " + new String(new char[dimX]).replace("\0", "- ") + "+";
		this.yBorder = "|";
		this.nullChar = nullChar;
	} 

	public void printBoard() {
		System.out.println(xBorder);
		
		// Go through boardState and print out Piece symbols alongside y borders.
		for (int i = 0; i < dimY; i++) {
			System.out.print(yBorder + " ");

			for (int j = 0; j < dimX; j++) {
				if (boardState[i][j] == null) {
					System.out.print(nullChar + " ");
				} else {
					//print(boardState[i][j].getSymbol());
				}
			}

			System.out.println(yBorder);
		}

		System.out.println(xBorder);
	}

	public static void main(String[] args) {
		Board emptyBoard = new Board(8, 8, '0');

		emptyBoard.printBoard();
	}
}
