// Class representing a Student
class Student 
{
    // Attributes
    private String name;
    private int rollNo;

    // Constructor
    public Student(String name, int rollNo) 
    {
        this.name = name;
        this.rollNo = rollNo;
    }

    // Method
    public void getInfo() 
    {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNo);
    }
}

// Class representing a Course
class Course 
{
    // Attributes
    private String courseID;
    private String title;

    // Constructor
    public Course(String courseID, String title) 
    {
        this.courseID = courseID;
        this.title = title;
    }

    // Method
    public void getCourse() 
    {
        System.out.println("Course ID: " + courseID);
        System.out.println("Course Title: " + title);
    }
}

// Main class to test the UML example
public class UMLExample 
{
    public static void main(String[] args) 
    {
        // Create Student object
        Student s1 = new Student("Sannan", 118);

        // Create Course object
        Course c1 = new Course("CS101", "Object-Oriented Programming");

        // Call methods
        s1.getInfo();
        c1.getCourse();
    }
}
