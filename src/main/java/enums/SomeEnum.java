package enums;

/**
 * @author Anton Koksharov
 *         Date: 05.05.2016
 */
public enum SomeEnum {
    A("A-1"),
    B("B-2"),
    C("C-3");

    private String title;

    SomeEnum(String text) {
        this.title = text;
    }

    public String getTitle() {
        return title;
    }
}
