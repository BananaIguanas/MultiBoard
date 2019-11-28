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
		
		Scanner input = new Scanner("What would you like to do? ");
		
		while (true) {
			
		}
	}

	private void processUserInput(String input) {
		
	}

	// Maybe just setGame()?
	private void setPlayers() {
		
	}

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
			System.out.println("Game did not save successfully");
		}
	}

	private void loadGame(String filename) {
		try {
			ChessSaveObj load;
			
			// Open streams
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream inStream = new ObjectInputStream(file);

			// load object
			load = inStream.readObject();

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
			System.out.println("Game did not load successfully");
		}
	}
}
