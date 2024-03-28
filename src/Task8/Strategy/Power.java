package Task8.Strategy;

public class Power implements Strategy{
    @Override
    public int mathOperation(int x, int y) {
        int pow = x;
        for (int i = 1;i < y; i++){
            pow = pow * x;
        }
        return pow;
    }
}
