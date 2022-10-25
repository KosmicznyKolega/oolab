package agh.ics.oop;

public class Animal {
    private Vector2d position = new Vector2d(2, 2);
    private MapDirection orientation = MapDirection.NORTH;

    @Override
    public String toString() {
        return "Animal{" +
                "position=" + position +
                ", orientation=" + orientation +
                '}';
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

    private void moveForwardOrBackward(boolean forward) {
        if (((orientation.equals(MapDirection.EAST) && forward) || (orientation.equals(MapDirection.WEST) && !forward)) && position.precedes(new Vector2d(3, 4))) {
            position = position.add(new Vector2d(1, 0));
        } else if (((orientation == MapDirection.NORTH && forward) || (orientation == MapDirection.SOUTH && !forward)) && position.precedes(new Vector2d(4, 3))) {
            position = position.add(new Vector2d(0, 1));
        } else if (((orientation == MapDirection.SOUTH && forward) || (orientation == MapDirection.NORTH && !forward)) && position.follows(new Vector2d(0, 1))) {
            position = position.subtract(new Vector2d(0, 1));
        } else if (((orientation == MapDirection.WEST && forward) || (orientation == MapDirection.EAST && !forward)) && position.follows(new Vector2d(1, 0))) {
            position = position.subtract(new Vector2d(1, 0));
        }
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case LEFT -> orientation = orientation.previous(orientation);
            case RIGHT -> orientation = orientation.next(orientation);
            case FORWARD -> moveForwardOrBackward(true);
            case BACKWARD -> moveForwardOrBackward(false);
        }
    }

}

