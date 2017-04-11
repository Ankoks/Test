package threads;

/**
 * @author Anton Koksharov
 *         Date: 25.01.2017
 */
public class WaitNotifyTest {

    public static void main(String[] args) {
        Message msg = new Message("handle");

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter_1").start();

        Waiter waiter2 = new Waiter(msg);
        new Thread(waiter2, "waiter_2").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();

        System.out.println("Started all threads!");
    }
}