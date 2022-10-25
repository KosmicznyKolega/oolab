package agh.ics.oop;
import java.util.Scanner;

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
        Animal zwierze = new Animal();
        System.out.println(zwierze.toString());
        Scanner obiekt = new Scanner(System.in);
        int length = obiekt.nextInt();
        String[] arrayOfStrings=new String[length];
        int iterator=0;
        Scanner obiekt2 = new Scanner(System.in);
        while (iterator<length){
            arrayOfStrings[iterator]=obiekt2.nextLine();
            iterator=iterator+1;
        }
        OptionsParser kierunkowacz = new OptionsParser();
        MoveDirection[] kierunki = kierunkowacz.parse(arrayOfStrings);
        iterator=0;
        while (iterator<kierunki.length){
            zwierze.move(kierunki[iterator]);
            iterator=iterator+1;
        }
        System.out.println(zwierze.toString());
    }
}