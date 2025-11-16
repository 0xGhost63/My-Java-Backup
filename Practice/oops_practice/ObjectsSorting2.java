/*
 * DEBUGGING LEFT
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student implements Comparable<Student>
{
    private String name;
    private int rollNumber;
    private double GPA;
    private int age;

    Student(String name,int rollNumber,double GPA,int age)
    {
        setName(name);
        setRollNumber(rollNumber);
        setGPA(GPA);
        setAge(age);
    }

    //setters

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setRollNumber(int rollNumber) 
    {
        this.rollNumber = rollNumber;
    }

    public void setAge(int age) 
    {
        if(age>0 && age <70)
        {
            this.age = age;
        }
        else
        {
            System.out.println("Invalid Age !");
        }
    }

    public void setGPA(double GPA) 
    {
        if(GPA>=0.0 && GPA <=4.0)
        {
            this.GPA = GPA;
        }
        else
        {
            System.out.println("Invalid GPA entered !");
        }
    }

    //Getters
    public int getAge() {
        return age;
    }
    public double getGPA() {
        return GPA;
    }
    public String getName() {
        return name;
    }
    public int getRollNumber() {
        return rollNumber;
    }


    @Override
    public int compareTo(Student that)
    {
        return this.getRollNumber()-that.getRollNumber();
    }

    @Override
    public String toString()
    {
        return String.format("%-10s | Roll: %-3d | GPA: %.2f | Age: %-2d", name, rollNumber, GPA, age);
    }

}

public class ObjectsSorting2 
{
    public static void main(String[] args) 
    {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Ali", 105, 3.5, 20));
        students.add(new Student("Zara", 102, 3.9, 19));
        students.add(new Student("Hassan", 108, 3.2, 21));
        students.add(new Student("Ayesha", 101, 3.8, 20));
        students.add(new Student("Bilal", 107, 3.7, 22));
        students.add(new Student("Sara", 103, 3.6, 19));
        students.add(new Student("Omar", 106, 3.4, 20));
        students.add(new Student("Fatima", 104, 3.9, 21));

        Comparator <Student> descendingGPAComparator =(s1,s2) -> Double.compare(s2.getGPA(),s1.getGPA());
        Comparator <Student> ascendingAgeComparator =(s1,s2) -> (s1.getAge()==s2.getAge()) ?  Double.compare(s2.getGPA(),s1.getGPA()) : s1.getAge()-s2.getAge();
        Comparator <Student> nameComparator =(s1,s2) -> (s1.getName().equals(s2.getName())) ? Integer.compare(s1.getRollNumber(), s2.getRollNumber()) : s1.getName().compareTo(s2.getName());

        System.out.println("Unsorted data : ");
        System.out.println();
        for(Student s : students)
        {
            System.out.println(s.toString());
        }
        System.out.println();


        System.out.println("Sory by Roll Number : ");
        Collections.sort(students);
        System.out.println();
        for(Student s : students)
        {
            System.out.println(s.toString());
        }
        System.out.println();


        System.out.println("Sort by descending GPA : ");
        students.sort(descendingGPAComparator);
        System.out.println();
        for(Student s : students)
        {
            System.out.println(s.toString());
        }
        System.out.println();

        System.out.println("Sort by ascending AGE : ");
        students.sort(ascendingAgeComparator);
        System.out.println();
        for(Student s : students)
        {
            System.out.println(s.toString());
        }
        System.out.println();


        System.out.println("Sort by Name : ");
        students.sort(nameComparator);
        System.out.println();
        for(Student s : students)
        {
            System.out.println(s.toString());
        }
        System.out.println();
    }


}
