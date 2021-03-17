package homework_one;

public class Wall implements Barrier{

    private int high;

    public Wall(int high) {
        this.high = high;
    }


    @Override
    public int getValue() {
        return high;
    }

    @Override
    public boolean letsTry(Actions member) {
        return member.jump(high);
    }
}
