import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class Salat implements Comparable <Salat>
{
    private String name;
    private LocalTime time;
    private int numbersOfFarz;
    private int numbersOfSunnah;

    Salat(String name,LocalTime time,int numbersOfFarz,int numbersOfSunnah)
    {
        setName(name);
        setTime(time);
        setNumbersOfFarz(numbersOfFarz);
        setNumbersOfSunnah(numbersOfSunnah);
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setNumbersOfFarz(int numbersOfFarz) {
        this.numbersOfFarz = numbersOfFarz;
    }
    public void setNumbersOfSunnah(int numbersOfSunnah) {
        this.numbersOfSunnah = numbersOfSunnah;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
    
    //getters
    public String getName() {
        return name;
    }
    public int getNumbersOfFarz() {
        return numbersOfFarz;
    }
    public int getNumbersOfSunnah() {
        return numbersOfSunnah;
    }


    //method implementing the compare to function of the Comparable interface
    @Override
    public int compareTo(Salat that)
    {
        return this.time.compareTo(that.time);
    }

    @Override
    public String toString()
    {
        int hours,minutes,seconds,hours12;
        hours=time.getHour();
        minutes=time.getMinute();
        seconds=time.getSecond();
        String AMPM = (hours>=12) ? "PM" : "AM";
        hours12 = (hours > 12) ? hours-12 : hours;
        if (hours==0)
        {
            hours12=12;    
        }

        return String.format("%-7s has %d Farz,%d Sunnah and is held at %02d:%02d:%02d %s",this.getName(),this.getNumbersOfFarz(),this.getNumbersOfSunnah(),hours12,minutes,seconds,AMPM);

    }
    
}



public class SP25_BSE_118
{
    public static void main(String[] args) 
    {
        ArrayList <Salat> Namaz = new ArrayList<>();

        Namaz.add(new Salat("Maghrib",LocalTime.of(17, 15, 15), 3, 2));   
        Namaz.add(new Salat("Zuhr",LocalTime.of(12, 45, 30), 4, 6));   
        Namaz.add(new Salat("Asar",LocalTime.of(15, 50, 25), 4, 4));   
        Namaz.add(new Salat("Fajar",LocalTime.of(5, 30, 10), 2, 2));    
        Namaz.add(new Salat("Isha",LocalTime.of(18, 30, 12), 4, 6)); 

        System.out.printf("\n%55s\n","=======    UNSORTED SALATS DATA     =======");
        for (Salat salat : Namaz)
        {
            System.out.println(salat.toString());
        }

        //Sorting by time(using the comparable interface and collections class)
        System.out.printf("\n%55s\n","=======    ACCORDING TO TIME     =======");
        Collections.sort(Namaz);
        
        for (Salat salat : Namaz)
        {
            System.out.println(salat.toString());
        }
        
        //name Sorting using lambda notation of the comparator
        System.out.printf("\n%55s\n","=======    ACCORDING TO NAME     =======");

        Comparator <Salat> nameComparator = (Salat salat_1,Salat salat_2) -> salat_1.getName().compareTo(salat_2.getName());
        Namaz.sort(nameComparator);

        for (Salat salat : Namaz)
        {
            System.out.println(salat.toString());
        }

        //farz Comparator (using the detailed multi-lines comparator)

        System.out.printf("\n%55s\n","=======    ACCORDING TO NUMBER OF FARZ     =======");

        Comparator <Salat> farzComparator = new Comparator<Salat>() 
        {
            public int compare(Salat s1, Salat s2) 
            {
                if(s1.getNumbersOfFarz()>s2.getNumbersOfFarz())
                return 1;
                else if(s1.getNumbersOfFarz()<s2.getNumbersOfFarz())
                return -1;
                else
                return s1.getName().compareTo(s2.getName());
            };
            
        };

        Namaz.sort(farzComparator);

        for (Salat salat : Namaz)
        {
            System.out.println(salat.toString());
        }

        //sorting by the numbers of Sunnah
        System.out.printf("\n%55s\n","=======    ACCORDING TO NUMBER OF SUNNAH     =======");
        Comparator <Salat> sunnahComparator = (Salat salat_1 , Salat salat_2) -> 
        (salat_1.getNumbersOfSunnah()==salat_2.getNumbersOfSunnah()) ? salat_1.getName().compareTo(salat_2.getName()) : salat_1.getNumbersOfSunnah()-salat_2.getNumbersOfSunnah();

        Namaz.sort(sunnahComparator);

        for (Salat salat : Namaz)
        {
            System.out.println(salat.toString());
        }

    }    
}
