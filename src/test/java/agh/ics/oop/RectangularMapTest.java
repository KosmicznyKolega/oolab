package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    @Test
    public void placeAndIsOccupiedTest() {
        RectangularMap map = new RectangularMap(40, 30);
        Animal animal1 = new Animal(map, new Vector2d(10, 10));
        Animal animal2 = new Animal(map, new Vector2d(3, 3));
        Animal animal3 = new Animal(map, new Vector2d(30, 15));
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);

        assertTrue(map.isOccupied(new Vector2d(10, 10)));
        assertTrue(map.isOccupied(new Vector2d(3, 3)));
        assertTrue(map.isOccupied(new Vector2d(30, 15)));
        assertFalse(map.isOccupied(new Vector2d(13, 13)));
        assertFalse(map.isOccupied(new Vector2d(15, 30)));
    }

    @Test
    public void objectAtTest() {
        RectangularMap map = new RectangularMap(40, 30);
        Animal animal1 = new Animal(map, new Vector2d(10, 10));
        Animal animal2 = new Animal(map, new Vector2d(3, 3));
        Animal animal3 = new Animal(map, new Vector2d(30, 15));
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);

        assertEquals(animal1, map.objectAt(new Vector2d(10, 10)));
        assertEquals(animal2, map.objectAt(new Vector2d(3, 3)));
        assertEquals(animal3, map.objectAt(new Vector2d(30, 15)));
        assertFalse(animal1 == map.objectAt(new Vector2d(30, 15)));
    }

    @Test
    public void canMoveToTest() {
        RectangularMap map = new RectangularMap(41, 31);
        Animal animal1 = new Animal(map, new Vector2d(10, 10));
        Animal animal2 = new Animal(map, new Vector2d(3, 3));
        Animal animal3 = new Animal(map, new Vector2d(30, 15));
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);

        assertFalse(map.canMoveTo(new Vector2d(30, 15)));
        assertFalse(map.canMoveTo(new Vector2d(10, 10)));
        assertFalse(map.canMoveTo(new Vector2d(3, 3)));
        assertFalse(map.canMoveTo(new Vector2d(40, 40)));
        assertFalse(map.canMoveTo(new Vector2d(-1, -1)));

        assertTrue(map.canMoveTo(new Vector2d(15, 30)));
        assertTrue(map.canMoveTo(new Vector2d(30, 30)));
    }
}