import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Time implements Comparable<Time>
{
    int hours;
    int minutes;
    int seconds;
    String AMPM;

    Time(int hours,int minutes,int seconds,String AMPM)
    {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
        setAMPM(AMPM);
    }

    // Setters + Validation !
    public void setHours (int hours)
    {
        if (hours<=12 && hours >=1)
        {
            this.hours=hours;
        }
        else
        {
            System.out.println("Invalid hours !");
        }
    }

    public void setMinutes(int minutes) 
    {
        if (minutes<=59 && minutes >=0)
        {
            this.minutes=minutes;
        }
        else
        {
            System.out.println("Invalid minutes !");
        }    
    }

    public void setSeconds(int seconds) 
    {
        if (seconds<=59 && seconds >=0)
        {
            this.seconds=seconds;
        }
        else
        {
            System.out.println("Invalid seconds !");
        }    
    }

    public void setAMPM(String AMPM) 
    {
        if (AMPM.equalsIgnoreCase("AM") || AMPM.equalsIgnoreCase("PM"))
        {
            this.AMPM = AMPM;
        }
        else
        {
            System.out.println("Invalid AM/PM format ! ");
        }
    }

    // Getters 
    public int getHours() {
        return hours;
    }
    public int getMinutes() {
        return minutes;
    }
    public int getSeconds() {
        return seconds;
    }
    public String getAMPM() {
        return AMPM;
    }

    @Override
    public String toString()
    {
        return String.format("%02d:%02d:%02d %s",this.hours,this.minutes,this.seconds,this.AMPM);
    }

    @Override
    public int compareTo(Time that)
    {
        int thisHours=0;
        int thatHours=0;


        // Coverting AM-PM ---> 24 hr format for easy comparison
        if (this.AMPM.equalsIgnoreCase("AM"))
        {
            thisHours=this.getHours();
        }

        else if (this.AMPM.equalsIgnoreCase("PM"))
        {
            thisHours=(this.getHours())+12;
        }

        // For "that" now 

        if (that.AMPM.equalsIgnoreCase("AM"))
        {
            thatHours=that.getHours();
        }

        else if (that.AMPM.equalsIgnoreCase("PM"))
        {
            thatHours=(that.getHours())+12;
        }


        // Actual Comparison !

        if (thisHours>thatHours)
        {
            return 1;
        }
        else if (thisHours==thatHours)
        {
            if(this.minutes>that.minutes)
            {
                return 1;
            }
            else if(this.minutes<that.minutes)
            {
                return -1;
            }
            else
            {
                if(this.seconds>that.seconds)
                {
                    return 1;
                }
                else if (this.seconds<that.seconds)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }
        }
        else 
        return -1;

    }
}


class Salat implements Comparable <Salat>
{
    String name;
    Time time;
    int numbersOfFarz;
    int numbersOfSunnah;
    
    Salat(String name,int hours,int minutes,int seconds,String AMPM,int numbersOfFarz,int numbersOfSunnah)
    {
        this.name=name;
        this.time=new Time(hours, minutes, seconds,AMPM);
        this.numbersOfFarz=numbersOfFarz;
        this.numbersOfSunnah=numbersOfSunnah;

    }

    @Override 
    public int compareTo(Salat that)
    {     
        return this.time.compareTo(that.time);
    }

    @Override
    public String toString()
    {
        return String.format("%-7s has %d Farz,%d Sunnah and is held at %s",this.name,this.numbersOfFarz,this.numbersOfSunnah,this.time.toString());
    }


}


public class SalatSorting 
{
    public static void main(String[] args) 
    {
        System.out.println("!!!");
        System.out.println("There is a bug in the sorting by time in this code !");
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Sleep Error !");
        }
        ArrayList <Salat> Namaz = new ArrayList<>();


        // Sorting for the Farz numbers
        Comparator<Salat> farzComp = new Comparator<>() 
        {
            public int compare(Salat s1,Salat s2) 
            {
                if (s1.numbersOfFarz>s2.numbersOfFarz)
                {
                    return 63;
                }
                else if  (s1.numbersOfFarz<s2.numbersOfFarz)
                {
                    return -63;
                }
                else 
                {
                    return s1.name.compareTo(s2.name);
                }
            } 
            
        }; 

        // Using Lamda Notation -> Sunnah

        Comparator <Salat> sunnahComparator = (s1,s2) -> (s1.numbersOfSunnah==s2.numbersOfSunnah)? s1.name.compareTo(s2.name) : s1.numbersOfSunnah-s2.numbersOfSunnah;

        // Using lambda Notation for the names

        Comparator <Salat> nameComparator = (s1,s2) -> (s1.name.compareTo(s2.name));

        // Created 5 Objects
        Namaz.add(new Salat("Asar",03,50,25,"PM",4,4));
        Namaz.add(new Salat("Zuhar",12,45,30,"PM",4,6));
        Namaz.add(new Salat("Isha",06,30,12,"PM",4,6));
        Namaz.add(new Salat("Maghrib",05,15,15,"PM",3,2));
        Namaz.add(new Salat("Fajar",05,30,00,"AM",2,2));

        System.out.println();
        System.out.println("Unsorted Prayer's Data :");
        System.out.println();
        for (Salat s : Namaz )
        {
            System.out.println(s.toString());
        }

        System.out.println();
        System.out.println("Sorting by name : ");
        System.out.println();

        Namaz.sort(nameComparator);
        for (Salat s : Namaz )
        {
            System.out.println(s.toString());
        }
        System.out.println();

        System.out.println();
        System.out.println("Sorting by time : ");
        Collections.sort(Namaz);
        System.out.println();


        for(Salat s : Namaz)
        {
            System.out.println(s.toString());
        }

        System.out.println();
        System.out.println("Sorting by Numbers Of Farz");
        Namaz.sort(farzComp);
        System.out.println();
        for(Salat s : Namaz)
        {
            System.out.println(s.toString());
        }
        System.out.println();
        System.out.println("Sorting by Numbers Of Sunnah");
        Namaz.sort(sunnahComparator);
        System.out.println();
        for(Salat s : Namaz)
        {
            System.out.println(s.toString());
        }


    }    
}
