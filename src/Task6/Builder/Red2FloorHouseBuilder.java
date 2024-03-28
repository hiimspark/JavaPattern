package Task6.Builder;

public class Red2FloorHouseBuilder implements Builder {
    House house = new House();
    @Override
    public void setFloors() {
        house.setFloors(2);
    }

    @Override
    public void setColor() {
        house.setColor("Red");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
