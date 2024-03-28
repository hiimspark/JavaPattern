package Task6.AbstractFactory;

public class Client {
    private final AbstractProduct productA;
    private final AbstractProduct productB;
    public Client(AbstractFactory factory){
        productA = factory.createProductA();
        productB = factory.createProductB();
    }
    public void print(){
        productA.print();
        productB.print();
    }
}
