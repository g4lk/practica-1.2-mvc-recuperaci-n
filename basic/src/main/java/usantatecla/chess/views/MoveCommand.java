package usantatecla.chess.views;

import usantatecla.chess.events.MoveEvent;
import usantatecla.chess.models.Chess;
import usantatecla.utils.Observer;

public class MoveCommand extends Command {

	MoveCommand(Chess chess, Observer observer) {
		super(MessageView.MOVE_COMMAND.toString(), chess, observer);
	}

	@Override
	public void updateIsActive() {
		this.isActive = true;
	}

	@Override
	public void execute() {
		this.notify(new MoveEvent());
	}


}
