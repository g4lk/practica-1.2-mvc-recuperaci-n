package usantatecla.chess.controllers;

import usantatecla.chess.views.ChessView;
import usantatecla.utils.Event;
import usantatecla.utils.Observed;
import usantatecla.utils.Observer;
import usantatecla.chess.events.MoveEvent;
import usantatecla.chess.events.NewGameEvent;
import usantatecla.chess.models.Chess;

public class ChessController implements Observer {
    
    private BoardController boardController;

    private TurnController turnController;

    private ChessView chessView;

    private Chess chess;
    
    ChessController() {
        this.clear();
    }

    void clear(){
        this.boardController = new BoardController();
        this.turnController = new TurnController(this.boardController.getBoard());
        this.chess = new Chess(this.boardController.getBoard(), this.turnController.getTurn());
        this.chessView = new ChessView(this.chess, this);
        this.chessView.addObserver(this);
        this.chess.addObserver(this.chessView);
    }

    void play() {
		this.chessView.write();
	}

    public void update(Observed observed, Event event) {
		if (event instanceof MoveEvent) {
			this.turnController.play();
		} else if (event instanceof NewGameEvent) {
			this.clear();
			this.play();
		}
	}

    public static void main(String[] args) {
        new ChessController().play();
    }

    
}
