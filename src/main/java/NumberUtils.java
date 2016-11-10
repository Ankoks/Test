import java.math.BigDecimal;

public class NumberUtils {
    public static int normalize(final Integer value) {
        return null == value ? 0 : value;
    }

    public static Long getLong(final String value) {
        try {
            return Long.valueOf(value);
        }
        catch (NumberFormatException n) {
            return null;
        }
    }

    public static BigDecimal getBigDecimal(final String value) {
        return value != null ? new BigDecimal(value.replace(",", ".")) : null;
    }
}