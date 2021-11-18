package usantatecla.chess.views;

import usantatecla.chess.events.EndGameEvent;
import usantatecla.chess.events.NewGameEvent;
import usantatecla.chess.models.Chess;
import usantatecla.chess.models.Color;
import usantatecla.utils.Event;
import usantatecla.utils.Observed;
import usantatecla.utils.Observer;
import usantatecla.utils.YesNoDialog;

public class ChessView extends Observed implements Observer { 

    private Chess chess;
    private Menu menu;

    public ChessView(Chess chess, Observer observer) {
        this.chess = chess;
        this.menu = new Menu(chess, observer);
    }

    @Override
    public void update(Observed observed, Event event) {
        if (event instanceof EndGameEvent) {
            if (this.chess.getBoard().isCheckMate(Color.Black))
			    MessageView.BLACK_CHECKMATE.writeln();
            else
                MessageView.WHITE_CHECKMATE.writeln();
            this.resume();
        }       
    }

    public void write() {
        MessageView.TITLE.writeln();
        new BoardView(this.chess.getBoard()).writeln();
        do {
			this.menu.execute();
		} while (!this.chess.isCheckMate());
    }

    private void resume() {
		if (new YesNoDialog().read(MessageView.RESUME.toString())) {
			this.notify(new NewGameEvent());
		}
	}
    
}
