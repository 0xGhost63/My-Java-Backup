import java.time.LocalTime;
class Time
{
    private int hour;
    private int min;
    private int sec;

    public int getHour() 
    {
        return hour;
    }
    public void setHour(int hour) 
    {
        if(!(hour>24))
        {
            this.hour = hour;
        }
        else
        {
            System.out.println("Invalid Hour ! Max 24 hours are allowed");
            System.out.println("Switching to default 00 ....");
            this.hour=00;
        }
    }
    public int getMin() 
    {
        return min;
    }
    public void setMin(int min) 
    {
        if (!(min>60))
        {
            this.min=min;
        }
        else
        {
            System.out.println("Invalid Minutes ! Max 60 Minutes are allowed");
            System.out.println("Switching to default 00 ....");
            this.min=00;
        }
    }
    public int getSec() 
    {
        return sec;
    }
    public void setSec(int sec)
    {
        if (!(sec>60))
        {
            this.sec=sec;
        }
        else
        {
            System.out.println("Invalid Seconds ! Max 60 Seconds are allowed");
            System.out.println("Switching to default 00 ....");
            this.sec=00;
        }
    }
    Time(int hour, int min, int sec)
    {
        // validate and set
        setHour(hour);  
        setMin(min);    
        setSec(sec);    
    }

    Time()
    {
        System.out.println("Object without UN-PARAMETERIZED constructor created ! ");
    }

    void showTime()
    {
        System.out.println("The time is : ");
        System.out.printf("%02d : %02d : %02d\n",this.hour,this.min,this.sec);
    }
    



}
public class W2T5 
{
    public static void main(String[] args) 
    {
        LocalTime abhi = LocalTime.now();

        Time T1=new Time(7,2,3);
        Time T2=new Time();
        T2.setHour(12);
        T2.setMin(34);
        T2.setSec(43);
        T1.showTime();
        T2.showTime();
        System.out.println("Although,the local time is : "+abhi);
        
    }
    
}
