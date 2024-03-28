package Task5;

public class LazySingleton {
    private static LazySingleton instance;
    private int value;
    private LazySingleton() {}
    public static synchronized LazySingleton getInstance() {
        if(instance == null) {
            instance = new LazySingleton();
            return instance;
        }
        return instance;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
