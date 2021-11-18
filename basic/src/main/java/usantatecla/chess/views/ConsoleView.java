package usantatecla.chess.views;

import usantatecla.utils.Console;

public abstract class ConsoleView {


    protected Console console;


    protected ConsoleView(){
        this.console = new Console();
    }
}
