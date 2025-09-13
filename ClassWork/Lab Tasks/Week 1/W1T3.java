import java.util.Scanner;

class Car
{
    String brand;
    String colour;
    float mileage;
    int model;
    int wheeler;
    boolean isManual;

    // Constructor
    Car(String brand, String colour, float mileage, int model, int wheeler, boolean isManual)
    {
        this.brand = brand;
        this.colour = colour;
        this.mileage = mileage;
        this.model = model;
        this.wheeler = wheeler;
        this.isManual = isManual;
    }

    // Methods
    void start()
    {
        System.out.println("The car has been started successfully!");
    }

    void brake()
    {
        System.out.println("The brake has been applied, speed decreased.");
    }

    void accelerate()
    {
        System.out.println("Be cautious! The speed has been increased.");
    }

    void handBrake()
    {
        System.out.println("Hand-Brake applied successfully.");
    }

    void headLights()
    {
        System.out.println("Headlights turned ON, now you can see clearly.");
    }

    void indicators()
    {
        System.out.println("Indicators activated.");
    }

    void sportsMode()
    {
        System.out.println("Sports mode ACTIVATED!");
    }

    void economyMode()
    {
        System.out.println("Economy mode activated, fuel consumption reduced.");
    }

    void turnOff()
    {
        System.out.println("The car is switched off... Hope you enjoyed the journey :)");
    }

    void showInfo()
    {
        System.out.println("\n=== Car Information ===");
        System.out.println("Brand: " + this.brand);
        System.out.println("Model: " + this.model);
        System.out.println("Colour: " + this.colour);
        System.out.println("Wheeler: " + this.wheeler);
        System.out.printf("Mileage: %.2f km/l%n", this.mileage);

        if (isManual)
        {
            System.out.printf("The %s is Manual%n", this.brand);
        }
        else
        {
            System.out.printf("The %s is Automatic%n", this.brand);
        }
    }
}

public class W1T3
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Taking car details
        System.out.println("Welcome to your car :)");
        System.out.print("Enter the brand/company of your car: ");
        String brand = sc.nextLine();

        System.out.print("What's the colour of your car? ");
        String colour = sc.next();

        System.out.print("Enter the mileage of the car: ");
        float mileage = sc.nextFloat();

        System.out.print("Enter the model: ");
        int model = sc.nextInt();

        System.out.print("Is your car 4 wheeler or 2 wheeler? ");
        int wheeler = sc.nextInt();

        System.out.print("Is your car Manual? (true/false): ");
        boolean isManual = sc.nextBoolean();

        Car c1 = new Car(brand, colour, mileage, model, wheeler, isManual);
        boolean carOn = false;

        // Menu loop
        while (true)
        {
            System.out.println("\n=== Available Operations ===");
            System.out.println("1 - Start the Car");
            System.out.println("2 - Accelerate the Car");
            System.out.println("3 - Apply the Brake");
            System.out.println("4 - Apply the Hand-Brake");
            System.out.println("5 - Turn on the Indicators");
            System.out.println("6 - Turn on the Head-Lights");
            System.out.println("7 - Activate the Sports-Mode");
            System.out.println("8 - Activate the Eco-Mode");
            System.out.println("9 - Turn off the Car & Exit");
            System.out.println("10 - Show Info about the Car!");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    if (!carOn)
                    {
                        c1.start();
                        carOn = true;
                    }
                    else
                    {
                        System.out.println("The car is already ON.");
                    }
                    break;

                case 2:
                    if (carOn) c1.accelerate();
                    else System.out.println("Start the car first!");
                    break;

                case 3:
                    if (carOn) c1.brake();
                    else System.out.println("Start the car first!");
                    break;

                case 4:
                    if (carOn) c1.handBrake();
                    else System.out.println("Start the car first!");
                    break;

                case 5:
                    if (carOn) c1.indicators();
                    else System.out.println("Start the car first!");
                    break;

                case 6:
                    if (carOn) c1.headLights();
                    else System.out.println("Start the car first!");
                    break;

                case 7:
                    if (carOn) c1.sportsMode();
                    else System.out.println("Start the car first!");
                    break;

                case 8:
                    if (carOn) c1.economyMode();
                    else System.out.println("Start the car first!");
                    break;

                case 9:
                    if (carOn)
                    {
                        c1.turnOff();
                        carOn = false;
                    }
                    else
                    {
                        System.out.println("The car is already OFF.");
                    }
                    System.out.println("Exiting the program... Goodbye!");
                    return; // Exit program

                case 10:
                    c1.showInfo();
                    break;

                default:
                    System.out.println("Invalid Operation Selected :(");
                    break;
            }
        }
    }
}

/* 
✅ Fixes applied:

carOn is now checked inside the switch instead of blocking all operations.

Case 9 now properly shuts down the car.

Removed duplicated case 10 mistake.

Show info (case 10) works without needing the car to be ON.

Mileage printing fixed (%.2f).

*/