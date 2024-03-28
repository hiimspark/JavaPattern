package Task5;

public class Main {
    public static void main(String[] args) {
        LazySingleton lazyStn = LazySingleton.getInstance();
        lazyStn.setValue(5);
        System.out.println(lazyStn.getValue());
        EnumSingleton enumStn = EnumSingleton.getInstance();
        enumStn.setValue(7);
        System.out.println(enumStn.getValue());
        EagerSingleton eagerStn = EagerSingleton.getInstance();
        eagerStn.setValue(9);
        System.out.println(eagerStn.getValue());
    }
}
