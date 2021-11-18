package usantatecla.chess.controllers;

import usantatecla.chess.models.Board;
import usantatecla.chess.models.Color;
import usantatecla.chess.models.Player;
import usantatecla.chess.views.PlayerView;

public class PlayerController {
 
    private Player player;

    private PlayerView playerView;
    
    public PlayerController(Board board, Color color) {
        this.player = new Player(color,board);
        this.playerView = new PlayerView(this.player);
    }

    public Player getPlayer() {
        return this.player;
    }

    public PlayerView getPlayerView(){
        return this.playerView;
    }

    public void play() {
        this.playerView.read();
    }


}
