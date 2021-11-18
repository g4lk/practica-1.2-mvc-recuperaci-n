package usantatecla.chess.models;

public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color, 'B');
    }

    @Override
    public boolean _isMoveLegal(Path path) {
        return path.isDiagonal() && path.isMiddleEmpty();
    }
}
