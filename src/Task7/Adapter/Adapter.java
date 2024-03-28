package Task7.Adapter;

public class Adapter implements Target {
    private Adaptee adaptee;
    public Adapter(Adaptee a){
        this.adaptee = a;
    }
    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
