package agh.ics.oop;

public class World {

    public static Direction changeDir(String argument) {
        switch (argument) {
            case "f":
                return Direction.FORWARD;
            case "b":
                return Direction.BACKWARDS;
            case "l":
                return Direction.LEFT;
            case "r":
                return Direction.RIGHT;
            default:
                break;
        }
        return null;
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
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.print(map);
    }
}