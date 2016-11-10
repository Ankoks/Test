/**
 * @author Anton Koksharov
 *         Date: 13.11.2015
 */

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class Parser {

    static String ROWS_NAME = "CODE, IS_ACTUAL, LAST_UPDATE_DATE, NODELEVEL, NAME, OKPD_ID, PARENT_ID, START_DATE_ACTIVE, DATEUTV, END_DATE_ACTIVE";

    public static String parse(String name) throws IOException, InterruptedException {

        FileWriter writer = new FileWriter("C:\\AKoksharov\\INSERTS.txt", false);

        StringBuilder sb = new StringBuilder();

        String result = "";
        InputStream in = null;
        HSSFWorkbook wb = null;
        try {
            in = new FileInputStream(name);
            wb = new HSSFWorkbook(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            sb.append("INSERT INTO FZ223_NSI.NSI_OKPD").append(" (").append(ROWS_NAME).append(") ").append("VALUES").append(" (");
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                int cellType = cell.getCellType();
                switch (cellType) {
                    case Cell.CELL_TYPE_STRING:
                        sb.append("'" + cell.getStringCellValue() + "'").append(", ");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        sb.append("'" + cell.getStringCellValue() + "'").append(", ");
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        sb.append("'" + cell.getNumericCellValue() + "'").append(", ");
                        break;
                    default:
//                        result += "|";
                        break;
                }
            }
            sb.append("sysdate, sysdate, sysdate)\n");

            writer.write(sb.toString());
            sb = new StringBuilder();
        }

        System.out.println(sb.toString());

        return result;
    }
}