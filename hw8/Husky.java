import java.awt.*;

public class Husky extends Critter {

    public Husky() {

    }

    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.leftThreat()) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

    public Color getColor() {
        return Color.GRAY;
    }

    public String toString() {
        return "H";
    }
}
