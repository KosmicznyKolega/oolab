package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    RectangularMap map = new RectangularMap(4,4);
    @Test
    public void positionTest(){
        Animal animal = new Animal(map);
        assertEquals(animal.getOrientation(),MapDirection.NORTH);
        assertEquals(animal.getPosition(),new Vector2d(2,2));

    }
    @Test
    public void toStringTest(){
        assertEquals("N", new Animal(map).toString());
    }
    @Test
    public void isAtTest(){
        assertTrue(new Animal(map).isAt(new Vector2d(2,2)));
    }
    @Test
    public void moveTest(){
        Animal zwierze = new Animal(map);
        zwierze.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, zwierze.getOrientation());
        zwierze.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, zwierze.getOrientation());
        zwierze.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,3),zwierze.getPosition());
        zwierze.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2,2),zwierze.getPosition());
    }
    @Test
    public void placeTest(){

        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(2,3)));
        assertTrue(map.isOccupied(new Vector2d(2,2)));
        assertTrue(map.isOccupied(new Vector2d(2,3)));
    }

    @Test
    public void exceptionTest(){
        try {
            map.place(new Animal(map));
            map.place(new Animal(map));
        }
        catch (IllegalArgumentException e){
            assertEquals("there already is an animal there",e.getMessage());
        }
    }

}
