package Generics;

/**
 * @author Anton Koksharov
 *         Date: 25.01.2017
 */
public class GenericsInheritance {
    public static void main(String[] args) {
        String str = "abc";
        Object object = new Object();
        object = str;

        MyClass<String> myClass1 = new MyClass<String>();
        MyClass<Object> myClass2 = new MyClass<Object>();
//        myClass2 = myClass1; // не скомпилируетс€, так как MyClass<String> не €вл€етс€ MyClass<Object>
        object = myClass1; // MyClass<T> наследник Object
    }

    public static class MyClass<T>{}
}
