
package Program;

import java.lang.Math;
import java.util.function.Consumer;
import java.util.*;   

public class People {
    private List<Person> personList = new ArrayList<>();
    
    public List<Person> getPersonList() { return this.personList; }
    private void addPerson(Person p) { this.personList.add(p); }
    
    People() {}
    
    People(int n)
    {
        for(int i = 0; i < n; ++i)
        {
            this.addPerson(new Person());
        }
    }
    
    public void sort(Comparator<Person> cmp)
    {
        Collections.sort(this.getPersonList(), cmp);
    }
    
    public void sortByAge()
    {
        this.sort( (p1, p2) -> p1.getAge() - p2.getAge() );
    }
    
    public void sortBySalary()
    {
        this.sort( (p1, p2) -> p1.getSalary()- p2.getSalary() );
    }
    
    public void sortByName()
    {
        this.sort( (p1, p2) -> p1.getName().compareTo(p2.getName()) );
    }
    
    public void sortBySurname()
    {
        this.sort( (p1, p2) -> p1.getSurname().compareTo(p2.getSurname()) );
    }
    
    public void sortByNameAndSurname()
    {
        this.sort( (p1, p2) -> {
            String n1 = String.format("%s %s", p1.getName(), p1.getSurname());
            String n2 = String.format("%s %s", p2.getName(), p2.getSurname());
            return n1.compareTo(n2);
        });
    }
    
    public void reverse()
    {
          Collections.reverse(this.getPersonList());
    }
    
    public People selectFirst(int num)
    {
        int mx = Math.min(num, this.getPersonList().size());
        People ppl = new People();
        for(int i = 0; i < mx; ++i)
        {
            ppl.addPerson(this.getPersonList().get(i));
        }
        return ppl;
    }
    
    public People selectSalary(int salary)
    {
        People ppl = new People();
        this.sortBySalary();
        this.reverse();
        for(Person p : this.getPersonList())
        {
            if(p.getSalary() > salary)
            {
                ppl.addPerson(p);
            }
        }
        return ppl;
    }
    
    public double averageSalary()
    {
        double output = 0;
        for(Person p : this.getPersonList())
        {
            output = output + p.getSalary();
        }
        return output / this.getPersonList().size();
    }
    
    @Override public String toString()
    {
        String output = "";
        for(Person p : this.getPersonList())
        {
            output = output + p + "\n";
        }
        return output;
    }
}
