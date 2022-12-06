package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

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
        Application.launch(App.class, args);
    }

}