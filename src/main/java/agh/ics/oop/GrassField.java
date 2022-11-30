package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class GrassField extends AbstractWorldMap {
    private Map<Vector2d, Grass> grasses = new HashMap<>();
    private MapBoundary edges= new MapBoundary();

    public GrassField(int grassCount) {
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
        HashMap<Vector2d,Object> shallowCopy = new HashMap<Vector2d, Object>(grasses);
        this.edges.addToMultiMap(shallowCopy);
    }

    @Override
    public Vector2d lowestLeft() {
        return edges.getLeftBoundary();
    }
    @Override
    public Vector2d uppestRight() {
        return edges.getRightBoundary();
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
    @Override
    public boolean place(Animal animal){
        super.place(animal);
        animal.subscribe(edges);
        edges.placeObject(animal.getPosition(),animal);
    return true;
    }
}
