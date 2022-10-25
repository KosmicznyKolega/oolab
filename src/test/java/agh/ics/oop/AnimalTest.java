package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    public void toStringTest(){
        assertEquals("Animal{position=(2,2), orientation=NORTH}", new Animal().toString());
    }
    @Test
    public void isAtTest(){
        assertTrue(new Animal().isAt(new Vector2d(2,2)));
    }
    @Test
    public void moveTest(){
        Animal zwierze = new Animal();
        zwierze.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, zwierze.getOrientation());
        zwierze.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, zwierze.getOrientation());
        zwierze.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,3),zwierze.getPosition());
        zwierze.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2,2),zwierze.getPosition());
    }
}
