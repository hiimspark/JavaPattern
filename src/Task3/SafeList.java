package Task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SafeList<T> {
    private final List<T> list = new ArrayList<>();
    private final Semaphore semaphore = new Semaphore(1);

    public void add(T element) throws InterruptedException {
        semaphore.acquire();
        try {
            list.add(element);
        } finally {
            semaphore.release();
        }
    }

    public T get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }
}
