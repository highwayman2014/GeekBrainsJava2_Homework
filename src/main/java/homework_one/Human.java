package homework_one;

public class Human implements Actions{

    private String name;
    private int runLimit;
    private int jumpLimit;

    public Human(String name) {
        this.name = name;
        this.runLimit = 500;
        this.jumpLimit = 1;
    }

    @Override
    public boolean run(int trackLength) {
        if (trackLength > runLimit){
            System.out.println("Человек " + this.name + " не смог пробежать " + trackLength);
            return false;
        }else{
            System.out.println("Человек " + this.name + " пробежал " + trackLength);
            return true;
        }
    }

    @Override
    public boolean jump(int wallHigh) {
        if (wallHigh > jumpLimit){
            System.out.println("Человек " + this.name + " не смог перепрыгнуть " + wallHigh);
            return false;
        }else{
            System.out.println("Человек " + this.name + " перепрыгнул " + wallHigh);
            return true;
        }
    }
}
