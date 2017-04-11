package Generics;

/**
 * @author Anton Koksharov
 *         Date: 24.01.2017
 */
public class GenericType <T> {
    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        GenericType<String> type = new GenericType<String>();
        type.set("Str");

        GenericType type1 = new GenericType();
        type1.set("Str");
        type1.set(10);
    }
}
