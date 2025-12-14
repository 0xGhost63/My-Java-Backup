import java.util.ArrayList;
import java.util.Iterator;

interface VIP_Memberr{}

class Memberr
{
    String name;
    int age;

    public Memberr(String name,int age) 
    {
        this.name=name;
        this.age=age;
    }    
}

class SpecialMemberr extends Memberr implements VIP_Memberr
{
    public SpecialMemberr(String name,int age) 
    {
        super(name, age);
    }       
}

class RegulaMember extends Memberr
{
    public RegulaMember(String name,int age) 
    {
        super(name, age);
    }       
}

class temporaryMember extends Memberr
{
    public temporaryMember(String name,int age) 
    {
        super(name, age);
    }       
}

class PoliticalFigure extends Memberr implements VIP_Memberr
{
    public PoliticalFigure(String name,int age) 
    {
        super(name, age);
    }   
}
public class MarkerInterface 
{
    public static void main(String[] args) 
    {
        ArrayList<Memberr> list = new ArrayList<>();

        list.add(new RegulaMember("Ali",21));  
        list.add(new PoliticalFigure("Sannan",19));  
        list.add(new temporaryMember("Ali",22));  
        list.add(new SpecialMemberr("Ahmad",23));  


        Iterator <Memberr> it = list.iterator();

        while(it.hasNext())
        {
            Memberr currentMember = it.next();
            if(currentMember instanceof VIP_Memberr)
            {
                System.out.println("Welcome VIP , sir !");
            }
            else
            {
                System.out.println("Access not granted");
            }
        }


          
    }
    
}
