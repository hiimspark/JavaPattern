package Task10.src.main.java;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean("Merge_Sort")
    public MergeSort mergeSort() {
        return new MergeSort();
    }

    @Bean("Insertion_Sort")
    public InsertionSort insertionSort() {
        return new InsertionSort();
    }

    @Bean("Quick_Sort")
    public QuickSort quickSort() {
        return new QuickSort();
    }
}
