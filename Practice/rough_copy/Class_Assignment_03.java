import java.time.LocalTime;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

class Salat implements Comparable<Salat> 
{
    String name;
    LocalTime time;
    int farz;
    int sunnah;

    Salat(String name, LocalTime time, int farz, int sunnah) 
    {
        this.name = name;
        this.time=time;
        this.farz = farz;
        this.sunnah = sunnah;
    }

    @Override
    public int compareTo(Salat that) 
    {
        return this.time.compareTo(that.time);
    }

    @Override
    public String toString() 
    {
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        String ampm = (hour >= 12) ? "PM" : "AM";
        int hour12 = (hour > 12) ? hour - 12 : (hour == 0 ? 12 : hour);

        return String.format("%-8s | Time: %02d:%02d:%02d %s | Farz: %d | Sunnah: %d",name, hour12, minute, second, ampm, farz, sunnah);
    }


}

public class Class_Assignment_03 
{    
    public static void main(String[] args) 
    {
        
        ArrayList<Salat> Namaz = new ArrayList<>();
        Namaz.add(new Salat("Maghrib",  LocalTime.of(17, 15, 15), 3, 2));   
        Namaz.add(new Salat("Zuhr",     LocalTime.of(12, 45, 30), 4, 6));   
        Namaz.add(new Salat("Asar",     LocalTime.of(15, 50, 25), 4, 4));   
        Namaz.add(new Salat("Fajar",    LocalTime.of(5, 30, 10), 2, 2));    
        Namaz.add(new Salat("Isha",     LocalTime.of(18, 30, 12), 4, 6));   



        System.out.println("Unsorted Salats data");
        
        for (Salat s : Namaz)
        {
            System.out.println(s.toString());
        }

        System.out.println("\nSort by time :");
        Collections.sort(Namaz);
        for (Salat s : Namaz)
        {
            System.out.println(s.toString());
        }

        System.out.println("\nSort by name : ");
        Comparator <Salat> timeComparator = (Salat s1,Salat s2) -> s1.name.compareTo(s2.name);
        Namaz.sort(timeComparator);
        for (Salat s : Namaz)
        {
            System.out.println(s.toString());
        }

        System.out.println("\nSort by Farz : ");
        Comparator <Salat> farzComparator = (Salat s1,Salat s2) -> (s1.farz==s2.farz) ? s1.name.compareTo(s2.name) : s1.farz-s2.farz;
        Namaz.sort(farzComparator);
        for (Salat s : Namaz)
        {
            System.out.println(s.toString());
        }


        System.out.println("\nSort by Sunnah : ");
        Comparator <Salat> sunnahComparator = (Salat s1,Salat s2) -> (s1.sunnah==s2.sunnah) ? s1.name.compareTo(s2.name) : s1.sunnah-s2.sunnah;
        Namaz.sort(sunnahComparator);
        for (Salat s : Namaz)
        {
            System.out.println(s.toString());
        }

    }
}