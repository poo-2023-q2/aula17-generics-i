import java.util.ArrayList;
import java.util.Random;

/**
 * Demonstrate the use of ArrayList class, which is a typical
 * example of parametric polymorphism (generic class)
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> intArray = new ArrayList<>();

        intArray.add(1);
        intArray.add(3);
        intArray.add(5);

        System.out.println(intArray);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            intArray.add(random.nextInt(100));
        }

        System.out.println(intArray);

        ArrayList<String> stringArray = new ArrayList<>();

        stringArray.add("hello");
        stringArray.add("world");
        stringArray.add("how are you?");

        System.out.println(stringArray);
    }
}
