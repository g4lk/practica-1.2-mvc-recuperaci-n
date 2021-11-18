package usantatecla.chess.controllers;

import usantatecla.chess.models.Board;
import usantatecla.chess.models.Turn;
import usantatecla.chess.views.BoardView;
import usantatecla.chess.views.PlayerView;
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

    public TurnView getTurnView(){
        return this.turnView;
    }

    public void play() {
        new PlayerView(this.turn.getActivePlayer()).read();
        this.turn.changeActivePlayer();
        new BoardView(this.turn.getBoard()).writeln();
    }

}
