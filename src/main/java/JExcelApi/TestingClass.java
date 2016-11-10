package JExcelApi;

import java.io.File;

/**
 * @author Anton Koksharov
 *         Date: 02.12.2015
 */
public class TestingClass {

    ClassLoader classLoader = getClass().getClassLoader();
    String str = classLoader.getResource("templateForChange.xls").getFile();
//    File file = new File(classLoader.getResource("templateForChange.xls").getFile());
    File file = new File(classLoader.getResource("templateForChange.xls").getFile());

    public File getFile() {
//        System.out.println(this.getClass().getResource("src/main/resources/templateForChange.xls"));
        System.out.println(classLoader.getResourceAsStream("templateForChange.xls"));
        return file;
    }

    public String getStr() {
        return str;
    }
}
