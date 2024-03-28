package Task8.Strategy;

public class Main {
    public static void main(String[] args) {
        Context context = new Context(new Addition());
        System.out.println("Addition: " + context.execute(1,2));

        context = new Context(new Subtraction());
        System.out.println("Subtraction: " + context.execute(5,2));

        context = new Context(new Multiplication());
        System.out.println("Multiplication: " + context.execute(5,2));

        context = new Context(new Division());
        System.out.println("Division: " + context.execute(6,2));

        context = new Context(new Power());
        System.out.println("Power: " + context.execute(6,2));


    }
}
