package Task8.Strategy;

public class Addition implements Strategy{
    @Override
    public int mathOperation(int x, int y) {
        return x + y;
    }
}
