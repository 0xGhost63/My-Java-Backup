class Heart
{
    void pump()
    {
        System.out.println("Heart is pumping...");
    }
}

class Human
{
    // Composition: heart is PART of human
    private Heart heart = new Heart();

    void live()
    {
        heart.pump();
        System.out.println("Human is alive!");
    }
}

public class Composition
{
    public static void main(String[] args)
    {
        Human h = new Human();
        h.live();

    }
}
