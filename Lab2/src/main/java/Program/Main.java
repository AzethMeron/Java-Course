package Program;

public class Main {
    public static void main(String[] args) {
        // Person class task
        People p = new People(12);
        p.sortBySalary();
        p.reverse();
        
        System.out.println(p);
        System.out.println(p.selectSalary(5000).averageSalary());
    }
}
