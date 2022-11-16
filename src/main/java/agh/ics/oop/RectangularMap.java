package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {
    Vector2d upperRight;
    Vector2d lowerLeft = new Vector2d(0, 0);

    public RectangularMap(int width, int height) {
        upperRight = new Vector2d(width, height);
    }

    public String whatToReturn(MapVisualiser map){
        return map.draw(lowerLeft,upperRight);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !this.isOccupied(position) && position.follows(lowerLeft) && position.precedes(upperRight);
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
