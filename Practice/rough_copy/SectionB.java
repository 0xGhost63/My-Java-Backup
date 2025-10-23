import java.util.Scanner;

// Parent class
class CarbonFootPrintEntity
{
    public double getCERO()
    {
        return 0.0;
    }
}

// House class extending the parent class
class House extends CarbonFootPrintEntity
{
    private double coveredArea;

    public House(double coveredArea)
    {
        this.coveredArea = coveredArea;
    }

    public double getCoveredArea()
    {
        return coveredArea;
    }

    public void setCoveredArea(double coveredArea)
    {
        this.coveredArea = coveredArea;
    }

    @Override
    public double getCERO()
    {
        return coveredArea * 0.005;
    }
}

// Car class extending the parent class
class Car extends CarbonFootPrintEntity
{
    private double milesDriven;

    public Car(double milesDriven)
    {
        this.milesDriven = milesDriven;
    }

    public double getMilesDriven()
    {
        return milesDriven;
    }

    public void setMilesDriven(double milesDriven)
    {
        this.milesDriven = milesDriven;
    }

    @Override
    public double getCERO()
    {
        return milesDriven * 0.0000292;
    }
}

public class SectionB
{
    public static void main (String[] args)
    {
        // Name and registration info
        System.out.printf("%-20s : %14s\n", "Name", "Sannan Ahmad");
        System.out.printf("%-20s : %15s\n", "Registration", "SP25-BSE-118");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        // Object creation
        House house = new House(2000);
        Car car = new Car(15000);

        // Initial outputs
        System.out.println("House Carbon Footprint: " + house.getCERO() + " tons of CO2 per year");
        System.out.println("Car Carbon Footprint: " + car.getCERO() + " tons of CO2 per year");

        // Updating values
        house.setCoveredArea(2500);
        car.setMilesDriven(12000);

        System.out.println("\nUpdated House Carbon Footprint: " + house.getCERO());
        System.out.println("Updated Car Carbon Footprint: " + car.getCERO());

        // User input
        System.out.print("\nEnter covered area: ");
        house.setCoveredArea(sc.nextDouble());

        System.out.print("Enter miles driven: ");
        car.setMilesDriven(sc.nextDouble());

        // Final results
        System.out.println("\nAfter Input values:");
        System.out.println("Updated House Carbon Footprint: " + house.getCERO());
        System.out.println("Updated Car Carbon Footprint: " + car.getCERO());
    }
}
