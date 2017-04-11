package stacks;

/**
 * @author Anton Koksharov
 *         Date: 24.01.2017
 */
public class Stack {

    private int mSize;
    private int[] stackArray;
    private int top;

    public Stack(int m) {
        this.mSize = m;
        stackArray = new int[mSize];
        top = -1;
    }

    public void push(int element) {
        stackArray[++top] = element;
    }

    public int pop() {
        return stackArray[top--];
    }

    public int deleteElement() {
        int value = stackArray[top];
        stackArray[top] = 0;
        top = top - 1;
        return value;
    }

    public int readTop() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return top == (mSize - 1);
    }

    public boolean isEmptyThroughLength() {
        return stackArray.length == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int aStackArray : stackArray) {
            stringBuilder.append(aStackArray).append(" ");
        }

        return stringBuilder.toString();
    }
}
