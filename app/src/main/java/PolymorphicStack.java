/**
 * A stack which uses subtype polymorphism.
 */
public class PolymorphicStack {
    private final Object[] elements;
    private int top;

    public PolymorphicStack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        elements = new Object[size];
        top = -1;
    }

    public void push(Object value) {
        if (isFull()) {
            throw new StackFullException("Polymorphic stack is full");
        }
        elements[++top] = value;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new StackEmptyException("PolymorphicStack is empty");
        }
        return elements[top--];
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top == elements.length - 1;
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

    public static void main(String[] args) {
        PolymorphicStack stackInt = new PolymorphicStack(5);

        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(4);
        System.out.println(stackInt);

        int a = (Integer) stackInt.pop();
        int b = (Integer) stackInt.pop();
        System.out.println(a + b);
        System.out.println(stackInt);

        PolymorphicStack stackDouble = new PolymorphicStack(4);

        stackDouble.push(10.2);
        stackDouble.push(11.1);
        System.out.println(stackDouble);

        PolymorphicStack stackUniversal = new PolymorphicStack(6);

        stackUniversal.push(1);
        stackUniversal.push(2.0);
        stackUniversal.push(true);
        stackUniversal.push("Hello");
        stackUniversal.push(new PolymorphicStack(0));
        System.out.println(stackUniversal);
    }
}
