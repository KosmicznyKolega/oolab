package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2d,Animal> animals = new HashMap<>();

    public boolean place(Animal animal) {
        if (animals.get(animal.getPosition())!=null){
            throw new IllegalArgumentException("there already is an animal there");
        }
        animals.put(animal.getPosition(),animal);
        animal.subscribe(this);
        return true;
    }

    protected Vector2d lowestLeft() {
        return new Vector2d(0, 0);
    }
    protected Vector2d uppestRight(){
        return new Vector2d(10,10);
    }

    protected Object returnAnyOtherObjects(Vector2d position){
        return null;
    }
    public Object objectAt(Vector2d position) {
        if (animals.get(position)!=null){
        return animals.get(position);}
        return returnAnyOtherObjects(position);
    }
    public String toString() {
        MapVisualiser mapa = new MapVisualiser(this);
        Vector2d lowestLeftBoundary=lowestLeft();
        Vector2d upperRightBoundary=uppestRight();
        return mapa.draw(lowestLeftBoundary,upperRightBoundary);

    }

    protected boolean checkForAnyOtherObjects(Vector2d position) {
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        if(animals.get(position)!=null){
            return true;
        }
        return checkForAnyOtherObjects(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition,Object object) {
        if (!newPosition.equals(oldPosition)){
            animals.put(newPosition, animals.get(oldPosition));
            animals.remove(oldPosition);
        }
    }
}
