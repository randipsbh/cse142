import java.awt.*;

public class Bear extends Critter {
    private boolean polar;
    private int alt;

    public Bear(boolean polar) {
        this.polar = polar;
        this.alt = 0;
    }

    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }

    public Color getColor() {
        return (polar) ? Color.WHITE : Color.BLACK;
    }

    public String toString() {
        return (alt++ % 2 == 0) ? "/" : "\\";
    }
}
