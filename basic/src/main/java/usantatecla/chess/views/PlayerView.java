package usantatecla.chess.views;

import usantatecla.chess.models.Player;
import usantatecla.utils.Coordinate;


public class PlayerView {

    private Player player;

    public PlayerView(Player player) {
        this.player = player;
    }

    public void read() {
        Coordinate origin, target;
        usantatecla.chess.models.Error error;
        do {
            origin = this.player.getCoordinate(MessageView.ENTER_COORDINATE_PIECE.toString());
            error = this.player.getMoveError(origin);
        } while (!error.isNull());
        do {
            target = this.player.getCoordinate(MessageView.ENTER_COORDINATE_SQUARE.toString());
            error = this.player.getMoveError(origin, target);
        } while (!error.isNull());

        this.player.movePiece(origin, target);
    }

}
