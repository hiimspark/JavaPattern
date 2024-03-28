package Task6.Factory;

public class ConcreteProduct implements Product {
    @Override
    public void print() {
        System.out.println("This is made of concrete.");
    }
}
