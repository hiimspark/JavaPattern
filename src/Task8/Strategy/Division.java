package Task8.Strategy;

public class Division implements Strategy{
    @Override
    public int mathOperation(int x, int y) {
        if (y==0){
            System.out.println("Division by zero.");
            return 0;
        }
        return x / y;
    }
}
