enum Level {
    LOW(1), MID(2), HIGH(3);

    int val;
    Level(int val){ this.val = val; }

    public String toString(){ return "" + val; }
}

public class Enums {
    public static void main(String[] args) {
        System.out.println(Level.MID);
    }
}
