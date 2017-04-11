package classes;

/**
 * @author Anton Koksharov
 *         Date: 25.01.2017
 */
public class ClassWithComposition {
    SuperCLass obj = null;

    public ClassWithComposition(SuperCLass obj) {
        this.obj = obj;
    }

    public void test() {
        obj.doSomething();
    }

    public static void main(String[] args) {
        ClassWithComposition obj1 = new ClassWithComposition(new ClassA());
        ClassWithComposition obj2 = new ClassWithComposition(new ClassB());

        obj1.test();
        obj2.test();

    }
}
