import org.junit.Before;
import org.junit.Test;
import robotParts.Direction;
import robotParts.Grid;
import robots.ArcadeRobot;

import static junit.framework.TestCase.assertEquals;

public class ArcadeRobotTest {

    Grid grid;

    ArcadeRobot arcadeRobot;

    @Before
    public void setUp() {
        grid = new Grid(5, 5);
        arcadeRobot = new ArcadeRobot(grid);
        arcadeRobot.setPosition(0,0);
        arcadeRobot.setDirection(Direction.EAST);
    }

    @Test
    public void moveRobot() {
        assertEquals(arcadeRobot.getDirection(), Direction.EAST);
        arcadeRobot.move('F');
        assertEquals(1, arcadeRobot.getPosition().getWidth());
        assertEquals(0, arcadeRobot.getPosition().getHeight());
        arcadeRobot.move('R');
        assertEquals(arcadeRobot.getDirection(), Direction.SOUTH);
        assertEquals(2, arcadeRobot.getPosition().getWidth());
        assertEquals(1, arcadeRobot.getPosition().getHeight());
        arcadeRobot.move('F');
        assertEquals(2, arcadeRobot.getPosition().getWidth());
        assertEquals(2, arcadeRobot.getPosition().getHeight());
        arcadeRobot.move('B');
        assertEquals(2, arcadeRobot.getPosition().getWidth());
        assertEquals(1, arcadeRobot.getPosition().getHeight());
        arcadeRobot.move('L');
        assertEquals(arcadeRobot.getDirection(), Direction.EAST);
        assertEquals(3, arcadeRobot.getPosition().getWidth());
        assertEquals(2, arcadeRobot.getPosition().getHeight());

    }

    @Test
    public void hitWall(){
        arcadeRobot.setPosition(-1,-1);
        arcadeRobot.move('K');
        assertEquals(0, arcadeRobot.getPosition().getWidth());
        assertEquals(0, arcadeRobot.getPosition().getHeight());
        arcadeRobot.setPosition(99, 99);
        arcadeRobot.move('K');
        assertEquals(4, arcadeRobot.getPosition().getWidth());
        assertEquals(4, arcadeRobot.getPosition().getHeight());
    }
}
