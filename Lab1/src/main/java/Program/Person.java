package Program;

public class Person {
    private int age;
    private String name;
    private String surname;
    
    private void setAge(int age) { this.age = age; }
    public int getAge() { return this.age; }
    
    private void setName(String name) { this.name = name; }
    public String getName() { return this.name; }
    
    private void setSurname(String surname) { this.surname = surname; }
    public String getSurname() { return this.surname; }
    
    Person(int age, String name, String surname)
    {
        this.setAge(age);
        this.setName(name);
        this.setSurname(surname);
    }
    
    @Override public String toString()
    {
        return String.format("======\nName: %s\nSurname: %s\nAge: %d", this.getName(), this.getSurname(), this.getAge());
    }
    
    private Person() {}
}