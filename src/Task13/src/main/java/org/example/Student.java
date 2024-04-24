package org.example;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Value("${student.name}")
    private String name;

    @Value("${student.last_name}")
    private String lastName;

    @Value("${student.group}")
    private String group;

    public void printStudentDetails() {
        System.out.println("Имя: " + name);
        System.out.println("Фамилия: " + lastName);
        System.out.println("Группа: " + group);
    }
}
