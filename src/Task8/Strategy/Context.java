package Task8.Strategy;

public class Context {
    private Strategy strategy;
    public Context (Strategy s){
        this.strategy = s;
    }
    public int execute(int x, int y){
        return strategy.mathOperation(x, y);
    }
}
