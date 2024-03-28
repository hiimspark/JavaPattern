package Task7.Decorator;

public class ConcreteDecorator extends Decorator{
    ConcreteDecorator(Component c){
        super(c);
    }

    private void addedBehavior(){
        System.out.println("Added behavior.");
    }
    @Override
    public void operation() {
        super.operation();
        addedBehavior();
    }
}
