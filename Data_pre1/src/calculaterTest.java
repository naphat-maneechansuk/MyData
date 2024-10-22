import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class calculaterTest {

    @Test
    @DisplayName("Add Method")
    void add() {
        calculater cal = new calculater();
        assertEquals(2,new calculater().add(1,1));
        assertEquals(2,1+1);
        assertEquals(2,cal.add(1,1));
    }

    @Test
    void minus() {
        calculater cal = new calculater();
        assertEquals(2,new calculater().minus(3,1));
        assertEquals(2,5-3);
        assertEquals(2,cal.minus(1,-1));
    }

    @Test
    void multiply() {
        calculater cal = new calculater();
        assertEquals(2,new calculater().multiply(2,1));
        assertEquals(4,4*1);
        assertEquals(10,cal.multiply(5,2));
    }

    @Test
    void divide() {
        calculater cal = new calculater();
        assertEquals(2,new calculater().divide(2,1));
        assertEquals(2,10/5);
        assertEquals(10,cal.divide(100,10));
    }
}