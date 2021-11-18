package usantatecla.chess.views;

import usantatecla.chess.models.Chess;
import usantatecla.utils.Event;
import usantatecla.utils.Observed;
import usantatecla.utils.Observer;

public class ChessView extends Observed implements Observer { 

    private Chess chess;
    

    public ChessView(Chess chess, Observer observer) {
        this.chess = chess;

    }

    @Override
    public void update(Observed observed, Event event) {
        // TODO Auto-generated method stub
        
    }

    public void write() {
        MessageView.TITLE.writeln();
        new BoardView(this.chess.getBoard()).writeln();
    }
    
}
