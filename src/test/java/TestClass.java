import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.functors.NotNullPredicate;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

/**
 * @author Anton Koksharov
 *         Date: 09.09.2015
 */
public class TestClass {

    public TestClass() {
        super();
    }

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static void main(String[] args) throws TransformerException, SQLException, ClassNotFoundException, IOException, InterruptedException, ParseException, CloneNotSupportedException {

        System.out.println(DateUtils.toDayBeginning(new Date()));
        System.out.println(DateUtils.toDayEnd(new Date()));

    }

    private static void chunkWork() {
        List<Long> list = new ArrayList<Long>();

        for (int i = 1; i <= 3; i++) {
            list.add((long) i);
        }

        for (List<Long> chunkList : Lists.partition(list, 8)) {
            System.out.println(chunkList);
        }
    }

    private static boolean relativeDifferenceBigger(BigDecimal target, BigDecimal candidate, BigDecimal difference) {
        BigDecimal lowerBound = target.subtract(target.multiply(difference));
        BigDecimal upperBound = target.add(target.multiply(difference));
        return candidate.compareTo(lowerBound) < 0 || candidate.compareTo(upperBound) > 0;
    }

    public static void rangeList( List<Integer> ids) {
        for (int index = 0; index < ids.size();) {
            int nextIndex = index + 50 < ids.size() ? index + 50 : ids.size();
            System.out.println("возьмутся элементы в диапозоне [" + index + ", " + nextIndex + ")");
            action(ids.subList(index, nextIndex));
            index = nextIndex;
        }
    }

    public static void action(List<Integer> list) {
        System.out.println(list);
//        System.out.println(list.size());
    }

    public static void someMEthod(int a, String... str) {
        System.out.println("this method number: " + a);
        System.out.println("str.length = " + str.length);
        System.out.println("str.toString() = " + str.toString());
        if (str.length != 0) {
            for (String string : str) System.out.println(string);
        }

    }

    public static void workWithGenerics() {
        List list = new ArrayList();
        list.add("abc");
        list.add(new Integer(5)); //OK

        for (Object obj : list) {
//            String str = (String) obj; //здесь приведение типов бросит ClassCastException
            if (obj instanceof String) {
                String str = (String) obj;
                System.out.println(str);
            } else if (obj instanceof Integer) {
                Integer num = (Integer) obj;
                System.out.println(num);
            }
        }
    }

    public static void workWithStack() {
        int[] stackArray = new int[4];
//        for (int i = 0; i < stackArray.length; i++) {
//            stackArray[i] = i*2;
//        }

        stackArray[0] = 1;
        stackArray[1] = 3;
        stackArray[3] = 9;

        System.out.println(stackArray.length);
        System.out.println(stackArray[1]);

        //==============================================================================================================
        stacks.Stack mStack = new stacks.Stack(10);

        mStack.push(79);
        mStack.push(59);
        mStack.push(35);
        mStack.push(24);

        mStack.deleteElement();

        System.out.println("stacks.Stack: ");
        while (!mStack.isEmpty()) {
            int value = mStack.pop();
            System.out.print(value);
            System.out.print(" ");
        }

        System.out.println("\nstack size is " + mStack);
    }

    public static Date toDate(XMLGregorianCalendar date) {
        if (date == null) {
            return null;
        }
        return date.toGregorianCalendar().getTime();
    }

    public static <T> T nvl(T nullable1, T nullable2, T... fallBacks) {
        T res = nullable1 != null ? nullable1 : nullable2;
        if (res == null && ArrayUtils.isNotEmpty(fallBacks)) {
            res = (T) CollectionUtils.find(Arrays.asList(fallBacks), NotNullPredicate.getInstance());
        }

        return res;
    }

    private static int fib(int i) {
        if (i == 1) return 1;
        if (i == 2) return 1;
        return fib(i - 1) + fib(i - 2);
    }

    public static String method() {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            return "NPE";
        } finally {
            return "Finally message";
        }
    }

    private static boolean hasSelectionDiff(Boolean... values) {
        return new HashSet<Boolean>(Arrays.asList(values)).size() != 1;
    }

    private static String transformXml(String xml, Transformer transformer) throws TransformerException {
        // Transform the source XML to System.out.
        StringWriter writer = new StringWriter();
        transformer.transform(new StreamSource(new StringReader(xml)), new StreamResult(writer));
        return writer.toString();
    }

    private static String msg(String str1, Integer int1) {
        str1.concat("-123");
        return "1";
    }

    public static <E> Set<E> symmetricDifference(Set<E> set1, Set<E> set2) {
        Set<E> notInSetA = new HashSet<E>(set2);
        notInSetA.removeAll(set1);
        Set<E> notInSetB = new HashSet<E>(set1);
        notInSetB.removeAll(set2);
        Set<E> symmetricDifference = new HashSet<E>(notInSetA);
        symmetricDifference.addAll(notInSetB);
        return symmetricDifference;
    }

    private static Date getStartDateNewCodeUse() {
        Calendar startDateNewCodeUse = Calendar.getInstance();
        startDateNewCodeUse.set(2016, 0, 1);
        startDateNewCodeUse.set(Calendar.HOUR_OF_DAY, 0);
        startDateNewCodeUse.set(Calendar.MINUTE, 0);
        startDateNewCodeUse.set(Calendar.SECOND, 0);
        startDateNewCodeUse.set(Calendar.MILLISECOND, 0);
        return startDateNewCodeUse.getTime();
    }


    public static void parseXmlThroughXslt(File xsltFile, File xmlFile, File resultFile) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();

        Source xsl = new StreamSource(xsltFile);
        Templates template = factory.newTemplates(xsl);
        Transformer transformer = template.newTransformer();

        Source xml = new StreamSource(xmlFile);
        Result result = new StreamResult(resultFile);
        transformer.transform(xml, result);
    }

    private void connectMethod() throws SQLException {
        ArrayList<String> list = new ArrayList<String>();

        list.add("1");
        list.add("2");

        String URL = "jdbc:oracle:thin:@192.168.159.128:1521:gmudb";
        String USER = "system";
        String PASS = "system";
        Connection con = DriverManager.getConnection(URL, USER, PASS);

        PreparedStatement statement = con.prepareStatement("UPDATE FZ223_PPA.AGENCY SET SPZ_CODE = 'x' WHERE id IN (" + StringUtils.join(list, ',') + ")");

        statement.executeUpdate();
        statement.close();
    }
}
