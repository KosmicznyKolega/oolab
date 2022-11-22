package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class GrassField extends AbstractWorldMap {
    private final Vector2d lowerLeft = new Vector2d(0, 0);
    private final Vector2d upperRight;
    private Map<Vector2d, Grass> grasses = new HashMap<>();

    public GrassField(int grassCount) {
        this.upperRight = new Vector2d((int) Math.sqrt(grassCount * 10), (int) Math.sqrt(grassCount * 10));
        ArrayList<Vector2d> allPossiblePlaces = new ArrayList<>();
        for (int iterator1 = 0; iterator1 < (int) Math.sqrt(grassCount * 10); iterator1++) {
            for (int iterator2 = 0; iterator2 < (int) Math.sqrt(grassCount * 10); iterator2++) {
                allPossiblePlaces.add(new Vector2d(iterator1, iterator2));
            }
        }
        Collections.shuffle(allPossiblePlaces);
        for (int iterator3 = 0; iterator3 < grassCount; iterator3++) {
            grasses.put(allPossiblePlaces.get(iterator3), new Grass(allPossiblePlaces.get(iterator3)));
        }
    }

    @Override
    public Vector2d lowestLeft() {
        Vector2d lowestLeftBoundary = lowerLeft;
        for (Animal value : animals.values()) {
            lowestLeftBoundary = value.getPosition().lowerLeft(lowestLeftBoundary);
        }
        return lowestLeftBoundary;
    }
    @Override
    public Vector2d uppestRight() {
        Vector2d upperRightBoundary = upperRight;
        for (Animal value : animals.values()) {
            upperRightBoundary = value.getPosition().upperRight(upperRightBoundary);
        }
        return upperRightBoundary;
    }
    @Override
    public boolean checkForAnyOtherObjects(Vector2d position) {
        return grasses.get(position) != null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return animals.get(position) == null;
    }

    @Override
    public Object returnAnyOtherObjects(Vector2d position) {
        return grasses.get(position);
    }
}
