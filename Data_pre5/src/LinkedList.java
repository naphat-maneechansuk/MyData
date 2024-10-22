public class LinkedList implements Collection{

    private class node {
        Object data;
        node link;
        node(Object d, node l){
            this.data = d;
            this.link = l;
        }
    };

    node head;
    node tail;
    int count;

    LinkedList(){
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public void add(Object value) {
        node newNode = new node(value, null);
        if(size() == 0) {
            head = newNode;
        }
        if(tail != null){
            tail.link = newNode;
            tail = newNode;
        } else {
            tail = newNode;
        }
        count++;
    }

    @Override
    public void add(int index, Object value) {
        if(index > (size() + 1) ){
            throw new IndexOutOfBoundsException("out of bound");
        }
        if(index == size() + 1 ){
            add(value); // case add tail
        } else {
            node ptemp = null;
            node temp = head;
            for(int i = 2; i <= index; i++){
                if(i != 1){
                    ptemp = temp;
                }
                temp = temp.link;
            }
            if(ptemp != null) {
                ptemp.link = new node(value, temp); // case add between
            } else {
                head = new node(value, head); // case add head
            }
            count++;
        }
    }

    @Override
    public Object get(int index) {
        if(index > size()){
            throw new IndexOutOfBoundsException("out of bound");
        }
        node temp = head;
        for(int i=0; i < index; i++){
            temp = temp.link;
        }
        return temp.data;
    }

    @Override
    public void set(int index, Object value) {
        if(index > size()){
            throw new IndexOutOfBoundsException("out of bound");
        }
        node temp = head;
        if(index == 1){
            temp.data = value;
        }
        for(int i = 2; i <= index; i++){
            temp = temp.link;
        }
        temp.data = value;
    }

    @Override
    public void remove(Object value) {
        node temp = head;
        node ptemp = null;
        while(temp != null){
            if(temp.data == value){
                if(temp == head) {
                    head = head.link;
                } else if(temp == tail){
                    tail = ptemp;
                    ptemp.link = null;
                } else {
                    ptemp.link = temp.link;
                    temp = ptemp;
                }
                count--;
            }
            ptemp = temp;
            temp = temp.link;
        }
    }

    public void removeIndex(int index){

    }

    @Override
    public boolean find(Object value) {
        node temp = head;
        while(temp != null){
            if(temp.data == value){
                return true;
            }
            temp = temp.link;
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void show() {
        node temp = head;
        System.out.print("[");
        while(temp != null){
            System.out.print(temp.data);
            temp = temp.link;
            if(temp != null){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}