public class StackArray implements Stack {
    private Object[] stack;
    private int top;

    public StackArray(int size) {
        stack = new Object[size];
        top = -1;
    }

    @Override
    public void push(Object value) {
        if (isFull()) {
            throw new ArrayStoreException("is full");
        }
        stack[++top] = value;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("is empty");
        }
        return stack[top--];
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("is empty");
        }
        return stack[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public void show() {
        System.out.print("[");
        for (int i = 0; i < stack.length; i++) {
            if (i != stack.length-1) {
                System.out.print(i + "=>" + stack[i] + ", ");
            }else {
                System.out.print(i + "=>" + stack[i]);
            }
        }
        System.out.println("]");
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }
}
