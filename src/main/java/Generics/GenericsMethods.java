package Generics;

/**
 * @author Anton Koksharov
 *         Date: 25.01.2017
 */
public class GenericsMethods {

    public static <T> boolean isEqual(GenericType<T> g1, GenericType<T> g2) {
        return g1.get().equals(g2.get());
    }

    public static void main(String[] args) {
        GenericType<String> g1 = new GenericType<String>();
        g1.set("Pro");

        GenericType<String> g2 = new GenericType<String>();
        g2.set("Str");

        boolean isEqual = GenericsMethods.<String>isEqual(g1, g2);

        isEqual = GenericsMethods.isEqual(g1, g2);

        System.out.println(isEqual);

    }
}
