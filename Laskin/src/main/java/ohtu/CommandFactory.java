package ohtu;

import java.util.*;


public class CommandFactory {
    private Map<String, Command> commands;
    private Undo undo;
    private Command clear;

    public CommandFactory() {
        undo = new Undo();
        commands = new HashMap<>();
        commands.put("+", new Addition(undo));
        commands.put("-", new Subtraction(undo));
        commands.put("undo", undo);
        clear = new Clear(undo);
    }

    Command get(String text) {
        return commands.get(text) == null ? clear : commands.get(text);
    }
    
}
