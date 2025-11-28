/*In this coding exercise i learnt that how to 
make the multiple objects from the class
both by using the direct method and the
constructor method */

import java.util.Scanner;
class Car {
    String name;
    int model;
    boolean isAutomatic;

    Car(String name, int model, boolean isAutomatic) {
        
        this.name = name;
        this.model = model;
        this.isAutomatic = isAutomatic;
    }

    void printInfo() {
        System.out.println("--------------------------------------------");
        System.out.println("The car's name is : " + name);
        System.out.println("The car's model is : " + model);
        if (isAutomatic)
            System.out.println("The car is automatic");
        else
            System.out.println("The car isn't automatic...its manual :)");
        System.out.println("--------------------------------------------");

    }
}

public class Main {
    public static void main(String[] args) {
        // METHOD : 1
        // Car c1=new Car();
        // c1.name="BMW";
        // c1.model=2024;
        // c1.isAutomatic=false;
        // c1.printInfo();

        // Method : 2
        Scanner sc = new Scanner(System.in);
        int loop;
        System.out.println("How many car's info would you like to Enter ?");
        loop = sc.nextInt();
        sc.nextLine();
        Car[] cars = new Car[loop];
        int model;
        String name;
        boolean isAutomatic;
        for (int i = 0; i < loop; i++) {
            
            System.out.print("Enter the name of car #" + (i + 1) + ": ");
            name = sc.nextLine();

            System.out.print("Enter the model of car #" + (i + 1) + ": ");
            model = sc.nextInt();
            sc.nextLine(); // consume newline after int

            System.out.print("Is car automatic? (true/false): ");
            isAutomatic = sc.nextBoolean();
            sc.nextLine(); // consume newline after boolean

            // Car Creation
            cars[i] = new Car(name, model, isAutomatic);

        }
        System.out.println("The details of the car's are as follows :");
        for (int i = 0; i < loop; i++) {
            cars[i].printInfo();

        }

    }

}
