package classes;

/**
 * @author Anton Koksharov
 *         Date: 28.03.2017
 */
public class Node {

    private Node next;
    private int value;

    public Node(int value, Node next) {
        this.next = next;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void getString(Node node) {
        if (node.next == null) {
            System.out.println(" " + node.value);
        } else {
            System.out.print(" " + node.value);
            getString(node.next);
        }
    }

    public static Node referse(Node node) {
        Node second = node.next;
        Node third = second.next;

        node.next = null;
        second.next = node;

        Node current = third;
        Node prev = second;

        while (current != null) {
            Node next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }
}
