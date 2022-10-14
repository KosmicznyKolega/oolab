package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public static String toString(MapDirection x) {
        switch (x) {
            case NORTH:
                return ("Północ");
            case SOUTH:
                return ("Południe");
            case WEST:
                return ("Zachód");
            case EAST:
                return ("Wschód");
        }
        return null;
    }

    private static int getI(MapDirection x) {
        int i = 0;
        switch (x) {
            case NORTH:
                i = 0;
                break;
            case EAST:
                i = 1;
                break;
            case SOUTH:
                i = 2;
                break;
            case WEST:
                i = 3;
                break;
        }
        return i;
    }

    public static MapDirection next(MapDirection dir) {
        int i = getI(dir);
        MapDirection[] tab = {MapDirection.NORTH, MapDirection.EAST, MapDirection.SOUTH, MapDirection.WEST};
        return tab[(i + 1) % 4];
    }

    public static MapDirection previous(MapDirection dir) {
        int i = getI(dir);
        MapDirection[] tab = {MapDirection.NORTH, MapDirection.EAST, MapDirection.SOUTH, MapDirection.WEST};
        return tab[(i + 3) % 4];
    }

    public Vector2d toUnitVector(MapDirection dir) {
        switch (dir){
            case NORTH:
                return new Vector2d(0,1);
            case SOUTH:
                return new Vector2d(0,-1);
            case EAST:
                return new Vector2d(1,0);
            case WEST:
                return new Vector2d(-1,0);
        }
        return null;
    }
}

