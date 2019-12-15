import java.util.Scanner;
import java.util.ArrayList;
import java.util.Deque;

public class ChessGame {
	
	private static Board chessBoard = new ChessBoard();
	private static Player player1;
	private static Player player2;
	private static int turnCounter = 0;
	private static Deque<ChessMove> moveHistory = new Deque()<>;

	public static void main(String[] args) {
		System.out.println("Chess Game started. Type \"Help\" for a list of options.")
		while (true) {
			Scanner input = new Scanner(">>> ");
			processUserInput(input)
		}
	}

	// Grabs user input from STDIN and processes it. Will tokenize.
	private void processUserInput(String input) {
		String inputArray[] = input.split(" ");

		switch (input[0]) {
			case "move":
				// To do: Breka up the String input.
				chessBoard.movePiece(/*...*/)
			case "exit":
			case "quit":
			case "save":
			case "load":
		}
	}

	// Maybe just setGame()?
	private void setPlayers() {
		
	}

	// Saves the game using serialization.
	private void saveGame() {
		try {
			// Pack state into save object
			ChessSaveObj save = new ChessSaveObj(chessBoard, moveHistory, player1, player2, turnCounter);
			String filename = String.format("Game_%s_%s_%d", player1.getName(), player2.getName(), turnCounter);
			
			// Open streams
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream outStream = new ObjectOutputStream(file);

			// Save object
			outStream.writeObject(save);

			// Close streams
			outStream.close();
			file.close();

			System.out.println("Game has successfully been saved");
		} catch (Exception e) {
			System.out.println("There was an issue saving the game");
		}
	}

	// Loads the game using serialization.
	private void loadGame(String filename) {
		try {
			// Open streams
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream inStream = new ObjectInputStream(file);

			// load object
			ChessSaveObj load = inStream.readObject();

			// Close streams
			inStream.close();
			file.close();

			// Set the load state
			this.chessBoard = load.getChessBoard();
			this.moveHistory = load.getMoveHistory();
			this.player1 = load.getPlayer1();
			this.player2 = load.getPlayer2();
			this.turnCounter = load.getTurnCounter();

			System.out.println("Game has successfully been loaded");
		} catch (Exception e) {
			System.out.println("There was an issue loading the game");
		}
	}
}
