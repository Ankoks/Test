package stacks;

import java.util.Stack;

/**
 * @author Anton Koksharov
 *         Date: 23.01.2017
 */
class GenericStack <E> {
    Stack<E> stk = new Stack<E>();
    public void push(E obj) {
        stk.push(obj);
    }

    public E pop() {
        E obj = stk.pop();
        return obj;
    }
}

class Output {
    static void pushInteger(GenericStack gs) {
        gs.push(36);
    }

    public static void main(String[] args) {
        GenericStack <String> gs = new GenericStack<String>();
        gs.push("Hello");
        System.out.println(gs.pop() + " ");
        pushInteger(gs);
        System.out.println(gs.pop());
    }
}
