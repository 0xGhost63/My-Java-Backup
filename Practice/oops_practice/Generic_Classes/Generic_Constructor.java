class EmployeeAbsentToday 
{

    <T> EmployeeAbsentToday (T employee)
    {
        System.out.printf("Employee : %s , is absent today\n",employee);
    }

}
public class Generic_Constructor 
{
    public static void main(String[] args) 
    {
        EmployeeAbsentToday e1 = new EmployeeAbsentToday("Sixty-Three");
        EmployeeAbsentToday e2 = new EmployeeAbsentToday(63);

    }    
}
