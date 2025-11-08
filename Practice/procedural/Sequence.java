class GrandParent
{

    GrandParent()
    {
        System.out.println("Grand-Parent class constructor called !");
    }




}

class Parent extends GrandParent
{

    Parent()
    {
        System.out.println("Parentclass constructor called !");
    }



}


class Children extends Parent
{

    Children()
    {
        System.out.println("Children constructor called !");
    }



}

public class Sequence 
{
    public static void main(String[] args)
    {
        Children s1 = new Children(); 

    }
}
