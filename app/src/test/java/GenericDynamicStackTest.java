import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GenericDynamicStackTest {

    @Test
    public void testEmptyExceptionOnPop() {
        GenericDynamicStack<Integer> stackInt = new GenericDynamicStack<>();

        Assertions.assertThrows(StackEmptyException.class, stackInt::pop);
    }

    @Test
    public void testEmpty() {
        GenericDynamicStack<Integer> stackInt = new GenericDynamicStack<>();

        Assertions.assertTrue(stackInt.isEmpty());
        stackInt.push(1);
        Assertions.assertFalse(stackInt.isEmpty());
    }

    @Test
    void testClear() {
        GenericDynamicStack<Integer> stackInt = new GenericDynamicStack<>();

        stackInt.push(1);
        stackInt.push(2);
        stackInt.clear();
        Assertions.assertTrue(stackInt.isEmpty());
    }

    @Test
    public void testToString() {
        GenericDynamicStack<Integer> stackInt = new GenericDynamicStack<>();

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
        GenericDynamicStack<Integer> stackInt = new GenericDynamicStack<>();

        for (int i = 1; i <= 5; i++) {
            stackInt.push(i);
            Assertions.assertEquals(i, stackInt.size());
        }
    }

    @Test
    public void testEmptyExceptionOnPeek() {
        GenericDynamicStack<Integer> stackInt = new GenericDynamicStack<>();

        Assertions.assertThrows(StackEmptyException.class, stackInt::peek);
    }

    @Test
    public void testPeek() {
        GenericDynamicStack<Integer> stackInt = new GenericDynamicStack<>();

        for (int i = 1; i <= 5; i++) {
            stackInt.push(i);
            Assertions.assertEquals(i, stackInt.peek());
        }
    }

    @Test
    public void testPop() {
        GenericDynamicStack<Integer> stackInt = new GenericDynamicStack<>();

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
        GenericDynamicStack<String> stackString = new GenericDynamicStack<>();

        Assertions.assertEquals("[]", stackString.toString());
        stackString.push("hello");
        Assertions.assertEquals("[hello]", stackString.toString());
        stackString.push("wonderful");
        Assertions.assertEquals("[hello,wonderful]", stackString.toString());
        stackString.push("world");
        Assertions.assertEquals("[hello,wonderful,world]", stackString.toString());
    }
}
