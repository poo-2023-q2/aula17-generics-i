import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GenericStackTest {

    @Test
    public void testEmptyExceptionOnPop() {
        GenericStack<Integer> stackInt = new GenericStack<>(5);

        Assertions.assertThrows(StackEmptyException.class, stackInt::pop);
    }

    @Test
    public void testFullExceptionOnPush() {
        GenericStack<Integer> stackInt = new GenericStack<>(5);

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
        GenericStack<Integer> stackInt = new GenericStack<>(5);

        for (int i = 0; i < 5; i++) {
            Assertions.assertFalse(stackInt.isFull());
            stackInt.push(i);
        }
        Assertions.assertTrue(stackInt.isFull());
    }

    @Test
    public void testEmpty() {
        GenericStack<Integer> stackInt = new GenericStack<>(5);

        Assertions.assertTrue(stackInt.isEmpty());
        stackInt.push(1);
        Assertions.assertFalse(stackInt.isEmpty());
    }

    @Test
    void testClear() {
        GenericStack<Integer> stackInt = new GenericStack<>(5);

        stackInt.push(1);
        stackInt.push(2);
        stackInt.clear();
        Assertions.assertTrue(stackInt.isEmpty());
    }

    @Test
    public void testToString() {
        GenericStack<Integer> stackInt = new GenericStack<>(5);

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
        GenericStack<Integer> stackInt = new GenericStack<>(5);

        for (int i = 1; i <= 5; i++) {
            stackInt.push(i);
            Assertions.assertEquals(i, stackInt.size());
        }
    }

    @Test
    public void testEmptyExceptionOnPeek() {
        GenericStack<Integer> stackInt = new GenericStack<>(5);

        Assertions.assertThrows(StackEmptyException.class, stackInt::peek);
    }

    @Test
    public void testPeek() {
        GenericStack<Integer> stackInt = new GenericStack<>(5);

        for (int i = 1; i <= 5; i++) {
            stackInt.push(i);
            Assertions.assertEquals(i, stackInt.peek());
        }
    }

    @Test
    public void testPop() {
        GenericStack<Integer> stackInt = new GenericStack<>(5);

        for (int i = 1; i <= 5; i++) {
            stackInt.push(i);
        }

        for (int i = 5; i >= 1; i--) {
            Assertions.assertEquals(i, stackInt.size());
            Assertions.assertEquals(i, stackInt.pop());
        }
        Assertions.assertEquals(0, stackInt.size());
    }

    @Test
    public void testStringType() {
        GenericStack<String> stackString = new GenericStack<>(3);

        Assertions.assertEquals("[]", stackString.toString());
        stackString.push("hello");
        Assertions.assertEquals("[hello]", stackString.toString());
        stackString.push("wonderful");
        Assertions.assertEquals("[hello,wonderful]", stackString.toString());
        stackString.push("world");
        Assertions.assertEquals("[hello,wonderful,world]", stackString.toString());
    }
}
