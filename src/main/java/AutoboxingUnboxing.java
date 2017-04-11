import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton Koksharov
 *         Date: 25.01.2017
 */
public class AutoboxingUnboxing {

    public static void main(String[] args) {
        int i = 5;
        long l = 105l;

        //пришел int, значит будет преобразование в объект Integer
        doSomething(i);

        List<Long> list = new ArrayList<Long>();
        //автоупаковка примитивного типа в соответствующий класс-оболочку
        list.add(l);
    }

    private static void doSomething(Integer in){
        //распаковка, во время выполнения Integer.intValue()
        int j = in;

        //распаковка: передается Integer, где ожидался int
        doPrimitive(in);
    }

    private static void doPrimitive(int i) {

    }
}
