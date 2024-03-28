package Task8.Driving;

public class Car extends Vehicle{
    @Override
    public void startVehicle() {
        System.out.println("Starting the car...");
    }

    @Override
    public void driveVehicle() {
        System.out.println("Driving the car...");
    }

    @Override
    public void stopVehicle() {
        System.out.println("Stopping the car...");
    }
}
