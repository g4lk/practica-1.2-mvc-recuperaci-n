package usantatecla.chess.controllers;

import usantatecla.chess.models.Board;
import usantatecla.chess.views.BoardView;

public class BoardController {

	private BoardView boardView;
	private Board board;

	BoardController(){
		this(new Board());
	}

	BoardController(Board board) {
		this.board = board;
		this.boardView = new BoardView(this.board);
		
	}

	public Board getBoard() {
		return this.board;

	}

	public BoardView getBoardView() {
		return this.boardView;
	}

}
