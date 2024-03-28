package Task5;

public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    private int value;
    private EagerSingleton(){}
    public static EagerSingleton getInstance(){
        return instance;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
