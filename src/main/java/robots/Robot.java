package robots;

import robotParts.Direction;
import robotParts.Position;

public class Robot {

    private Direction direction;

    private Position position;

    public void setPosition(int width, int hieght) {
        this.position = new Position(width, hieght);
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getDirectionAndPosition() {
        return getDirection() + " " + getPosition().getWidth() + " " + getPosition().getHeight();

    }
}
