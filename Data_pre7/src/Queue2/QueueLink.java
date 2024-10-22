package Queue2;

public class QueueLink implements Queue2{
    private node front;
    private node back;
    private int count;

    public class node{
        public Object data;
        public node link;
        node(Object d ,node l){
            data = d;
            link = l;
        }
    }

    public QueueLink(){
        front = null;
        back = null;
        count = 0;
    }

    public void enqueue(Object value){
        node newNode = new node(value,null);
        if (isEmpty()){
            front = newNode;
            back = newNode;
        }else {
            back.link = newNode;
            back = newNode;
        }
        count++;
    }

    public Object dequeue(){
        if (isEmpty()){
            throw new RuntimeException("is empty");
        }
        node temp = null;
        temp = front;
        front = front.link;
        count--;
        return temp.data;
    }

    public Object peek(){
        if (isEmpty()){
            throw new RuntimeException("is empty");
        }
        return front.data;
    }

    public int size(){
        return count;
    }

    public void show(){
        System.out.print("[");
        node temp = front;
        for (int i = 0; i < count; i++) {
            if(i == count - 1){
                System.out.print(temp.data);
            }
            else {
                System.out.print(temp.data + ", ");
            }
            temp = temp.link;
        }
        System.out.println("]");
    }

    public boolean isEmpty(){
        return count == 0;
    }


}

