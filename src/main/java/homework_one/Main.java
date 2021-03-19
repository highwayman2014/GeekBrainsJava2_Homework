package homework_one;

public class Main {

    public static void main(String[] args) {

        Actions[] team = {new Cat("Степан"), new Human("Усейн Болт"), new Robot("C3PO")};

        Barrier[] barriers = new Barrier[5];
        barriers[0] = new Track(50);
        barriers[1] = new Wall(1);
        barriers[2] = new Track(150);
        barriers[3] = new Wall(3);
        barriers[4] = new Track(1000);

        for (Actions member:team) {
            for(Barrier barrier:barriers){
                if(!barrier.letsTry(member)){
                    break;
                }
            }
        }
    }
}
