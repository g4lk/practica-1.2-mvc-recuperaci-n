package usantatecla.chess.controllers;

import usantatecla.chess.models.Board;
import usantatecla.chess.models.Turn;
import usantatecla.chess.views.TurnView;

public class TurnController {

    private Turn turn;

    private TurnView turnView;
    
    public TurnController(Board board) {
        this.turn = new Turn(board);
        this.turnView = new TurnView(this.turn);
    }

    public Turn getTurn() {
        return this.turn;
    }

}
