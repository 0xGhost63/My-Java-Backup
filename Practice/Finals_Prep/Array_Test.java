class A {
    A() {
        System.out.print("A ");
    }
}

public class Array_Test {
    public static void main(String[] args) {
        A[] arr = new A[3];
        arr[0] = new A();
        arr[2] = new A();
        System.out.println(arr[1]);
    }
}
