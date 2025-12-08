public class GenericStudent<T, U>
{
    public class Address
    {
        private U address;

        public Address(U address)
        {
            this.address = address;
        }

        public U getAddress()
        {
            return this.address;
        }
    }

    private T roll;
    private String name;
    private Address address;

    public GenericStudent(T roll, String name, Address address)
    {
        this.roll = roll;
        this.name = name;
        this.address = address;
    }

    public T getRoll()
    {
        return this.roll;
    }

    public String getName()
    {
        return this.name;
    }

    public Address getAddress()
    {
        return this.address;
    }

    public static void main(String[] args)
    {
        // Step 1: Create outer class instance first
        GenericStudent<String, String> temp = new GenericStudent<>("123", "Dummy", null);

        // Step 2: Create inner class object via outer instance
        GenericStudent<String, String>.Address s1_adr = temp.new Address("NYC");

        // Step 3: Create main object with correct Address
        GenericStudent<String, String> s1 = new GenericStudent<>("Chaar Soo Bees", "Notty Boy", s1_adr);
    }
}
