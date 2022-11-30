package agh.ics.oop;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.HashMap;
import java.util.Map;


public class MapBoundary implements  IPositionChangeObserver{
    private Vector2d leftBoundary;
    private Vector2d rightBoundary;
    private Multimap<Vector2d, Object> mapOfObjects = ArrayListMultimap.create();
    public void addToMultiMap(HashMap<Vector2d,Object> hashmap){
        for(Map.Entry<Vector2d,Object> entry:hashmap.entrySet()) {
            Vector2d key = entry.getKey();
            Object value = entry.getValue();
            mapOfObjects.put(key,value);
        }
        for ( Vector2d key : mapOfObjects.keySet()){
            rightBoundary=key;
            leftBoundary=key;
            break;
        }
        for ( Vector2d key : mapOfObjects.keySet()){
            rightBoundary=rightBoundary.upperRight(key);
            leftBoundary=leftBoundary.lowerLeft(key);
        }
    }
    public void placeObject(Vector2d position, Object object){
        mapOfObjects.put(position,object);
        rightBoundary=position.upperRight(rightBoundary);
        leftBoundary=position.lowerLeft(leftBoundary);
    }


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition, Object object) {
        if (!newPosition.upperRight(rightBoundary).equals(rightBoundary)|| !newPosition.lowerLeft(leftBoundary).equals(leftBoundary)){
            leftBoundary=newPosition.lowerLeft(leftBoundary);
            rightBoundary=newPosition.upperRight(rightBoundary);
        }
        else if (oldPosition.follows(rightBoundary) && !newPosition.follows(rightBoundary)) {
            for ( Vector2d key : mapOfObjects.keySet()){
                rightBoundary=newPosition.upperRight(key);
            }
        }
        else if (oldPosition.precedes(leftBoundary) && !newPosition.precedes(leftBoundary)){
            for ( Vector2d key : mapOfObjects.keySet()){
                leftBoundary=newPosition.lowerLeft(key);
            }
        }
        if (newPosition!=oldPosition){
            mapOfObjects.remove(oldPosition,object);
            mapOfObjects.put(newPosition,object);
        }

    }

    public Vector2d getLeftBoundary() {
        return leftBoundary;
    }

    public Vector2d getRightBoundary() {
        return rightBoundary;
    }
}

