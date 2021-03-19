package homework_one;

public class Robot implements Actions{

    private String name;
    private int runLimit;
    private int jumpLimit;

    public Robot(String name) {
        this.name = name;
        this.runLimit = 1000;
        this.jumpLimit = 10;
    }

    @Override
    public boolean run(int trackLength) {
        if (trackLength > runLimit){
            System.out.println("Робот " + this.name + " не смог пробежать " + trackLength);
            return false;
        }else{
            System.out.println("Робот " + this.name + " пробежал " + trackLength);
            return true;
        }
    }

    @Override
    public boolean jump(int wallHigh) {
        if (wallHigh > jumpLimit){
            System.out.println("Робот " + this.name + " не смог перепрыгнуть " + wallHigh);
            return false;
        }else{
            System.out.println("Робот " + this.name + " перепрыгнул " + wallHigh);
            return true;
        }
    }
}
