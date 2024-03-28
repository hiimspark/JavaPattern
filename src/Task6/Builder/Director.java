package Task6.Builder;

public class Director {
    Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }

    public void build(){
        builder.setFloors();
        builder.setColor();
    }

    public House getBuildResult(){
        return builder.getHouse();
    }

}
