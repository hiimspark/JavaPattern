package Task10.src.main.java;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SortingApp {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: gradle run --args''Sorting_Algorithm''");
            return;
        }

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        SortingAlgorithm algorithm = (SortingAlgorithm) context.getBean(args[0]);

        algorithm.doSort();
    }
}
