package homework_one;

public class Cat implements Actions{

    private String name;
    private int runLimit;
    private int jumpLimit;

    public Cat(String name) {
        this.name = name;
        this.runLimit = 100;
        this.jumpLimit = 2;
    }

    @Override
    public boolean run(int trackLength) {
        if (trackLength > runLimit){
            System.out.println("Кот " + this.name + " не смог пробежать " + trackLength);
            return false;
        }else{
            System.out.println("Кот " + this.name + " пробежал " + trackLength);
            return true;
        }
    }

    @Override
    public boolean jump(int wallHigh) {
        if (wallHigh > jumpLimit){
            System.out.println("Кот " + this.name + " не смог перепрыгнуть " + wallHigh);
            return false;
        }else{
            System.out.println("Кот " + this.name + " перепрыгнул " + wallHigh);
            return true;
        }
    }
}
