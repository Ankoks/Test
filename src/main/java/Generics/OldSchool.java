package Generics;

/**
 * @author Anton Koksharov
 *         Date: 24.01.2017
 */
public class OldSchool {
    private Object t;

    public Object get() {
        return t;
    }

    public void set(Object t) {
        this.t = t;
    }

    public static void main(String[] args) {
        OldSchool type = new OldSchool();
        type.set("Str");
        Object someObject = type.get();
        String str = (String)type.get();
    }
}
