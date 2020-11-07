package Lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    @DisplayName("Test add functions")
    void TestSoAddFunctionsWorksAsIntended() {
        LinkedList linkedListTest = new LinkedList();
        //Test first add with only value
        // add(e)
        linkedListTest.add(1);
        linkedListTest.add(2);
        linkedListTest.add(3);

        Assertions.assertEquals(1, linkedListTest.get(0));
        Assertions.assertEquals(2, linkedListTest.get(1));
        Assertions.assertEquals(3, linkedListTest.get(2));

        //Test second add with index and value
        // add(i, e)

        linkedListTest.add(0,99);
        linkedListTest.add(1,100);

        Assertions.assertEquals(99, linkedListTest.get(0));
        Assertions.assertEquals(100, linkedListTest.get(1));
        Assertions.assertEquals(1, linkedListTest.get(2));
        Assertions.assertEquals(2, linkedListTest.get(3));
        Assertions.assertEquals(3, linkedListTest.get(4));
    }

    @Test
    @DisplayName("Test contains() function")
    void TestContainsFunction() {
        LinkedList linkedListTest = new LinkedList();
        linkedListTest.add(100);
        linkedListTest.add(200);
        linkedListTest.add(300);

        Assertions.assertTrue(linkedListTest.contains(100));
        Assertions.assertTrue(linkedListTest.contains(200));
        Assertions.assertTrue(linkedListTest.contains(300));
        Assertions.assertFalse(linkedListTest.contains(50));
    }

    @Test
    @DisplayName("Test get() function")
    void TestGetFunction() {
        LinkedList linkedListTest = new LinkedList();
        linkedListTest.add(100);
        linkedListTest.add(200);
        linkedListTest.add(300);

        Assertions.assertEquals(100, linkedListTest.get(0));
        Assertions.assertEquals(200, linkedListTest.get(1));
        Assertions.assertEquals(300, linkedListTest.get(2));

        linkedListTest.add(1, 50);
        Assertions.assertEquals(50, linkedListTest.get(1));
    }

    @Test
    @DisplayName("Test remove() function")
    void TestRemoveFunction() {
        LinkedList linkedListTest = new LinkedList();
        linkedListTest.add(100);
        linkedListTest.add(200);
        linkedListTest.add(300);

        Assertions.assertEquals(100, linkedListTest.get(0));
        linkedListTest.remove(0);
        Assertions.assertNotEquals(100, linkedListTest.get(0));
    }

    @Test
    @DisplayName("Test Empty() function")
    void TestEmptyFunction() {
        LinkedList linkedListTest = new LinkedList();

        Assertions.assertTrue(linkedListTest.empty());
        linkedListTest.add(10);
        Assertions.assertFalse(linkedListTest.empty());

    }

    @Test
    @DisplayName("Test size() works as intended")
    void TestSizeFunction() {
        LinkedList linkedListTest = new LinkedList();

        Assertions.assertEquals(0, linkedListTest.size());

        linkedListTest.add(100);
        Assertions.assertEquals(1, linkedListTest.size());

        linkedListTest.add(200);
        Assertions.assertEquals(2, linkedListTest.size());

        linkedListTest.add(300);
        Assertions.assertEquals(3, linkedListTest.size());
    }
}
