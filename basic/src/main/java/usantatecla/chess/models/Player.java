package usantatecla.chess.models;

import usantatecla.utils.Coordinate;

public class Player {
    private final Color color;
    private final Board board;

    public Player(Color color, Board board) {
        this.color = color;
        this.board = board;
    }

    public Coordinate getCoordinate(String message) {
        assert message != null;

        Coordinate coordinate = new Coordinate();
        coordinate.read(message);
        return coordinate;
    }

    public Error getMoveError(Coordinate origin) {
        assert origin != null;

        Error error = Error.NULL;
        if (this.board.isEmpty(origin)) {
            error = Error.NOT_EMPTY;
        } else if (this.board.isOpposite(origin, this.color)) {
            error = Error.PIECE_NOT_OWN;
        }
        error.writeln();
        return error;
    }

    public Error getMoveError(Coordinate origin, Coordinate target) {
        assert origin != null;
        assert target != null;

        Error error = Error.NULL;
        if (!this.board.isMoveLegal(origin, target)) {
            error = Error.IS_ILLEGAL;
        }
        error.writeln();
        return error;
    }

    public Color getColor() {
        return this.color;
    }

    public void movePiece(Coordinate origin, Coordinate target) {
        assert this.getMoveError(origin, target) == null;
        this.board.movePiece(origin, target);
    }
}
