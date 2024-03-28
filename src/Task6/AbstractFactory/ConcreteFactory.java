package Task6.AbstractFactory;

public class ConcreteFactory implements AbstractFactory{
    @Override
    public AbstractProduct createProductA() {
        return new ConcreteProductA();
    }

    @Override
    public AbstractProduct createProductB() {
        return new ConcreteProductB();
    }
}
