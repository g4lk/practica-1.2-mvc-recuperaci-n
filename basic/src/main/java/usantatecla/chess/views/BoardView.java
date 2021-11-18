package usantatecla.chess.views;

import usantatecla.chess.models.Board;
import usantatecla.chess.models.Color;
import usantatecla.utils.Coordinate;

public class BoardView extends ConsoleView {

    private Board board;


    public BoardView(Board board) {
        this.board = board;
    }

    public void writeln() {
        MessageView.HORIZONTAL_LINE.writeln();
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            MessageView.VERTICAL_LINE.write();
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                new SquareView(this.board.getSquare(new Coordinate(i, j))).write();
                MessageView.VERTICAL_LINE.write();
            }
            console.writeln();
        }
        MessageView.HORIZONTAL_LINE.writeln();
        if (this.board.isCheck(Color.Black)) {
            MessageView.BLACK_CHECK.writeln();
        } else if (this.board.isCheck(Color.White)) {
            MessageView.WHITE_CHECK.writeln();
        }
    }

}
