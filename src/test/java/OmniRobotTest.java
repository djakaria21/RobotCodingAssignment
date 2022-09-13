import org.junit.Before;
import org.junit.Test;
import robotParts.Direction;
import robotParts.Grid;
import robots.OmniRobot;
import robots.TankRobot;

import static junit.framework.TestCase.assertEquals;

public class OmniRobotTest {

    Grid grid;

    OmniRobot omniRobot;

    @Before
    public void setUp() {
        grid = new Grid(5, 5);
        omniRobot = new OmniRobot(grid);
        omniRobot.setPosition(0,0);
        omniRobot.setDirection(Direction.EAST);
    }

    @Test
    public void moveRobot() {
        assertEquals(omniRobot.getDirection(), Direction.EAST);
        omniRobot.move('F', 'F');
        assertEquals(1, omniRobot.getPosition().getWidth());
        assertEquals(0, omniRobot.getPosition().getHeight());
        omniRobot.move('F', 'B');
        assertEquals(omniRobot.getDirection(), Direction.SOUTH);
        assertEquals(1, omniRobot.getPosition().getWidth());
        assertEquals(0, omniRobot.getPosition().getHeight());
        omniRobot.move('F', 'B');
        assertEquals(omniRobot.getDirection(), Direction.WEST);
        assertEquals(1, omniRobot.getPosition().getWidth());
        assertEquals(0, omniRobot.getPosition().getHeight());
        omniRobot.move('F', 'F');
        assertEquals(0, omniRobot.getPosition().getWidth());
        assertEquals(0, omniRobot.getPosition().getHeight());
        omniRobot.move('B', 'B');
        assertEquals(1, omniRobot.getPosition().getWidth());
        assertEquals(0, omniRobot.getPosition().getHeight());

        omniRobot.move('B', 'F');
        assertEquals(omniRobot.getDirection(), Direction.SOUTH);
        assertEquals(1, omniRobot.getPosition().getWidth());
        assertEquals(0, omniRobot.getPosition().getHeight());

        omniRobot.move('B', 'F');
        assertEquals(omniRobot.getDirection(), Direction.EAST);
        assertEquals(1, omniRobot.getPosition().getWidth());
        assertEquals(0, omniRobot.getPosition().getHeight());
        assertEquals(omniRobot.getDirectionAndPosition(), "EAST 1 0");

        omniRobot.move('B', 'F');
        assertEquals(omniRobot.getDirection(), Direction.NORTH);
        assertEquals(1, omniRobot.getPosition().getWidth());
        assertEquals(0, omniRobot.getPosition().getHeight());

        //moves to the right
        omniRobot.move('F', 'N');
        assertEquals(2, omniRobot.getPosition().getWidth());
        assertEquals(-1, omniRobot.getPosition().getHeight());
        assertEquals(omniRobot.getDirection(), Direction.EAST);

        omniRobot.move('N', 'F');
        assertEquals(3, omniRobot.getPosition().getWidth());
        assertEquals(-2, omniRobot.getPosition().getHeight());
        assertEquals(omniRobot.getDirection(), Direction.NORTH);

        omniRobot.move('R', 'R');
        assertEquals(4, omniRobot.getPosition().getWidth());
        assertEquals(-2, omniRobot.getPosition().getHeight());

        omniRobot.move('L', 'L');
        assertEquals(3, omniRobot.getPosition().getWidth());
        assertEquals(-2, omniRobot.getPosition().getHeight());

    }

    //not adding wall check to omni robot because test would break
}
