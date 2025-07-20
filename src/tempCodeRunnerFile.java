import java.util.Arrays;

public class Stack {
    private int top;
    private int maxSize;
    private Object[] stackArray;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new Object[maxSize];
        top = -1;
    }

    public void push(Object value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push element.");
            return;
        }
        stackArray[++top] = value;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return null;
        }
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    // Digunakan untuk print isi stack
    public Object[] getContents() {
        Object[] content = new Object[top + 1];
        for (int i = 0; i <= top; i++) {
            content[i] = stackArray[i];
        }
        return content;
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    @Override
    public String toString() {
        return "Stack: " + Arrays.toString(stackArray);
    }
}