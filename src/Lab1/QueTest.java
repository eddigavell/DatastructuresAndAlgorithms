package Lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QueTest {
    @Test
    @DisplayName("Test que functions")
    void testQue() {
        Que test = new Que();
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);

        Assertions.assertEquals(1, test.peek());
        Assertions.assertEquals(1, test.dequeue());
        Assertions.assertEquals(2, test.peek());
        Assertions.assertEquals(2, test.dequeue());
        Assertions.assertEquals(3, test.peek());
        Assertions.assertEquals(3, test.dequeue());
    }
}
