import java.util.*;


public class Generic_Array
{
    public static <T> void printArray(T [] array)
    {
        for (T element : array)    
        {
            System.out.print(element+" ");
        }
        System.out.print(System.lineSeparator());
    }

    public static void main(String[] args) 
    {
        Integer [] Array = {1,2,3,4,5,6,7,8,9,10};
        printArray(Array);

        Integer [] a1 = Array.clone();

        printArray(a1);
        
    }
}

