package chess;

import java.io.Serializable;
import base.*;
import java.util.ArrayDeque;

public class ChessSaveObj implements Serializable {
	
	private Board chessBoard;
	private ArrayDeque<ChessMove> moveHistory;
	private Player player1;
	private Player player2;
	private int turnCounter;

	public ChessSaveObj(Board chessBoard, ArrayDeque<ChessMove> moveHistory, Player player1, Player player2, int turnCounter) {
		this.chessBoard = chessBoard;
		this.moveHistory = moveHistory;
		this.player1 = player1;
		this.player2 = player2;
		this.turnCounter = turnCounter;
	}

	public Board getChessBoard() {
		return chessBoard;
	}

	public ArrayDeque<ChessMove> getMoveHistory() {
		return moveHistory;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public int getTurnCounter() {
		return turnCounter;
	}
}
