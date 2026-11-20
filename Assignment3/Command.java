import shapes.Person;

public abstract class Command implements Cloneable {
    protected Person player;
    protected int distance;

    public Command(Person p, int d) {
        player = p;
        distance = d;
    }

    public abstract void execute();

    public abstract void undo();

    public void setDistance(int d) {
        distance = d;
    }

    @Override
    public Command clone() {
        try {
            return (Command) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}