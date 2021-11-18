package usantatecla.chess.views;

import usantatecla.chess.models.Color;
import usantatecla.chess.models.Turn;

public class TurnView {

    private Turn turn;

    public TurnView(Turn turn) {
        this.turn = turn;
    }

    void writewinner(){
        if (this.turn.getActiveColor() == Color.Black) {
            MessageView.BLACK_CHECKMATE.writeln();
        }
        else {
            MessageView.WHITE_CHECKMATE.writeln();
        }
    }

}
