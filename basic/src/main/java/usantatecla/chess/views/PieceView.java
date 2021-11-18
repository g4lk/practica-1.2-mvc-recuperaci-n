package usantatecla.chess.views;

import usantatecla.chess.models.Color;
import usantatecla.chess.models.Piece;

public class PieceView extends ConsoleView {

    private Piece piece;

    public PieceView(Piece piece) {
        this.piece = piece;
    }

    public void write() {
        if (this.piece.getColor() == Color.Black) {
            MessageView.COLOR_BLACK.write();
        }
        console.write(this.piece.getLetter());
        MessageView.COLOR_RESET.write();
    }

}
