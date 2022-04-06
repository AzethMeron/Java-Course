/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4;

/**
 *
 * @author meron
 */

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
    
    private static String GetRandomName(ArrayList<String> names)
    {
        final int index = randomGenerator.nextInt(names.size());
        return names.get(index);
    }
    
    private static String GetRandomSurname(ArrayList<String> names)
    {
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
        ArrayList<String> names = new ArrayList<>();
        names.add("Jagoda");
        names.add("Eliza");
        names.add("Harold");
        names.add("Levi");
        names.add("Samuel");
        names.add("Igor");
        names.add("Ewelina");
        names.add("MUNDO"); 
        ArrayList<String> surnames = new ArrayList<>();
        surnames.add("Spirit");
        surnames.add("Orzeszkowa");
        surnames.add("Ackermann");
        surnames.add("Ortega");
        surnames.add("Light");
        surnames.add("Zawicki");
        surnames.add("Nerina");
        this.setName(GetRandomName(names));
        this.setSurname(GetRandomSurname(surnames));
        this.setAge(GetRandomNum(18,24));
        this.setSalary(GetRandomNum(10, 10000));
    }
    
    Person(ArrayList<String> names, ArrayList<String> surnames, int minAge, int maxAge, int minSalary, int maxSalary)
    {
        this.setName(GetRandomName(names));
        this.setSurname(GetRandomSurname(surnames));
        this.setAge(GetRandomNum(minAge,maxAge));
        this.setSalary(GetRandomNum(minSalary, maxSalary));
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
    
    public String ToString()
    {
        return String.format("%s %s %d %d\n", this.getName(), this.getSurname(), this.getAge(), this.getSalary());
    }
    
    public static Person FromString(String text) throws Exception
    {
        String output[] = text.split(" ");
        String name = (String) output[0];
        String surname = (String) output[1];
        int age = Integer.parseInt(output[2]);
        int salary = Integer.parseInt(output[3]);
        return new Person(age, name, surname, salary);
    }
}