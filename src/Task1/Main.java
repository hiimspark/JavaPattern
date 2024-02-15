package Task1;

import java.util.Comparator;

public class Main {

    public static String comparisonResult(int R){
        if (R==1){
            return "первый массив больше второго";
        }
        else{
            return "второй массив больше первого";
        }
    }

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {4, 5, 6, 7};
        Integer[] array3 = {8, 9};
        String[] array4 = {"a","b","c"};
        String[] array5 = {"d","e","f","j"};
        String[] array6 = {"h","i"};

        Comparator<Integer[]> intComparator = Comparator.comparingInt(arr -> arr.length);
        Comparator<String[]> charComparator = Comparator.comparingInt(arr -> arr.length);

        System.out.println("Сравнение array1 и array2: " + comparisonResult(intComparator.compare(array1, array2)));
        System.out.println("Сравнение array2 и array3: " + comparisonResult(intComparator.compare(array2, array3)));
        System.out.println("Сравнение array3 и array1: " + comparisonResult(intComparator.compare(array3, array1)));
        System.out.println("Сравнение array4 и array5: " + comparisonResult(charComparator.compare(array4, array5)));
        System.out.println("Сравнение array4 и array6: " + comparisonResult(charComparator.compare(array4, array6)));
        System.out.println("Сравнение array6 и array5: " + comparisonResult(charComparator.compare(array6, array5)));

    }
}