package homework_one;

public class Track implements Barrier{

    private int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public int getValue() {
        return length;
    }

    @Override
    public boolean letsTry(Actions member) {
        return member.run(length);
    }
}
