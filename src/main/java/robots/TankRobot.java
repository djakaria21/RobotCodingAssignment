package robots;

import robotParts.Direction;
import robotParts.Grid;

public class TankRobot extends Robot{

    Grid grid;
    public TankRobot(Grid grid) {
        this.grid = grid;
    }

    public void move(char leftStick, char rightStick) {
        switch (leftStick) {
            case 'F':
                if(rightStick == 'F'){
                    moveForward();
                }else if(rightStick == 'B'){
                    turnRight();
                }
                checkWalls();
                break;
            case 'B':
                if(rightStick == 'F'){
                    turnLeft();
                }else if(rightStick == 'B'){
                    moveBackward();
                }
                checkWalls();
                break;
            default:
                checkWalls();
                break;
        }
    }

    private void checkWalls() {
        if(getPosition().getHeight() <0)
        {
            setPosition(getPosition().getWidth(), 0);
        }
        if(getPosition().getHeight() > grid.getHeight()-1)
        {
            setPosition( getPosition().getWidth(), grid.getHeight()-1);
        }
        if(getPosition().getWidth() <0)
        {
            setPosition(0, getPosition().getHeight());
        }
        if(getPosition().getWidth() > grid.getWidth()-1)
        {
            setPosition(grid.getWidth()-1, getPosition().getHeight());
        }
    }

    private void moveForward() {
        switch(getDirection()) {
            case EAST:
                getPosition().setWidth(getPosition().getWidth() + 1);
                break;
            case WEST:
                getPosition().setWidth(getPosition().getWidth() - 1);
                break;
            case NORTH:
                getPosition().setHeight(getPosition().getHeight() - 1);
                break;
            case SOUTH:
                getPosition().setHeight(getPosition().getHeight() + 1);
                break;
        }
    }

    private void moveBackward() {
        switch(getDirection()) {
            case EAST:
                getPosition().setWidth(getPosition().getWidth() - 1);
                break;
            case WEST:
                getPosition().setWidth(getPosition().getWidth() + 1);
                break;
            case NORTH:
                getPosition().setHeight(getPosition().getHeight() + 1);
                break;
            case SOUTH:
                getPosition().setHeight(getPosition().getHeight() - 1);
                break;
        }
    }

    private void turnLeft() {
        switch(getDirection()) {
            case EAST:
                setDirection(Direction.NORTH);
                break;
            case WEST:
                setDirection(Direction.SOUTH);
                break;
            case NORTH:
                setDirection(Direction.WEST);
                break;
            case SOUTH:
                setDirection(Direction.EAST);
                break;
        }
    }

    private void turnRight() {

        switch (getDirection()) {
            case EAST:
                setDirection(Direction.SOUTH);
                break;
            case WEST:
                setDirection(Direction.NORTH);
                break;
            case NORTH:
                setDirection(Direction.EAST);
                break;
            case SOUTH:
                setDirection(Direction.WEST);
                break;
        }
    }
}
