/**
 * @author Anton Koksharov
 *         Date: 17.09.2015
 */
public class ConIn {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConIn(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConIn conIn = (ConIn) o;

        return id.equals(conIn.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
