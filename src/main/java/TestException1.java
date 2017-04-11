import java.io.IOException;

/**
 * @author Anton Koksharov
 *         Date: 23.01.2017
 */
public class TestException1 {

    static int someMethod() {
        try {
            methodWithException();
            return 1;
        } catch (IOException e) {
            return 2;
        } catch (Exception e) {
            return 3;
        }
    }

    private static int methodWithException() throws IOException {
        throw new IOException();
    }
}
