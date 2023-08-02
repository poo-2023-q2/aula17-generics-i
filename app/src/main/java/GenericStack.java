/**
 * A generic size-limited stack, implemented with parametric polymorphism.
 * It uses unchecked types for simplicity purposes
 */
public class GenericStack<T> {
    private final T[] elements;
    private int top;

    @SuppressWarnings("unchecked")
    public GenericStack(int size){
        if (size < 0) {
            throw new IllegalArgumentException("Size must positive");
        }
        elements = (T[]) new Object[size]; // workaround for generic arrays
        top = -1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    public int size() {
        return top + 1;
    }

    public T peek() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty. No element to show");
        }
        return elements[top];
    }

    public void push(T value) {
        if (isFull()) {
            throw  new StackFullException(String.format("Stack is full with %d elements", top + 1));
        }
        elements[++top] = value;
    }

    public T pop() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        return elements[top--];
    }

    public void clear() {
        while (!isEmpty())
            pop();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i <= top; i++) {
            sb.append(elements[i]);
            if (i < top)
                sb.append(",");
        }
        sb.append("]");

        return sb.toString();
    }

}
