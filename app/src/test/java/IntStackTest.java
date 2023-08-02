import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntStackTest {

    @Test
    public void testEmptyExceptionOnPop() {
        IntStack stackInt = new IntStack(5);

        Assertions.assertThrows(StackEmptyException.class, stackInt::pop);
    }

    @Test
    public void testFullExceptionOnPush() {
        IntStack stackInt = new IntStack(5);

        Assertions.assertThrows(StackFullException.class, () -> {
            stackInt.push(1);
            stackInt.push(2);
            stackInt.push(3);
            stackInt.push(4);
            stackInt.push(5);
            stackInt.push(6);
        });
    }

    @Test
    public void testFull() {
        IntStack stackInt = new IntStack(5);

        for (int i = 0; i < 5; i++) {
            Assertions.assertFalse(stackInt.isFull());
            stackInt.push(i);
        }
        Assertions.assertTrue(stackInt.isFull());
    }

    @Test
    public void testEmpty() {
        IntStack stackInt = new IntStack(5);

        Assertions.assertTrue(stackInt.isEmpty());
        stackInt.push(1);
        Assertions.assertFalse(stackInt.isEmpty());
    }

    @Test
    void testClear() {
        IntStack stackInt = new IntStack(5);

        stackInt.push(1);
        stackInt.push(2);
        stackInt.clear();
        Assertions.assertTrue(stackInt.isEmpty());
    }

    @Test
    public void testToString() {
        IntStack stackInt = new IntStack(5);

        Assertions.assertEquals("[]", stackInt.toString());
        stackInt.push(1);
        Assertions.assertEquals("[1]", stackInt.toString());
        stackInt.push(2);
        Assertions.assertEquals("[1,2]", stackInt.toString());
        stackInt.push(3);
        Assertions.assertEquals("[1,2,3]", stackInt.toString());
    }

    @Test
    public void testPush() {
        IntStack stackInt = new IntStack(5);

        for (int i = 1; i <= 5; i++) {
            stackInt.push(i);
            Assertions.assertEquals(i, stackInt.size());
        }
    }

    @Test
    public void testEmptyExceptionOnPeek() {
        IntStack stackInt = new IntStack(5);

        Assertions.assertThrows(StackEmptyException.class, stackInt::peek);
    }

    @Test
    public void testPeek() {
        IntStack stackInt = new IntStack(5);

        for (int i = 1; i <= 5; i++) {
            stackInt.push(i);
            Assertions.assertEquals(i, stackInt.peek());
        }
    }

    @Test
    public void testPop() {
        IntStack stackInt = new IntStack(5);

        for (int i = 1; i <= 5; i++) {
            stackInt.push(i);
        }

        for (int i = 5; i >= 1; i--) {
            Assertions.assertEquals(i, stackInt.size());
            Assertions.assertEquals(i, stackInt.pop());
        }
        Assertions.assertEquals(0, stackInt.size());
    }
}
