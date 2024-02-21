package Task3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Проверка SafeList:");
        SafeList<Integer> safeList = new SafeList<>();
        Thread thread1 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    safeList.add(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                for (int i = 5; i < 10; i++) {
                    safeList.add(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        for (int i = 0; i < safeList.size(); i++) {
            System.out.println("Element at index " + i + ": " + safeList.get(i));
        }

        System.out.println("\nПроверка SafeMap:");
        SafeMap<String, Integer> safeMap = new SafeMap<>();
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                safeMap.put("Key" + i, i);
            }
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 5; i < 10; i++) {
                safeMap.put("Key" + i, i);
            }
        });
        thread3.start();
        thread4.start();
        thread3.join();
        thread4.join();
        for (int i = 0; i < 10; i++) {
            String key = "Key" + i;
            if (safeMap.containsKey(key)) {
                System.out.println("Value for key " + key + ": " + safeMap.get(key));
            } else {
                System.out.println("Key " + key + " not found");
            }
        }
    }
}
