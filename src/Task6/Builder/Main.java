package Task6.Builder;

public class Main {
    public static void main(String[] args) {
        Director redDirector = new Director(new Red2FloorHouseBuilder());
        Director blueDirector = new Director(new Blue3FloorHouseBuilder());

        redDirector.build();
        blueDirector.build();

        System.out.println(redDirector.getBuildResult());
        System.out.println(blueDirector.getBuildResult());
    }
}
