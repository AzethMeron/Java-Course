package Program;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Hello world
        String userWindows = System.getenv("USERNAME");
        System.out.println("Hello there " + userWindows);
        
        // Person class task
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(24, "Jakub", "Grzana"));
        personList.add(new Person(17, "Aubron", "Phivyre"));
        personList.add(new Person(28, "Elred", "Qikrana"));
        personList.add(new Person(21, "Naevys", "Qiren"));
        personList.add(new Person(23, "Filverel", "Nerina"));
        for(Person p : personList) { System.out.println(p); }
        
        // Trinomial task
        Trinomial t = new Trinomial(3,-4,5);
        System.out.println(t);
        System.out.println(t.Solution());
    }
}
