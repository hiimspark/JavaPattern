package Task4;

public class Main {
    public static void main(String[] args) {
        MyExecutorService executorService = new MyExecutorService(3);
        executorService.execute(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("We run it");
        });

        executorService.execute(() -> System.out.println("Ready"));
        executorService.execute(() -> System.out.println("Set"));
        executorService.execute(() -> System.out.println("Go"));
        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I sleep");
        });
        executorService.shutdown();
    }
}