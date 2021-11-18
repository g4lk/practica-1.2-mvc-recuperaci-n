package usantatecla.chess.views;

import java.util.ArrayList;

import usantatecla.chess.models.Chess;
import usantatecla.utils.Command;
import usantatecla.utils.Observer;

class Menu extends usantatecla.utils.Menu {

	Menu(Chess chess, Observer observer) {
		this.commands = new ArrayList<Command>();
	}

}