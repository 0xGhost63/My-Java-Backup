import java.util.Scanner;
class Person
{
    Protected String name;

    //Getter & Setters
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    //Constructor -01
    Person(String name)
    {
        setName(name);
    }

    //Constructor -02

    Person()
    {
        this.name="Unknown"
    }
}

// Student Class inheriting from the person class (super/parent class)
class Student extends Person
{ 
    //Attributes !
    private static int totalStudents = 0;
    private int[][] marks; 
    private double average;


    //Getters and setters

    public void setMarks(int[][] marks) 
    {
        this.marks = marks;
    }
    public int[][] getMarks() 
    {
        return marks;
    }


    //Constructor Overloading

    Student () // Default Constructore created for students array (in main)
    {

    }

    Student(String name,int [][] marks)
    {
        super(name);
        this.marks=marks;
        totalStudents++;
    }

    Student (String name)
    {
        super(name);
        totalStudents++;
    }
       
    //Methods Overloading !
    double calculateAverage ()
    {
        int [][] tempMarks=getMarks();
        double average=0;
        int sum=0;
        int numberOfMarks=0;

        for (int row =0 ;i<tempMarks.length;row++)
        {
            for(int coloumn=0;j<tempMarks[row].length;coloumn++)
            {
                sum+=tempMarks[row][coloumn];
                numberOfMarks++;
            }
        }
        average=sum/numberOfMarks;

        return average;
    }

    double calculateAverage (int specificSubject)
    {
        int [][] tempMarks= getMarks();
        int sum=0;
        int numberOfMarks;
        double average=0;


        for(int i = 0;i<1;i++)
        {
            for(int coloumn =0;tempMarks[specificSubject].length;coloumn++)
            {
                sum+=tempMarks[specificSubject][coloumn];
                numberOfMarks++;
            }
        }

        average=sum/numberOfMarks;
        return average;
    }

    static void getStudents()
    {
        System.out.printf("The number of total registered students are : %d",totalStudents);
    }

    //Incomplete Method---> will be completed after the completing
    //The main class
    static void topper(Student [] allStudents)
    {
        double highestAverage=0;
        int topper=0;



        for (int i = 0;i<allStudents.length;i++)
        {
            int studentNumber=1;
            if (calculateAverage(i)>highestAverage)
            {
                highestAverage=calculateAverage(i);
                topper=studentNumber;
            }
        }

        System.out.println("The topper among all students is : "+ allStudents [topper-1]);
        System.out.println("With an overall average of : "+highestAverage);
    }
}

public class GradeAnalyzer
{
    //Change it to show the data of all students 
    static void showAllStudents()
    {
        System.out.print("Total number of studens are : "+totalStudents);

    }
    public static void main(String[] args) 
    {
        //Scanner Object Creation
        Scanner sc=new Scanner(System.in);

        //Variables and Arrays
        int  numberOfStudents;
        System.out.print("How many students would you like to Enter : ");
        numberOfStudents=sc.nextInt();

        Student [] students=new Student();


        System.out.println("=====Welcome====");

        for (int i=0;i<students.length;i++)
        {
            int studentNumber=1;
            //Individual variables of the each Student 
            String name;
            int numberOfSubjects;


            System.out.println("Enter the name of student %d ",%studentNumber);
            name=sc.nextLine();
            System.out.printf("How many subjects do the Student %d have ? ",numberOfSubjects);
            numberOfSubjects=sc.nextInt();
            int [][] marks = new int [numberOfSubjects][];

            for (int j =0;j<numberOfSubjects;j++)
            {
                int subjectCounter=1;
                int tempColoumn=0;

                System.out.printf("How many entries for the subject # %d : ",subjectCounter);
                tempColoumn=sc.nextInt();
                marks [numberOfStudents]=new marks [temp;]
                subjectCounter++;
            }

            for(int row=0;row<marks;row++)
            {
                int subject=1;
                for(int coloumn=0;coloumn<marks[row].length;coloumn++)
                {
                    int entry=1;
                    int numberOfEntries=marks[row].length;
                    numberOfEntries-=(marks[row].length)+1;
                    System.out.printf("Enter the marks for Entry # %d of the subject # %d : ",entry,subject);
                    marks[row][coloumn]=sc.nextInt();
                    entry++;
                }
                subject++;
            }

            students[i]=new Student(name,marks)
            studentNumber++;

        }



        System.out.println("====================");
        topper(students);
    }
    
}
