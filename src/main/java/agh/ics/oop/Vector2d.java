package agh.ics.oop;

public record Vector2d(int x, int y) {

    @Override
    public String toString() {
        return "(" + x +
                "," + y +
                ')';
    }

    public boolean precedes(Vector2d other) {
        return (this.x <= other.x) && (this.y <= other.y);
    }

    public boolean follows(Vector2d other) {
        return (this.x >= other.x) && (this.y >= other.y);
    }

    public Vector2d upperRight(Vector2d other) {

        int x1 = this.x;
        int y1 = this.y;
        if (this.x < other.x) {
            x1 = other.x;
        }
        if (this.y < other.y) {
            y1 = other.y;
        }
        return new Vector2d(x1, y1);
    }

    public Vector2d lowerLeft(Vector2d other) {

        int x1 = this.x;
        int y1 = this.y;
        if (this.x > other.x) {
            x1 = other.x;
        }
        if (this.y > other.y) {
            y1 = other.y;
        }
        return new Vector2d(x1, y1);
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public boolean equals(Vector2d other) {
        return (this.x == other.x) && (this.y == other.y);
    }

    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }
}

