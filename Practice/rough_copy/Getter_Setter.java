class Employee
{
    private int password;
    int ID;
    

    // SET ---> INPUT
    // GET ---> OUTPUT
    
    public void setID(int iD)
    {
        this.ID = iD;
    }

    public void setPassword(int password)
    {
        this.password=password;
    }

    public int getID() 
    {
        return ID;
    }

    public int getPassword() 
    {
        return password;
    }

    // default constructor
    Employee()
    {

    }

    Employee(int ID,int password)
    {
        System.out.println("THE CONSTRUCTOR WITH TWO PARAMETERS IS CALLED ");

        setID(ID);
        setPassword(password);
    }

    Employee(int password)
    {
        System.out.println("THE CONSTRUCTOR WITH ONE PARAMETER IS CALLED ");
        this.password=password;
    }

        void showinfo()
        {
            System.out.println("The id of employee is : "+this.ID);
            System.out.println("the password of the employee is : "+ getPassword());
        }

    
}



public class Getter_Setter 
{
    public static void main(String[] args) 
    {
        Employee e1 = new Employee(123);
        Employee e2 = new Employee(01,456);
        Employee e3 = new Employee();

        e1.showinfo();
        e2.showinfo();
        e3.showinfo();

        
    }
    
}
