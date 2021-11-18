package usantatecla.chess.models;

import usantatecla.chess.events.EndGameEvent;
import usantatecla.utils.Observed;

public class Chess extends Observed {
    private final Board board;
    private final Turn turn;

    public Chess() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public Chess(Board board, Turn turn){
        this.board = board;
        this.turn = turn;
    } 

    public boolean isCheckMate() {
        boolean isCheckMate = this.board.isCheckMate(this.turn.getActiveColor());
        if (isCheckMate) {
            this.notify(new EndGameEvent());
        }
        return isCheckMate;
    }

    public Board getBoard() {
        return this.board;
    }

    public Turn getTurn() {
        return this.turn;
    }
  
}
