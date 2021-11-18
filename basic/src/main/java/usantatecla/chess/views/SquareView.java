package usantatecla.chess.views;

import usantatecla.chess.models.Square;

public class SquareView {

    private Square square;

    public SquareView(Square square) {
        this.square = square;
    }

    public void write() {
        if (this.square.getPiece() != null) {
            new PieceView(this.square.getPiece()).write();
        }
        else {
            MessageView.SPACE.write();
        }
    }

}
