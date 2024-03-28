package Task6.Builder;

public class Blue3FloorHouseBuilder implements Builder {
    House house = new House();
    @Override
    public void setFloors() {
        house.setFloors(3);
    }

    @Override
    public void setColor() {
        house.setColor("Blue");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
