package agh.ics.oop;

public class World {

    public static Direction[] changeDir(String argument) {
        switch (argument){
            case "f":
                return new Direction[]{Direction.FORWARD};
            case "b":
                return new Direction[]{Direction.BACKWARDS};
            case "l":
                return new Direction[]{Direction.LEFT};
            case "r":
                return new Direction[]{Direction.RIGHT};
            default:
                break;
        }
    return new Direction[]{};
    }

    public static void run(Direction[] stuff) {
        for (Direction argument : stuff) {
            switch (argument) {
                case FORWARD:
                    System.out.println("zwierzak idzie do przodu");
                    break;
                case BACKWARDS:
                    System.out.println("zwierzak idzie do tylu");
                    break;
                case LEFT:
                    System.out.println("zwierzak idzie w lewo");
                    break;
                case RIGHT:
                    System.out.println("zwierzak idze w prawo");
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("start");
        for (String argument : args) {
            Direction[] directions = changeDir(argument);
            run(directions);
        }
        System.out.println("end");
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        System.out.println(MapDirection.toString(MapDirection.previous(MapDirection.NORTH)));
    }
}