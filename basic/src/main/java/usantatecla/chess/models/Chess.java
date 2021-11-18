package usantatecla.chess.models;

import usantatecla.chess.events.EndGameEvent;
import usantatecla.utils.Observed;
import usantatecla.utils.YesNoDialog;

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

    private void play() {
        do {
            this.playGame();
        } while (this.isResumedGame());
    }

    private void playGame() {
        Message.TITLE.writeln();
        this.board.print();
        do {
            this.turn.play();
            this.board.print();
        } while (!this.isCheckMate());
        this.turn.writeWinner();
    }

    private boolean isCheckMate() {
        boolean isCheckMate = this.board.isCheckMate(this.turn.getActiveColor());
        if (isCheckMate) {
            this.notify(new EndGameEvent());
        }
        return isCheckMate;
    }

    private boolean isResumedGame() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.board.reset();
            this.turn.reset();
        }
        return yesNoDialog.isAffirmative();
    }

    public static void main(String[] args) {
        new Chess().play();
    }

    public Board getBoard() {
        return this.board;
    }

    public Turn getTurn() {
        return this.turn;
    }
  
}
