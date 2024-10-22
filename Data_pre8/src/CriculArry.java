public class CriculArry implements Queue {
    private  int count = 0;
    private  int front = 0;
    private  int back = 0;
    private  Object[] arr_queue;
    private  int max;

    public  CriculArry(int size){
        arr_queue = new Object[size];
        max = size;
    }
    public  boolean isFull(){
        return max == count ;  //แก้
    }

    @Override
    public void enqueue(Object value) {
        if(!isEmpty() && isFull()){
            throw new  ArrayIndexOutOfBoundsException("is full");
        }
        arr_queue[back%max] = value;
        back++;
        count++;
    }
    @Override
    public Object dequeue() {
        if(isEmpty()){
            throw new  ArrayIndexOutOfBoundsException("is empty");
        }
        Object Value = arr_queue[front%max];
        arr_queue[front%max] = null;
        front++;
        count--;
        if(front>=back){
            front = 0;
            back = 0;
        }
        return Value;
    }

    @Override
    public Object peek() {
        if(isEmpty()){
            throw new  ArrayIndexOutOfBoundsException("is empty");
        }
        return arr_queue[front];
    }

    @Override
    public int size() {
        return back - front;
    }

    @Override
    public void show() {
        System.out.print("[");
        for (int i = front; i < back; i++) {//แก้
            if(i<back-1){//แก้
                System.out.print(i%max+" => "+ arr_queue[i%max]+" , ");}
            else{
                System.out.print(i%max+" => "+ arr_queue[i%max]);
            }
        }
        System.out.println("]");
    }

    @Override
    public boolean isEmpty() {
        return front == 0 && back ==0;
    }
}
