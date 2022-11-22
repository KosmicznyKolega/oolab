package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
    @Test
    public void parseTest() {
        OptionsParser doTestu = new OptionsParser();
        MoveDirection[] tezDoTestu = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT};
        MoveDirection[] tezDoTestu2 = doTestu.parse(new String[]{"f", "r", "b", "l"});
        assertTrue(Arrays.equals(tezDoTestu, tezDoTestu2));

    }



    @Test
    public void exceptionTest() {
        OptionsParser doTestu = new OptionsParser();
        try {
            doTestu.parse(new String[]{"f", "r", "b", "dupa2", "l"});
        }
        catch (IllegalArgumentException e){
            assertEquals( "dupa2 is not legal move specification", e.getMessage());
        }
    }
}