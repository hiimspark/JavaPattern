package Task6.Factory;

public class Main {
    public static void main(String[] args) {
        ConcreteCreator factory = new ConcreteCreator();
        Product concrete = factory.factoryMethod();
        concrete.print();
    }
}
