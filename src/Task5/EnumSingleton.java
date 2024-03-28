package Task5;

public enum EnumSingleton {
    INSTANCE;
    private int value;
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
