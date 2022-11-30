package agh.ics.oop;

public class OptionsParser {
    public MoveDirection[] parse(String[] text) {
        int iterator = 0;
        MoveDirection[] answer = new MoveDirection[text.length];
        for (String s : text) {
            switch (s) {
                case "f":
                    answer[iterator] = MoveDirection.FORWARD;
                    break;
                case "b":
                    answer[iterator] = MoveDirection.BACKWARD;
                    break;
                case "l":
                    answer[iterator] = MoveDirection.LEFT;
                    break;
                case "r":
                    answer[iterator] = MoveDirection.RIGHT;
                    break;
                default:
                    throw new IllegalArgumentException(s + " is not legal move specification");
            }
        iterator++;
        }
        return answer;
    }

}
