import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LinearTimeExampleTest {

    @Test
    void sumArray() {
        LinearTimeExample example = new LinearTimeExample();

        int[] array = {1, 2, 3, 4, 5};

        assertEquals(15, example.sumArray(array));
    }
}