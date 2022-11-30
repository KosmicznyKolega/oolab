package agh.ics.oop;

import java.util.ArrayList;

public class Animal {
    private Vector2d position;
    private MapDirection orientation = MapDirection.NORTH;
    private IWorldMap map;
    private ArrayList<IPositionChangeObserver> IPositionChangeObservers = new ArrayList<>();

    public Animal(IWorldMap map) {
        this(map, new Vector2d(2, 2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    public void subscribe(IPositionChangeObserver map) {
        IPositionChangeObservers.add( map);
    }

    public void unsubscribe(IPositionChangeObserver map) {
        IPositionChangeObservers.remove(map);
    }
    private void notifySubscribers(Vector2d oldPosition, Vector2d newPosition, Object object){
        for (IPositionChangeObserver IPositionChangeObserver : IPositionChangeObservers){
            IPositionChangeObserver.positionChanged(oldPosition, newPosition,object);
        }
    }

    @Override
    public String toString() {
        switch (orientation) {
            case EAST -> {
                return "E";
            }
            case WEST -> {
                return "W";
            }
            case NORTH -> {
                return "N";
            }
            case SOUTH -> {
                return "S";
            }
        }
        return null;
    }


    public boolean isAt(Vector2d currentPosition) {
        return (currentPosition.equals(position));
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    private boolean isContained(Vector2d newPosition) {
        return map.canMoveTo(newPosition);
    }

    private void changePosition(MoveDirection direction) {
        Vector2d VectorOfOrientation = orientation.toUnitVector(orientation);
        if (isContained(position.add(VectorOfOrientation)) && direction.equals(MoveDirection.FORWARD)) {
            position = position.add(VectorOfOrientation);
        } else if (isContained(position.subtract(VectorOfOrientation)) && direction.equals(MoveDirection.BACKWARD)) {
            position = position.subtract(VectorOfOrientation);
        }
    }


    public void move(MoveDirection direction) {
        Vector2d oldPosition=position;
        switch (direction) {
            case LEFT -> orientation = orientation.previous(orientation);
            case RIGHT -> orientation = orientation.next(orientation);
            case FORWARD -> changePosition(MoveDirection.FORWARD);
            case BACKWARD -> changePosition(MoveDirection.BACKWARD);
        }
        notifySubscribers(oldPosition,position,this);
    }


}

