import shapes.Person;

public class MoveLeftCommand extends Command {
    public MoveLeftCommand(Person p) {
        super(p, 10);
    }

    public void execute() {
        player.moveHorizontal(-distance);
    }

    public void undo() {
        player.moveHorizontal(distance);
    }
}