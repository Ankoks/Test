package threads;

/**
 * @author Anton Koksharov
 *         Date: 25.01.2017
 */
public class Message {
    // поле, с которым будут работать потоки через вызовы геттеров и сеттеров
    private String msg;

    public Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
