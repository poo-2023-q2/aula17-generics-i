import java.util.ArrayList;

/**
 * A generic dynamic stack, implemented with parametric polymorphism.
 * It uses a size-dynamic ArrayList to avoid unchecked type warnings.
 */
public class GenericDynamicStack<T> {
    private final ArrayList<T> elements;

    public GenericDynamicStack(){
        elements = new ArrayList<>();
    }

    public boolean isEmpty() {
        return elements.size() == 0;
    }

    public int size() {
        return elements.size();
    }

    public T peek() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty. No element to show");
        }
        return elements.get(elements.size() - 1);
    }

    public void push(T value) {
        elements.add(value);
    }

    public T pop() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        return elements.remove(elements.size() - 1);
    }

    public void clear() {
        while (!isEmpty())
            pop();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < elements.size(); i++) {
            sb.append(elements.get(i));
            if (i < elements.size() - 1)
                sb.append(",");
        }
        sb.append("]");

        return sb.toString();
    }

}
