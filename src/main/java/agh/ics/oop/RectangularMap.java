package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap {
    Vector2d upperRight;
    Vector2d lowerLeft = new Vector2d(0, 0);
    ArrayList<Animal> animals = new ArrayList<Animal>();

    public RectangularMap(int width, int height) {
        upperRight = new Vector2d(width, height);
    }

    @Override
    public String toString() {
        MapVisualiser mapa = new MapVisualiser(this);
        return mapa.draw(lowerLeft,upperRight);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !this.isOccupied(position) && position.follows(lowerLeft) && position.precedes(upperRight);
    }

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) {
                return animal;
            }
        }
        return null;
    }
}
