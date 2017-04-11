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

        //������ int, ������ ����� �������������� � ������ Integer
        doSomething(i);

        List<Long> list = new ArrayList<Long>();
        //������������ ������������ ���� � ��������������� �����-��������
        list.add(l);
    }

    private static void doSomething(Integer in){
        //����������, �� ����� ���������� Integer.intValue()
        int j = in;

        //����������: ���������� Integer, ��� �������� int
        doPrimitive(in);
    }

    private static void doPrimitive(int i) {

    }
}
