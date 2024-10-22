package Queue;
public class QueueArray {
    private int count = 0;
    private int front = 0;
    private int back = 0;
    private Object[] arr_queue;
    private int max;

    public QueueArray(int size){
        count = 0;
        front = 0;
        back = 0;
        arr_queue = new Object[size];
        max = size;
    }

    public boolean isFull(){
        return back == max;
    }

    public void enqueue(Object value){
        if (isFull()){
            throw new ArrayIndexOutOfBoundsException("is full");
        }
        arr_queue[back] = value;
        count++;
        back++;
    }

    public Object dequeue(){
       if (isEmpty()){
           throw new ArrayIndexOutOfBoundsException("is empty");
       }
       Object queue_arr_temp = new Object();
       queue_arr_temp = arr_queue[front];
       arr_queue[front] = null;
       front++;
       count--;
        if (count == 0){
            front = back = 0;
        }
        return queue_arr_temp;
    }

    public Object peek(){
        if (isEmpty()){
            throw new ArrayIndexOutOfBoundsException("is empty");
        }
        return arr_queue[front];
    }

    public int size(){
        return count;
    }

    public void show(){
        System.out.print("[");
        for (int i = 0; i < back; i++) {
            if(i == back - 1){
                System.out.print(i + "=>" + arr_queue[i]);
            }
            else {
                System.out.print(i + "=>" + arr_queue[i] + ", ");
            }
        }
        System.out.println("]");
    }

    public boolean isEmpty(){
        return count == 0;
    }
}
