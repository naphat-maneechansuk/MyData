package Queue2;

public interface Queue {
    void enqueue(Object value);
    Object dequeue();
    Object peek();
    int size();
    void show();
    boolean isEmpty();
}
