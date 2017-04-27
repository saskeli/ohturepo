package ohtu;

import java.util.*;

class Undo implements Command {
    private ArrayDeque<Integer> stack;
    public Undo() {
        stack = new ArrayDeque<>();
    }

    @Override
    public int execute(int input) {
        if (stack.isEmpty()) {
            return 0;
        }
        stack.pop();
        return get();
    }
    
    public int add(int value) {
        stack.push(value);
        return value;
    }
    
    public int get() {
        return stack.isEmpty() ? 0 : stack.peek();
    }
}
