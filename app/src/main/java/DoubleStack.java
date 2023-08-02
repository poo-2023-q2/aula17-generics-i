/**
 * A stack that stores double values.
 */
public class DoubleStack {
    private final double[] elements;
    private int top;

    public DoubleStack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        this.elements = new double[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    public void push(double value) {
        if (isFull()) {
            throw new StackFullException(String.format("Stack is full with %d elements", top + 1));
        }
        elements[++top] = value;
    }

    public double pop() {
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

    public static void main(String[] args) {
        DoubleStack doubleStack = new DoubleStack(5);

        // test stack empty verification
        try {
            doubleStack.pop();
        } catch (StackEmptyException e) {
            System.out.println("Stack empty verification: PASSED");
        }

        // test stack full verification
        try {
            doubleStack.push(1.1);
            doubleStack.push(2.2);
            doubleStack.push(3.3);
            doubleStack.push(4.4);
            doubleStack.push(5.5);
            doubleStack.push(6.6);
        } catch(StackFullException e) {
            System.out.println("Stack full verification test: PASSED");
        }

        // test clear
        doubleStack.clear();
        if (doubleStack.isEmpty())
            System.out.println("Clear stack is working: PASSED");

        // test push and toString
        System.out.println("PASSED if we see an double pyramid:");
        System.out.println(doubleStack);
        doubleStack.push(1.1);
        System.out.println(doubleStack);
        doubleStack.push(2.2);
        System.out.println(doubleStack);
        doubleStack.push(3.3);
        System.out.println(doubleStack);
        doubleStack.push(4.4);
        System.out.println(doubleStack);
        doubleStack.push(5.5);
        System.out.println(doubleStack);

        // test pop and toString()
        System.out.println("PASSED if we see an inverse double pyramid:");
        System.out.println(doubleStack);
        doubleStack.pop();
        System.out.println(doubleStack);
        doubleStack.pop();
        System.out.println(doubleStack);
        doubleStack.pop();
        System.out.println(doubleStack);
        doubleStack.pop();
        System.out.println(doubleStack);
        doubleStack.pop();
        System.out.println(doubleStack);

    }
}
