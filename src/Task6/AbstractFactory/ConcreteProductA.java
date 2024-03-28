package Task6.AbstractFactory;

public class ConcreteProductA implements AbstractProduct{
    @Override
    public void print() {
        System.out.println("This is made of concrete. (A)");
    }
}
