package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
    @Test
    public void parseTest(){
        OptionsParser doTestu = new OptionsParser();
        MoveDirection[] tezDoTestu = new MoveDirection[] {MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.BACKWARD,MoveDirection.LEFT};
        MoveDirection[] tezDoTestu2 = doTestu.parse(new String[]{"f","r","xd","dupa2","b","l"});
        assertTrue(Arrays.equals(tezDoTestu,tezDoTestu2));
    }
}
