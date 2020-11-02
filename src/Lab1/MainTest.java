package Lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    @DisplayName("Test add functions")
    void TestSoAddFunctionsWorksAsIntended() {
        LinkedList linkedListAddTest = new LinkedList();
        //Test first add with only value
        // add(e)
        linkedListAddTest.add(1);
        linkedListAddTest.add(2);
        linkedListAddTest.add(3);

        Assertions.assertNotEquals(3,linkedListAddTest.get(0));
        Assertions.assertNotEquals(5,linkedListAddTest.get(1));
        Assertions.assertNotEquals(4,linkedListAddTest.get(2));

        Assertions.assertEquals(1, linkedListAddTest.get(0));
        Assertions.assertEquals(2, linkedListAddTest.get(1));
        Assertions.assertEquals(3, linkedListAddTest.get(2));

        //Test second add with index and value
        // add(i, e)

        linkedListAddTest.add(0,99);
        linkedListAddTest.add(1,100);

        Assertions.assertEquals(99, linkedListAddTest.get(0));
        Assertions.assertEquals(100, linkedListAddTest.get(1));





    }

    @Test
    @DisplayName("Test contains() function")
    void TestContainsFunction() {

    }

    @Test
    @DisplayName("Test get() function")
    void TestGetFunction() {

    }

    @Test
    @DisplayName("Test remove() function")
    void TestRemoveFunction() {

    }

    @Test
    @DisplayName("Test Empty() function")
    void TestEmptyFunction() {

    }

    @Test
    @DisplayName("Test size() works as intended")
    void TestSizeFunction() {

    }
}
