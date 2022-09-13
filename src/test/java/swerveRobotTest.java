import org.junit.Before;
import org.junit.Test;
import robotParts.Direction;
import robotParts.Grid;
import robots.SwerveRobot;

import static junit.framework.TestCase.assertEquals;

public class swerveRobotTest {

    Grid grid;

    SwerveRobot swerveRobot;

    @Before
    public void setUp() {
        grid = new Grid(5, 5);
        swerveRobot = new SwerveRobot(grid);
        swerveRobot.setPosition(0,0);
        swerveRobot.setDirection(Direction.EAST);
    }

    @Test
    public void moveRobot() {
        assertEquals(swerveRobot.getDirection(), Direction.EAST);
        swerveRobot.move('F');
        assertEquals(1, swerveRobot.getPosition().getWidth());
        assertEquals(0, swerveRobot.getPosition().getHeight());
        swerveRobot.move('R');
        assertEquals(1, swerveRobot.getPosition().getWidth());
        assertEquals(1, swerveRobot.getPosition().getHeight());
        swerveRobot.move('B');
        assertEquals(0, swerveRobot.getPosition().getWidth());
        assertEquals(1, swerveRobot.getPosition().getHeight());
        swerveRobot.move('L');
        assertEquals(0, swerveRobot.getPosition().getWidth());
        assertEquals(0, swerveRobot.getPosition().getHeight());
    }

    @Test
    public void hitWall(){
        swerveRobot.setPosition(-1,-1);
        swerveRobot.move('K');
        assertEquals(0, swerveRobot.getPosition().getWidth());
        assertEquals(0, swerveRobot.getPosition().getHeight());
        swerveRobot.setPosition(99, 99);
        swerveRobot.move('K');
        assertEquals(4, swerveRobot.getPosition().getWidth());
        assertEquals(4, swerveRobot.getPosition().getHeight());
    }

}
