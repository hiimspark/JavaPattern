package Task8.Driving;

abstract public class Vehicle {
    abstract public void startVehicle();
    abstract public void driveVehicle();
    abstract public void stopVehicle();

    public final void drive(){
        startVehicle();
        driveVehicle();
        stopVehicle();
    }
}
