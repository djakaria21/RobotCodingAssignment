package robots;

import robotParts.Grid;

public class SwerveRobot extends Robot{

    Grid grid;
    public SwerveRobot(Grid grid) {
        this.grid = grid;
    }


    public void move(char f) {
        switch (f) {
            case 'F':
                moveForward();
                checkWalls();
                break;
            case 'B':
                moveBackward();
                checkWalls();
                break;
            case 'L':
                turnLeft();
                checkWalls();
                break;
            case 'R':
                turnRight();
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

    private void turnRight() {
        getPosition().setHeight(getPosition().getHeight() + 1);
    }

    private void turnLeft() {
        getPosition().setHeight(getPosition().getHeight() - 1);
    }

    private void moveBackward() {
        getPosition().setWidth(getPosition().getWidth() - 1);
    }

    private void moveForward() {
        getPosition().setWidth(getPosition().getWidth() + 1);
    }
    }
}

