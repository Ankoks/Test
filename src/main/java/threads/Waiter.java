package threads;

/**
 * @author Anton Koksharov
 *         Date: 25.01.2017
 */
public class Waiter implements Runnable {
    private Message msg;

    public Waiter(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        synchronized (msg) {
            try {
                System.out.println(name + " wait call method 'notify' " + System.currentTimeMillis());
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " there was calling method 'notify' " + System.currentTimeMillis());
            System.out.println(name + ": " + msg.getMsg());
        }
    }
}
