import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticTimeExampleTest {

    @Test
    void printPairs() {
        QuadraticTimeExample example = new QuadraticTimeExample();
        int[] array = {1, 2, 3};
        example.printPairs(array);
    }
}