package Task7.Decorator;

public abstract class Decorator implements Component{
    protected Component component;
    Decorator(Component c){
        this.component = c;
    }
    public void operation(){
        component.operation();
    }
}
