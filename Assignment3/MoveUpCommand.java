import shapes.Person;

public class MoveUpCommand extends Command {
    public MoveUpCommand(Person p) {
        super(p, 10);
    }

    public void execute() {
        player.moveVertical(-distance);
    }

    public void undo() {
        player.moveVertical(distance);
    }
}