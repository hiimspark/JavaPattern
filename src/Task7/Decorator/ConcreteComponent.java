package Task7.Decorator;

public class ConcreteComponent implements Component{
    @Override
    public void operation() {
        System.out.println("Concrete operation.");
    }
}
