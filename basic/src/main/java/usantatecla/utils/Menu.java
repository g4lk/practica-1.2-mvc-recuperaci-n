package usantatecla.utils;

import java.util.ArrayList;

import usantatecla.chess.views.ConsoleView;

public abstract class Menu extends ConsoleView {

	private final int MOVE_COMMAND = 0;
	protected ArrayList<Command> commands;

	public void execute() {
		for (Command command: this.commands) {
			command.updateIsActive();
		}
		ArrayList<Command> commands = new ArrayList<Command>();
		for (Command command: this.commands) {
			if (command.isActive()) {
				commands.add(command);
			}
		}
		commands.get(MOVE_COMMAND).execute();
	}

}