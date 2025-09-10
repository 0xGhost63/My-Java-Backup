import java.util.Scanner;

class Employee
{
    String name;
    private int salary;  // encapsulated salary
    public int id;

    // Constructor me salary hata di
    Employee(String name, int id)
    {
        this.id = id;
        this.name = name;
    }

    // Setter
    void setSalary(int salary)
    {
        this.salary = salary;
    }

    // Getter
    int getSalary()
    {
        return salary;
    }

    void showData()
    {
        System.out.printf("\nThe name of the employee is : %s", name);
        System.out.printf("\nThe salary of the employee is : %d", salary);
        System.out.printf("\nThe id of the employee is : %d", id);
    }
}

public class GetterSetter 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n============ Welcome to the Employee Management System ============");
        System.out.print("Enter the name of the employee : ");
        String name = sc.nextLine();

        System.out.print("Enter the id of the employee : ");
        int id = sc.nextInt();

        // Object create kiya salary ke bagair
        Employee E1 = new Employee(name, id);

        System.out.print("Enter the salary of the Employee : ");
        int salary = sc.nextInt();
        E1.setSalary(salary);   // salary set using setter

        System.out.println("\n===== Results =====");
        E1.showData();

        // Salary use via getter
        System.out.println("\nSalary = " + E1.getSalary());

        sc.close();
    }
}
