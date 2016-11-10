import org.apache.commons.lang3.StringUtils;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {
    public static final String DATE_PATTERN_SHORT = "dd.MM.yy";
    public static final String DATE_PATTERN = "dd.MM.yyyy";
    public static final String DATE_TIME_FORMAT = "dd.MM.yyyy HH:mm";

    private static final String REGEX_DATE_FORMAT_SHORT = "[0-9]{2}.[0-9]{2}.[0-9]{2}";
    private static final String REGEX_DATE_FORMAT = "[0-9]{2}.[0-9]{2}.[0-9]{4}";

    public static enum FullDatePart	{DATE, HOURS, MINUTES}

    public static Date toDayBeginning(Date date) {
        if (date == null) {
            return null;
        }

        Calendar clnd = Calendar.getInstance();
        clnd.setTime(date);
        clnd.set(Calendar.HOUR_OF_DAY, 0);
        clnd.set(Calendar.MINUTE, 0);
        clnd.set(Calendar.SECOND, 0);
        clnd.set(Calendar.MILLISECOND, 0);
        return clnd.getTime();
    }

    public static Date newDate(int day, int month, int year) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("wrong day:" + day);
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("wrong month:" + month);
        }
        if (year < 1970 || year > 292278994) {
            throw new IllegalArgumentException("wrong year:" + year);
        }
        switch (month) {
            case 2:
                int maxDay = new GregorianCalendar().isLeapYear(year) ? 29 : 28;
                if (day > maxDay) {
                    throw new IllegalArgumentException("wrong day:" + day);
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) {
                    throw new IllegalArgumentException("wrong day:" + day);
                }
                break;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static boolean isDayBeginning(Date date) {
        if (date == null)
            return false;
        return date.getTime() == toDayBeginning(date).getTime();
    }

    public static Date toDayEnd(Date date) {
        if (date == null) {
            return null;
        }

        Date tmpDate = toDayBeginning(date);
        Calendar clnd = Calendar.getInstance();
        clnd.setTime(tmpDate);
        clnd.add(Calendar.MILLISECOND, -1);
        clnd.add(Calendar.DATE, 1);
        return clnd.getTime();
    }

    public static Date toMonthBeginning(Date date) {
        if (date == null)
            return null;
        Calendar clnd = Calendar.getInstance();
        clnd.setTime(date);
        clnd.set(Calendar.DAY_OF_MONTH, 1);
        return clnd.getTime();
    }

    public static Date toMonthEnd(Date date) {
        if (date == null)
            return null;
        Calendar clnd = Calendar.getInstance();
        clnd.setTime(date);
        clnd.set(Calendar.MONTH, 1);
        clnd.set(Calendar.DAY_OF_MONTH, 1);
        clnd.add(Calendar.DAY_OF_MONTH, -1);

        Date endOfMonth = clnd.getTime();
        return toDayEnd(endOfMonth);
    }

    public static Integer getMonth(Date date) {
        if (date == null)
            return null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static Integer getYear(Date date) {
        if (date == null)
            return null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static String dateFormat(final Date date) {
        return null != date ? new SimpleDateFormat(DATE_PATTERN).format(date) : "";
    }

    public static String dateFormat(final Date date, final String pattern) {
        return null != date ? new SimpleDateFormat(pattern).format(date) : "";
    }

    public static String dateFormatRu(final Date date, final String pattern) {
        return null != date ? new SimpleDateFormat(pattern, new Locale("ru", "RU")).format(date) : "";
    }

    public static Date dateFormat(final String date, final String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(date);
        }
        catch(ParseException e) {
            throw new RuntimeException("Can't parse date");
        }
    }

    public static Date dateFormat(final String date) {
        try {
            return new SimpleDateFormat(DATE_PATTERN).parse(date);
        }
        catch(ParseException e) {
            throw new RuntimeException("Can't parse date");
        }
    }

    public static Date toDate(String date) {
        if (StringUtils.isNotEmpty(date)) {
            if (matchPattern(date, REGEX_DATE_FORMAT_SHORT)) {
                return dateFormat(date, DATE_PATTERN_SHORT);
            }

            if (matchPattern(date, REGEX_DATE_FORMAT)) {
                return dateFormat(date, DATE_PATTERN);
            }
        }
        return null;
    }

    private static boolean matchPattern(String value, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public static Date formatStartDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date formatEndDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static Date addDays(Date date, int amount) {
        if (date == null) {
            return null;
        }

        return org.apache.commons.lang3.time.DateUtils.addDays(date, amount);
    }

    public static Map<Integer, String> getLocalizedMonthNames() {
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(new Locale("ru", "RU"));
        String[] monthNames = dateFormatSymbols.getMonths();
        Map<Integer, String> localizedMonthNames = new HashMap<Integer, String>();
        int monthIndex = 1;
        for (int i = 0; i < monthNames.length - 1; i++) {
            localizedMonthNames.put(monthIndex, monthNames[i]);
            monthIndex++;
        }
        return localizedMonthNames;
    }

    public static int getTimeZoneOffset(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int offset = (c.get(Calendar.ZONE_OFFSET) + c.get(Calendar.DST_OFFSET)) / (60 * 1000);
        return offset;
    }

    public static String formatTimeZoneOffset(final int offsetMinutes) {
        int minutes;
        boolean positive;
        if (offsetMinutes >= 0) {
            minutes = offsetMinutes;
            positive = true;
        } else {
            minutes = - offsetMinutes;
            positive = false;
        }
        int h = minutes / 60;
        int m = minutes % 60;
        StringBuilder sb = new StringBuilder();
        if (positive) {
            sb.append("+");
        } else {
            sb.append("-");
        }
        sb.append(h);
        if (m != 0) {
            sb.append(":");
            if (m < 10) {
                sb.append("0");
            }
            sb.append(m);
        }
        return sb.toString();
    }

    public static Set getSystemYears(int currentYear) {
        Set<Integer> years = new HashSet<Integer>();
        for (int year = currentYear - 1; year < currentYear + 3; year++) years.add(year);
        return years;

    }

    public static Date assembleDate(Date dateOnly, Integer hours, Integer minutes)
    {
        if (dateOnly == null || hours == null || minutes == null)
        {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOnly);
        calendar.set(Calendar.HOUR_OF_DAY, NumberUtils.normalize(hours));
        calendar.set(Calendar.MINUTE, NumberUtils.normalize(minutes));
        return calendar.getTime();
    }

    public static Map<FullDatePart, Object> dissembleDate(Date fullDate) {
        Map<FullDatePart, Object> result = new HashMap<FullDatePart, Object>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fullDate);
        result.put(FullDatePart.DATE, toDayBeginning(fullDate));
        result.put(FullDatePart.HOURS, calendar.get(Calendar.HOUR_OF_DAY));
        result.put(FullDatePart.MINUTES, calendar.get(Calendar.MINUTE));
        return result;
    }


    public static Date stringToDate(String date, String pattern) {
        try {
            if (date == null || pattern == null) {
                return null;
            }
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date getTime(Date date, Integer hours, Integer minutes) {
        if (hours == null || minutes == null || date == null) {
            return date;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, NumberUtils.normalize(hours));
        calendar.set(Calendar.MINUTE, NumberUtils.normalize(minutes));
        return calendar.getTime();
    }

    public static long getDiffInDays(Date day1, Date day2) {
        long diff = Math.abs(day1.getTime() - day2.getTime());
        return TimeUnit.MILLISECONDS.toDays(diff);
    }
}