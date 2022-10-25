package agh.ics.oop;

public class OptionsParser {
    public MoveDirection[] parse(String[] text){
        int iterator=0;
        int licznik=0;
        for (String s : text){
            switch (s) {
                case "f","b","r","l": licznik=licznik+1;
                default:
                    break;
            }
        }
        MoveDirection[] answer = new MoveDirection[licznik];
        for (String s : text){
            switch (s) {
                case "f":
                    answer[iterator]=MoveDirection.FORWARD;
                    break;
                case "b":
                    answer[iterator]=MoveDirection.BACKWARD;
                    break;
                case "l":
                    answer[iterator]=MoveDirection.LEFT;
                    break;
                case "r":
                    answer[iterator]=MoveDirection.RIGHT;
                    break;
                default:
                    iterator=iterator-1;
                    break;
            }
            iterator=iterator+1;
        }
        return answer;
    }

}
