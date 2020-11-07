package Lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StackTest {

    @Test
    @DisplayName("Testing Stack functions")
    void stackTest() {
        Stack stackTest = new Stack();
        stackTest.push(1);
        stackTest.push(2);
        stackTest.push(3);

        Assertions.assertEquals(3, stackTest.peek());
        Assertions.assertEquals(3, stackTest.pop());

        Assertions.assertEquals(2, stackTest.peek());
        Assertions.assertEquals(2, stackTest.pop());

        Assertions.assertEquals(1, stackTest.peek());
        Assertions.assertEquals(1, stackTest.pop());
    }
}
