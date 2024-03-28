package Task7.Decorator;

public class Main {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Component decorator = new ConcreteDecorator(component);
        decorator.operation();
    }
}
