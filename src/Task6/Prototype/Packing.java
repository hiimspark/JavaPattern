package Task6.Prototype;

public class Packing implements Cloneable {
    public void print() {
        System.out.println("New packing");
    }

    @Override
    public Packing clone() throws CloneNotSupportedException {
        return (Packing) super.clone();
    }
}
