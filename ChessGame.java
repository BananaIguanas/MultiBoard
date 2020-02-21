import java.util.Scanner;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.lang.System;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

/* Note to delete later: In the old days, we normally had to use an iterator to loop through a data structure.
 * However, if we are only doing simple stuff, we can now just use an enchanced for loop.
 * For example: If we simply want to print out all the items in a data structure, there is no need to
 * use a while loop with an iterator. We can simply just use an enchanced for loop.
 * If we wanted to do more complicated stuff like loop through and delete, then we should use the iterator with
 * a while loop. The enchanced for loop does not require an iterator to be provided, it will grab the iterator
 * by itself.
 */

public class ChessGame {
	
	private static Board chessBoard = new ChessBoard();
	private static Player player1;
	private static Player player2;
	private static int turnCounter = 0;
	private static Deque<ChessMove> moveHistory = new Deque<>();
	private static String fileName = "instructions.txt";

	public static void main(String[] args) {
		System.out.println("Chess Game started. Type \"Help\" for a list of options.");
		while (true) {
			Scanner input = new Scanner(">>> ");
			processUserInput(input);
		}
	}

	private void printHelp() { 
		try {
			List<String> helpFile = File.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
			for (String i : helpFile) {
				// Might need to use print() instead of println() to prevent random new lines, especially if
				// New line characters already exist in the string. Fix later.
				Sysytem.out.println(i);
			}
		} catch (Exception e) {
			System.out.println("The instructions.txt file does not exist.");
		}
	}

	// Grabs user input from STDIN and processes it. Will tokenize using space as a delimiter.
	private void processUserInput(String input) {
		String inputArray[] = input.toLowerCase().split(" ");

		switch (input[0]) {
			case "move":
				int[] startPos = processChessLocation(inputArray[1]);
				int[] endPos = processChessLocation(inputArray[2]);
				// Still need to write movePiece() in ChessBoard.java.
				chessBoard.movePiece(startPos[0], startPos[1], endPos[0], endPos[1]);
				break;
			case "exit": 
				System.exit(0);
				break;
			case "quit":
				System.exit(0);
				break;
			case "save":
				saveGame();
				break;
			case "load":
				loadGame();
				break;
			case "help":
				printHelp();
				break;
		}
	}

	// Converts a chess board location to a set of integers.
	private int[] processChessLocation(String input) {
		if (input.length() == 2) {
			char[] tokens = name.toCharArray();
			int rank = tokens[0] - 'A';
			int file = tokens[1] - '1';
			if (rank < 8 && file < 8) {
				int[] location = new int[] {file, rank};
				return location;
			}
		}
		return null;
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

			// Set the load state. You should not use "this" to access static variables of the ChessGame class.
			// Changes these to either ChessGame.chessBoard or just chessBoard and etc.
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
