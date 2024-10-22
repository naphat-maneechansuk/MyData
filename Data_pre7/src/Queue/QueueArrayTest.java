package Queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class QueueArrayTest {

    private QueueArray queue;

    @BeforeEach
    public void setUp() {
        queue = new QueueArray(5);
    }

    @Test
    public void testEnqueueAndDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testPeek() {
         queue.enqueue(5);
        queue.enqueue(10);

        assertEquals(5, queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    public void testSize() {
        assertEquals(0, queue.size());

        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(2, queue.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());

        queue.enqueue(42);

        assertFalse(queue.isEmpty());
    }

    @Test
    public void testIsFull() {
        assertFalse(queue.isFull());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        assertTrue(queue.isFull());
    }


    @Test
    public void testDequeueEmptyQueue() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.dequeue());
    }

    @Test
    public void testPeekEmptyQueue() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.peek());
    }

    @Test
    public void testIsFullWithEnqueue(){
        assertTrue(queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.enqueue(60));
        assertTrue(queue.isFull());
        assertFalse(queue.isEmpty());

        assertEquals(10, queue.peek());
        assertEquals(10, queue.dequeue());
        assertTrue(queue.isFull());
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.enqueue(60));
        assertEquals(20, queue.peek());
        assertEquals(20, queue.dequeue());
        assertTrue(queue.isFull());
        assertEquals(30, queue.peek());
        assertEquals(30, queue.dequeue());
        assertTrue(queue.isFull());
        assertEquals(40, queue.peek());
        assertEquals(40, queue.dequeue());
        assertTrue(queue.isFull());
        assertEquals(50, queue.peek());
        assertEquals(50, queue.dequeue());
        assertFalse(queue.isFull());
        queue.enqueue(60);
        assertEquals(60, queue.peek());
        assertEquals(60, queue.dequeue());
        assertFalse(queue.isFull());
    }

}