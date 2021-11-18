package usantatecla.chess.views;

import usantatecla.chess.models.Chess;
import usantatecla.utils.Event;
import usantatecla.utils.Observed;
import usantatecla.utils.Observer;

public class ChessView extends Observed implements Observer { 

    public ChessView(Chess chess, Observer observer) {
    }

    @Override
    public void update(Observed observed, Event event) {
        // TODO Auto-generated method stub
        
    }

    public void write() {
    }
    
}
