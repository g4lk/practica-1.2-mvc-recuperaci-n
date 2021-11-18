package usantatecla.chess.models;

public class Turn {
    private final Board board;
    private final Player[] players;
    private int activePlayer;

    public Turn(Board board) {
        this.board = board;
        this.players = new Player[2];
        this.reset();
    }

    public void changeActivePlayer(){
        if (!this.board.isCheckMate(this.getActiveColor())){
            this.activePlayer = (this.activePlayer+1) % 2;
        }
    }

    public void reset() {
        for (int i = 0; i < 2; i++) {
            this.players[i] = new Player(Color.get(i), this.board);
        }
        this.activePlayer = 1;
    }

    public Color getActiveColor() {
        return this.players[this.activePlayer].getColor();
    }

    public Board getBoard() {
        return this.board;
    }

    public Player getActivePlayer() {
        return this.players[this.activePlayer];
    }
}
