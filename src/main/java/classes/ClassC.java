package classes;

/**
 * @author Anton Koksharov
 *         Date: 25.01.2017
 */
public class ClassC {
    ClassA objA = new ClassA();
    ClassB objB = new ClassB();

    public void test() {
        objA.doSomething();
    }

    public void methodA() {
        objA.methodA();
    }

    public void methodB() {
        objB.methodB();
    }
}
