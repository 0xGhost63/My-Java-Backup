class ExecutionDemo
{
    static
    {
        System.out.println("\nStatic block");
    }

    {
        System.out.println("\nInstance block");
    }

    ExecutionDemo()
    {
        System.out.println("\nConstructor");
    }

    public static void main(String[] args)
    {
        System.out.println("\nMain method");

        ExecutionDemo obj1 = new ExecutionDemo();
        ExecutionDemo obj2 = new ExecutionDemo();
    }
}
 