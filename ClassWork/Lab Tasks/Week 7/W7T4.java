class Employee
{
    // Attributes

    String name;
    double salary;

    // Constructor

    Employee(String name,double salary)
    {
        this.name=name;
        this.salary=salary;
    }

    // Method
    void showDetails()
    {
        System.out.printf("Name : %s %16s : %.2f\n",this.name,"Salary",this.salary);
    }
}

class Manager extends Employee
{
    // Attribute
    String department;

    // Constructor
    Manager(String name,double salary,String department)
    {
        super(name, salary);
        this.department=department;
    }

    // Overrided Method
    @Override
    void showDetails()
    {
        System.out.printf("Name : %s %15s : %.2f  %15s : %s \n",this.name,"Salary",this.salary,"Department",this.department);
    }


}
class SeniorManager extends Manager
{
    // Attribute
    String performanceRating ;

    //Constructor
    SeniorManager(String name,double salary,String department,String performanceRating)
    {
        super(name, salary, department);
        if(this.salary>100000)
        {
            this.performanceRating=performanceRating;
        }
        else
        {
            this.performanceRating="Performance rating not available !";
        }
    }

    //Overrided Method
    @Override
    void showDetails()
    {
        System.out.printf("Name : %s %15s : %.2f  %15s : %s %20s : %s\n",this.name,"Salary",this.salary,"Department",this.department,"Performance Rating",this.performanceRating);
    }


}
public class W7T4 
{
    public static void main(String[] args) 
    {
        // Emloyee : 

        Employee e1=new Employee("Ali", 5000);
        e1.showDetails();

        // Manager : 
        Manager m1 = new Manager("John", 10000, "HR");
        m1.showDetails();

        // Senior Manager : 
        SeniorManager s1 = new SeniorManager("Asad",90000,"Finance","Good");
        s1.showDetails();

        //Senior Manager - valid performance
        SeniorManager s2 = new SeniorManager("Asim",150000,"Finance","Excellent");
        s2.showDetails();

        

    }
}
