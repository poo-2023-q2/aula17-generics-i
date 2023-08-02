
/**
 * Static class with an assortment of generic methods.
 */
public final class ArraysUtil {

    /**
     * Convert any generic array to a String.
     * 
     * @param <T> the generic type
     * @param elements the array
     * @return the string
     */
    public static <T> String toString(T[] elements) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i < elements.length - 1)
                sb.append(",");
        }
        sb.append("]");

        return sb.toString();
    }

    /**
     * Selection sort (inline).
     * WARN: Performing some redundant checks to simplify the algorithm.
     * @param elements the array of elements
     * @param <E> the generic type
     */
    public static <E extends Comparable<E>> void sort(E[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int min = i;

            for (int j = i; j < elements.length; j++) {
                if (elements[j].compareTo(elements[min]) < 0) {
                    min = j;
                }
            }
            E temp = elements[i];
            elements[i] = elements[min];
            elements[min] = temp;
        }
    }

    /**
     * Check if two generic arrays are equal.
     * 
     * @param <E> the generic type
     * @param v1 the first array
     * @param v2 the second array
     * @return true if they are equal, false otherwise
     */
    public static <E extends Comparable<E>> boolean equals(E[] v1, E[] v2) {
        if (v1.length != v2. length) {
            return false;
        }

        for (int i = 0; i < v1.length; i++) {
            if (v1[i].compareTo(v2[i]) != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Integer[] v1 = {1, 2, 3, 4};
        Double[] v2 = {1.0, 2.0, 3.0, 4.0};
        String[] v3 = {"hello", "wonderful", "world"};

        System.out.println(ArraysUtil.toString(v1));
        System.out.println(ArraysUtil.toString(v2));
        System.out.println(ArraysUtil.toString(v3));

        System.out.println(ArraysUtil.equals(v1, new Integer[]{1, 2, 3, 4, 4}));
        System.out.println(ArraysUtil.equals(v1, new Integer[]{1, 2, 3, 4}));

        Integer[] v4 = {5, 4, 5, 1};
        String[] v5 = {"abc", "adf", "1re"};

        System.out.println(v4);
        System.out.println(v5);
        ArraysUtil.sort(v4);
        ArraysUtil.sort(v5);
        System.out.println(v4);
        System.out.println(v5);


    }
}
