package Program;

import java.lang.*;

import java.util.ArrayList;
import java.security.SecureRandom;

public class Person {
    private int age;
    private int salary;
    private String name;
    private String surname;
    private static SecureRandom randomGenerator = new SecureRandom();
    
    private void setAge(int age) { this.age = age; }
    public int getAge() { return this.age; }
    
    private void setName(String name) { this.name = name; }
    public String getName() { return this.name; }
    
    private void setSurname(String surname) { this.surname = surname; }
    public String getSurname() { return this.surname; }
    
    private void setSalary(int salary) { this.salary = salary; }
    public int getSalary() { return this.salary; }
    
    private static String GetRandomName()
    {
        ArrayList<String> names = new ArrayList<>();
        names.add("Jagoda");
        names.add("Eliza");
        names.add("Harold");
        names.add("Levi");
        names.add("Samuel");
        names.add("Igor");
        names.add("Ewelina");
        names.add("MUNDO");
        final int index = randomGenerator.nextInt(names.size());
        return names.get(index);
    }
    
    private static String GetRandomSurname()
    {
        ArrayList<String> names = new ArrayList<>();
        names.add("Spirit");
        names.add("Orzeszkowa");
        names.add("Ackermann");
        names.add("Ortega");
        names.add("Light");
        names.add("Zawicki");
        names.add("Nerina");
        final int index = randomGenerator.nextInt(names.size());
        return names.get(index);
    }
    
    private static int GetRandomNum(int min, int max)
    {
        final int diff = Math.abs(max - min);
        final int rand_val = randomGenerator.nextInt(diff);
        return min + rand_val;
    }
    
    Person()
    {
        this.setName(GetRandomName());
        this.setSurname(GetRandomSurname());
        this.setAge(GetRandomNum(18,24));
        this.setSalary(GetRandomNum(10, 10000));
    }
    
    Person(int age, String name, String surname, int salary)
    {
        this.setAge(age);
        this.setName(name);
        this.setSurname(surname);
        this.setSalary(salary);
    }
    
    @Override public String toString()
    {
        return String.format("======\nName: %s\nSurname: %s\nAge: %d\nSalary: %d", this.getName(), this.getSurname(), this.getAge(), this.getSalary());
    }
}