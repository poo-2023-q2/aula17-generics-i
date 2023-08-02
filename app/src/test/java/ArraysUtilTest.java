import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArraysUtilTest {

    @Test
    public void testToString() {
        Integer[] v1 = {1, 2, 3, 4};
        Double[] v2 = {1.0, 2.0, 3.0, 4.0};
        String[] v3 = {"hello", "wonderful", "world"};

        Assertions.assertEquals("[1,2,3,4]", ArraysUtil.toString(v1));
        Assertions.assertEquals("[1.0,2.0,3.0,4.0]", ArraysUtil.toString(v2));
        Assertions.assertEquals("[hello,wonderful,world]", ArraysUtil.toString(v3));
    }

    @Test
    public void testEquals() {
        // elements are the same
        Assertions.assertTrue(ArraysUtil.equals(
                new Integer[]{1, 2, 3, 4},
                new Integer[]{1, 2, 3, 4}));
        // elements in different order
        Assertions.assertFalse(ArraysUtil.equals(
                new Integer[]{1, 2, 3, 4},
                new Integer[]{1, 3, 2, 4}));
        // different sizes
        Assertions.assertFalse(ArraysUtil.equals(
                new Integer[]{1, 2, 3, 4},
                new Integer[]{1, 3}));

    }

    @Test
    public void testSort() {
        Integer[] v1 = {4, 3, 2, 1};
        Double[] v2 = {4.0, 5.0, 9.2, 9.1, 8.0};
        Character[] v3 = {'z', 'w', 'c', 'd', 'a', 'b', 'k', 'l'};
        String[] v4 = {"hello", "wonderful", "and", "beautiful", "world"};

        ArraysUtil.sort(v1);
        Assertions.assertTrue(ArraysUtil.equals(new Integer[]{1, 2, 3, 4}, v1));
        ArraysUtil.sort(v2);
        Assertions.assertTrue(ArraysUtil.equals(new Double[]{4.0, 5.0, 8.0, 9.1, 9.2}, v2));
        ArraysUtil.sort(v3);
        Assertions.assertTrue(ArraysUtil.equals(new Character[]{'a', 'b', 'c', 'd', 'k', 'l', 'w', 'z'}, v3),
                String.format("Result %s is not sorted\n", ArraysUtil.toString(v3)));
        ArraysUtil.sort(v4);
        Assertions.assertTrue(ArraysUtil.equals(new String[]{"and", "beautiful", "hello", "wonderful", "world"}, v4));
    }

}
