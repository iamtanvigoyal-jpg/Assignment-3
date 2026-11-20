import shapes.Person;

public class MoveDownCommand extends Command {
    public MoveDownCommand(Person p) {
        super(p, 10);
    }

    public void execute() {
        player.moveVertical(distance);
    }

    public void undo() {
        player.moveVertical(-distance);
    }
}