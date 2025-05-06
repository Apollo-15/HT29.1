package app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Employee {
    private int id;
    private String name;
    private int age;
    private String position;
    private float salary;


    public Employee(String name, int age, String position, float salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }
}