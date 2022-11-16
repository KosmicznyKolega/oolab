package agh.ics.oop;

import java.util.ArrayList;

abstract class AbstractWorldMap implements IWorldMap {
    protected ArrayList<Animal> animals = new ArrayList<>();

    public boolean place(Animal animal) {
        for (Animal animal1 : animals) {
            if (animal1.isAt(animal.getPosition())) {
                return false;
            }
        }
        animals.add(animal);
        return true;
    }

    protected String whatToReturn(MapVisualiser map) {
        return map.draw(new Vector2d(0, 0), new Vector2d(10, 10));
    }

    public String toString() {
        MapVisualiser mapa = new MapVisualiser(this);
        return whatToReturn(mapa);

    }

    protected boolean checkForAnyOtherObjects(Vector2d position) {
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) {
                return true;
            }
        }
        return checkForAnyOtherObjects(position);
    }
}
