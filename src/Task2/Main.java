package Task2;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human(18,"Max","Caulfield",LocalDate.of(1995,9,21),60));
        humans.add(new Human(16,"Sean","Diaz",LocalDate.of(2000,8,15),80));
        humans.add(new Human(10,"Daniel","Diaz",LocalDate.of(2007,4,11),40));
        humans.add(new Human(21,"Alex","Chen",LocalDate.of(1997,7,10),65));
        System.out.println("Список до фильтрации и сортировки:");
        humans.forEach(System.out::println);
        List<Human> humansGreaterThan20 = humans.stream().filter(human -> human.getAge() > 20).toList();
        System.out.println("Список с возрастом > 20:");
        humansGreaterThan20.forEach(System.out::println);
        List<Human>humansLastLetter = humans.stream().sorted((h1,h2) -> h1.getFirstName().substring(h1.getFirstName().length() - 1).compareTo(h2.getFirstName().substring(h2.getFirstName().length() - 1))).toList();
        System.out.println("Список, отсортированный по последней букве имени:");
        humansLastLetter.forEach(System.out::println);
        List<Human>humansAgePlus3 = humans.stream().peek(h -> h.setAge(h.getAge()+3)).toList();
        System.out.println("Список с возрастом +3:");
        humansAgePlus3.forEach(System.out::println);
        double averageAge = humans.stream()
                .mapToDouble(Human::getAge)
                .average()
                .orElse(0);
        System.out.println("Средний возраст: " + averageAge);
    }


}
