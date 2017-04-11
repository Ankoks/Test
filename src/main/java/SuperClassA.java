import enums.SomeEnum;

/**
 * @author Anton Koksharov
 *         Date: 15.03.2016
 */
public class SuperClassA {

    private SomeEnum currentEnum;
    private Integer variable;

    public SomeEnum getCurrentEnum() {
        return currentEnum;
    }

    public void setCurrentEnum(SomeEnum currentEnum) {
        this.currentEnum = currentEnum;
    }

    public Integer getVariable() {
        return variable;
    }

    public void setVariable(Integer variable) {
        this.variable = variable;
    }
}
