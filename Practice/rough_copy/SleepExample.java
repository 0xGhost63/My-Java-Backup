public class SleepExample {
    public static void main(String[] args) {
        for(int i =0;i<30;i++)
        {
            System.out.print(i+" ");
            try 
            {
                Thread.sleep(1000);  // pauses for 2 seconds
            } 
            catch (InterruptedException e) 
            {
                System.out.println("Sleep interrupted: " + e);
            }
        }



        System.out.println("\nFIN !...");
    }
}
