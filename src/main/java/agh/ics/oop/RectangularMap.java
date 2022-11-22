package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {
    Vector2d upperRight;
    Vector2d lowerLeft = new Vector2d(0, 0);

    public RectangularMap(int width, int height) {
        upperRight = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !this.isOccupied(position) && position.follows(lowerLeft) && position.precedes(upperRight);
    }
}

