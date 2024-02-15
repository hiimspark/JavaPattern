package Task1;

import java.util.Comparator;

public class NewComparator<T> implements Comparator<T[]> {

    @Override
    public int compare(T[] arr1, T[] arr2) {
        return Integer.compare(arr1.length, arr2.length);
    }
}

