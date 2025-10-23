package Java.Practice.rough_copy;

public class Person
{
    String name;
    int age;
    int familyMembers;

    public Person(String name, int age, int familyMembers)
    {
        this.name = name;
        this.age = age;
        this.familyMembers = familyMembers;
    }

    public void SayHi()
    {
        System.out.println("Hi I am : " + this.name);
    }

    @Override
    public String toString()
    {
        return "Name: " + name + ", Age: " + age + ", Family Members: " + familyMembers;
    }
}
