package Task6.Builder;

public class House {
    private int floors;
    private String color;

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "House{" +
                "floors=" + floors +
                ", color='" + color + '\'' +
                '}';
    }
}
