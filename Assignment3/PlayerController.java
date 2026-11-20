import java.util.*;

public class PlayerController {
    private HashMap<Character, Command> commands;
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public PlayerController() {
        commands = new HashMap<>();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void setCommand(char key, Command command) {
        commands.put(key, command);
    }

    public void keyWasPressed(char key) {
        if (key == 'u') {
            if (!undoStack.isEmpty()) {
                Command c = undoStack.pop();
                c.undo();                        
                redoStack.push(c);
            }
        } else if (key == 'r') {
            if (!redoStack.isEmpty()) {
                Command c = redoStack.pop();
                c.execute();                    
                undoStack.push(c);
            }
        } else {
            Command stored = commands.get(key);
            if (stored != null) {
                Command c = stored.clone();
                c.setDistance(Character.isUpperCase(key) ? 20 : 10);
                c.execute();                    
                undoStack.push(c);
                redoStack.clear();
            }
        }
    }
}