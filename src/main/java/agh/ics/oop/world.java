package agh.ics.oop;

public class world {

    public static void run(Direction[] stuff){
        System.out.println("zwierzak idzie");
        for (Direction argument:stuff){
            switch(argument){
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

                }
        }
    }
        public static void main(String[] args){
        Direction[] directions = new Direction[]{Direction.FORWARD, Direction.BACKWARDS};
        System.out.println("start");
        run(directions);
        System.out.println("end");
    }
}
