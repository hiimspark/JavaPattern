package Task6.AbstractFactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory();
        Client client = new Client(factory);
        client.print();
    }
}
