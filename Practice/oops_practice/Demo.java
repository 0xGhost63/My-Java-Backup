import java.util.ArrayList;

class Date 
{
    public int day;
    public int month;
    public int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
}

abstract class Person 
{
    public String name;
    public Date dob;

    public Person(String name, Date dob) {
        this.name = name;
        this.dob = dob;
    }
}

class Employee extends Person
{
    public Employee(String name, Date dob) {
        super(name, dob);
    }
}

public class Demo 
{   
    public static void main(String[] args) 
    { 
        // your code part a
        ArrayList<Person> a1 = new ArrayList<>(); 

        Date d1 = new Date(1, 1, 2001);
        Date d2 = new Date(1, 1, 2001);
        Person p1 = new Employee("Abrar", d1);
        Employee e1 = new Employee("Sannan", d2);

        a1.add(e1);
        a1.add(p1);
        
        System.out.println("Total persons: " + a1.size());
    } 
}