class ToCopy implements Cloneable
{
    int number;
    
    ToCopy(int number)
    {
        this.number=number;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone(); 
    }
}

public class Clone
{
    public static void main(String[] args) 
    {
        try
        {
            ToCopy original = new ToCopy(63);
            ToCopy copy =(ToCopy) original.clone();
            System.out.println("Original : "+original.number);
            System.out.println("Copy : "+copy.number);

        }        
        catch(CloneNotSupportedException e)
        {
            System.out.println("Error : "+e.getMessage());
        }

    }    
}
