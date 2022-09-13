import org.junit.Before;
import org.junit.Test;
import robotParts.Direction;
import robotParts.Grid;
import robots.ArcadeRobot;
import robots.TankRobot;

import static junit.framework.TestCase.assertEquals;

public class TankRobotTest {

    Grid grid;

    TankRobot tankRobot;

    @Before
    public void setUp() {
        grid = new Grid(5, 5);
        tankRobot = new TankRobot(grid);
        tankRobot.setPosition(0,0);
        tankRobot.setDirection(Direction.EAST);
    }

    @Test
    public void moveRobot() {
        assertEquals(tankRobot.getDirection(), Direction.EAST);
        tankRobot.move('F', 'F');
        assertEquals(1, tankRobot.getPosition().getWidth());
        assertEquals(0, tankRobot.getPosition().getHeight());
        tankRobot.move('F', 'B');
        assertEquals(tankRobot.getDirection(), Direction.SOUTH);
        assertEquals(1, tankRobot.getPosition().getWidth());
        assertEquals(0, tankRobot.getPosition().getHeight());
        tankRobot.move('F', 'B');
        assertEquals(tankRobot.getDirection(), Direction.WEST);
        assertEquals(1, tankRobot.getPosition().getWidth());
        assertEquals(0, tankRobot.getPosition().getHeight());
        tankRobot.move('F', 'F');
        assertEquals(0, tankRobot.getPosition().getWidth());
        assertEquals(0, tankRobot.getPosition().getHeight());
        tankRobot.move('B', 'B');
        assertEquals(1, tankRobot.getPosition().getWidth());
        assertEquals(0, tankRobot.getPosition().getHeight());

        tankRobot.move('B', 'F');
        assertEquals(tankRobot.getDirection(), Direction.SOUTH);
        assertEquals(1, tankRobot.getPosition().getWidth());
        assertEquals(0, tankRobot.getPosition().getHeight());

        tankRobot.move('B', 'F');
        assertEquals(tankRobot.getDirection(), Direction.EAST);
        assertEquals(1, tankRobot.getPosition().getWidth());
        assertEquals(0, tankRobot.getPosition().getHeight());

        tankRobot.move('B', 'F');
        assertEquals(tankRobot.getDirection(), Direction.NORTH);
        assertEquals(1, tankRobot.getPosition().getWidth());
        assertEquals(0, tankRobot.getPosition().getHeight());

    }

    @Test
    public void hitWall(){
        tankRobot.setPosition(-1,-1);
        tankRobot.move('K', 'K');
        assertEquals(0, tankRobot.getPosition().getWidth());
        assertEquals(0, tankRobot.getPosition().getHeight());
        tankRobot.setPosition(99, 99);
        tankRobot.move('K', 'K');
        assertEquals(4, tankRobot.getPosition().getWidth());
        assertEquals(4, tankRobot.getPosition().getHeight());
    }
}
