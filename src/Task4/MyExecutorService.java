package Task4;
import java.util.concurrent.*;


public class MyExecutorService {
    ExecutorService executorService;

    public MyExecutorService(int threadsNum) {
        executorService = Executors.newFixedThreadPool(threadsNum);
    }

    public void shutdown() {
        executorService.shutdown();
    }

    public boolean isShutdown() {
        return executorService.isShutdown();
    }

    public boolean isTerminated() {
        return executorService.isTerminated();
    }

    public void execute(Runnable command) {
        executorService.execute(command);
    }
}
