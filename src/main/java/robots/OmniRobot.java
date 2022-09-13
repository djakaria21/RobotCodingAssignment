package robots;

import robotParts.Direction;
import robotParts.Grid;

public class OmniRobot extends Robot{
    Grid grid;
    public OmniRobot(Grid grid) {
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
                else if(rightStick == 'N'){
                    moveRightAndTurn();
                }
                break;
            case 'B':
                if(rightStick == 'F'){
                    turnLeft();
                }else if(rightStick == 'B'){
                    moveBackward();
                }
                break;
            case 'N':
                if(rightStick == 'F'){
                    moveLeftAndTurn();
                }
                break;
            case 'R':
                if(rightStick == 'R') {
                    moveRight();
                }
                    break;
            case 'L':
                if(rightStick == 'L') {
                    moveLeft();
                }
                    break;

            default:
                break;
        }
    }

    private void moveLeft() {
        switch(getDirection()) {
            case EAST:
                getPosition().setHeight(getPosition().getHeight() - 1);
                break;
            case WEST:
                getPosition().setHeight(getPosition().getHeight() + 1);
                break;
            case NORTH:
                getPosition().setWidth(getPosition().getWidth() - 1);
                break;
            case SOUTH:
                getPosition().setWidth(getPosition().getWidth() + 1);
                break;
        }
    }

    private void moveRight() {
        switch (getDirection()) {
            case EAST:
                getPosition().setHeight(getPosition().getHeight() + 1);
                break;
            case WEST:
                getPosition().setHeight(getPosition().getHeight() - 1);
                break;
            case NORTH:
                getPosition().setWidth(getPosition().getWidth() + 1);
                break;
            case SOUTH:
                getPosition().setWidth(getPosition().getWidth() - 1);;
                break;
        }
    }

    private void moveLeftAndTurn() {
        switch(getDirection()){
            case EAST:
                getPosition().setHeight(getPosition().getHeight() - 1);
                getPosition().setWidth(getPosition().getWidth() + 1);
                setDirection(Direction.NORTH);
                break;
            case WEST:
                getPosition().setHeight(getPosition().getHeight() + 1);
                getPosition().setWidth(getPosition().getWidth() - 1);
                setDirection(Direction.SOUTH);
                break;
            case NORTH:
                getPosition().setHeight(getPosition().getHeight() - 1);
                getPosition().setWidth(getPosition().getWidth() - 1);
                setDirection(Direction.WEST);
                break;
            case SOUTH:
                getPosition().setHeight(getPosition().getHeight() + 1);
                getPosition().setWidth(getPosition().getWidth() + 1);
                setDirection(Direction.EAST);
                break;
        }
    }

    private void moveRightAndTurn() {
        switch(getDirection()){
            case EAST:
                getPosition().setHeight(getPosition().getHeight() + 1);
                getPosition().setWidth(getPosition().getWidth() + 1);
                setDirection(Direction.SOUTH);
                break;
            case WEST:
                getPosition().setHeight(getPosition().getHeight() - 1);
                getPosition().setWidth(getPosition().getWidth() - 1);
                setDirection(Direction.NORTH);
                break;
            case NORTH:
                getPosition().setHeight(getPosition().getHeight() - 1);
                getPosition().setWidth(getPosition().getWidth() + 1);
                setDirection(Direction.EAST);
                break;
            case SOUTH:
                getPosition().setHeight(getPosition().getHeight() - 1);
                getPosition().setWidth(getPosition().getWidth() - 1);
                setDirection(Direction.WEST);
                break;
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
