package Task8.Driving;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.drive();
        System.out.println();
        vehicle = new Bus();
        vehicle.drive();

    }
}
