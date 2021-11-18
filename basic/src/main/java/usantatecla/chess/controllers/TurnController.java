package usantatecla.chess.controllers;

import usantatecla.chess.models.Board;
import usantatecla.chess.models.Turn;

public class TurnController {

    private Turn turn;
    
    public TurnController(Board board) {
        this.turn = new Turn(board);
    }

    public Turn getTurn() {
        return this.turn;
    }

}
