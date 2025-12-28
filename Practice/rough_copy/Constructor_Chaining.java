class A {
    A() {
        System.out.print("A ");
    }
}

class B {
    A a = new A();
    B() {
        System.out.print("B ");
    }
}

public class Constructor_Chaining {
    public static void main(String[] args) {
        new B();
    }
}
