package usantatecla.chess.views;

import usantatecla.chess.models.Chess;
import usantatecla.utils.Observer;

abstract class Command extends usantatecla.utils.Command {

	protected Chess chess;

	protected Command(String title, Chess chess, Observer observer) {
		this.title = title;
		this.chess = chess;
		this.addObserver(observer);
	}

}
