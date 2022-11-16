package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {
    @Test
    void objectAtTest(){
        assertNull(new GrassField(0).objectAt(new Vector2d(2,2)));
    }
    @Test
    void canMoveToTest(){
        assertTrue(new GrassField(10).canMoveTo(new Vector2d(2,2)));
    }
    @Test
    void placeAndIsOccupiedTest(){
        GrassField grassfield = new GrassField(10);
        grassfield.place(new Animal(grassfield,new Vector2d(2,2)));
        assertTrue(grassfield.isOccupied(new Vector2d(2,2)));
    }
}
