import org.apache.commons.lang3.StringUtils;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
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

    public static void main(String[] args) throws TransformerException, SQLException, ClassNotFoundException, IOException, InterruptedException, ParseException {

        System.out.println(method());
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
