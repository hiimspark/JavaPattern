package Task8.Driving;

public class Bus extends Vehicle{
    @Override
    public void startVehicle() {
        System.out.println("Starting the bus...");
    }

    @Override
    public void driveVehicle() {
        System.out.println("Driving the bus...");
    }

    @Override
    public void stopVehicle() {
        System.out.println("Stopping the bus...");
    }
}
