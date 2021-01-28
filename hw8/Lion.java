import java.awt.*;
import java.util.Random;

public class Lion extends Critter {
    private int everyThree;
    private int prev;

    public Lion() {
        this.everyThree = 1;
        this.prev = 1;
    }

    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

    public Color getColor() {
        int n = prev;
        if (everyThree++ % 3 == 1) {
            Random r = new Random();
            prev = r.nextInt(3) + 1;
        }
        if (n == 1) {
            return Color.RED;
        } else if (n == 2) {
            return Color.GREEN;
        } else {
            return Color.BLUE;
        }
    }

    public String toString() {
        return "L";
    }
}
