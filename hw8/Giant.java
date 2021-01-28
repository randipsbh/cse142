import java.awt.*;

public class Giant extends Critter {
    private int count;

    public Giant() {
        this.count = -1;
    }

    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    public Color getColor() {
        return Color.GRAY;
    }

    public String toString() {
        count++;
        if (count % 24 < 6) {
            return "fee";
        } else if (count % 24 < 12) {
            return "fie";
        } else if (count % 24 < 18) {
            return "foe";
        } else {
            return "fum";
        }
    }
}
