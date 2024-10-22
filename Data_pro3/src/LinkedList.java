public class LinkedList implements Collection{
    private class node {
        Object data;
        node link;
        node(Object d, node l){
            this.data = d;
            this.link = l;
        }
    }

    node head;
    node tail;
    int count;
    LinkedList(){
        head = null;
        tail = null;
        count = 0 ;
    }

    @Override
    public void add(Object value) {
        node new_node = new node(value , null);
        if (isEmpty()){
            head = new_node;
            tail = new_node;
        }else {
            tail.link = new_node ;
            tail = new_node;
        }
        tail = new_node;
        count++;

    }

    @Override
    public void add(int index, Object value) {
        if (index > size() || index < 0){
            throw new IndexOutOfBoundsException("out of bound");
        }
        if (index == 0){
            node new_node = new node(value , head);
            head = new_node;
            if (count == 0){
                tail = head;
            }
        }else {
            node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.link;
            }
            node new_node = new node(value, temp.link);
            temp.link = new_node;
            if (new_node.link == null) {
                tail = new_node;
            }
        }
        count++;
    }

    @Override
    public Object get(int index) {
        if (index > size() || index < 0){
            throw new IndexOutOfBoundsException("out of bound");
        }
        int i = 0 ;
        for (node temp = head ; temp != null ; temp = temp.link){
            if (index == i+1){
                return temp.data;
            }
            i++;

        }
        return null;
    }

    @Override
    public void set(int index, Object value) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("out of bound");
        }
        node current = head;
        for (int i = 0; i < index-1; i++) {
            current = current.link;
        }
        current.data = value;
    }

    @Override
    public void remove(Object value) {
        if (head == null) {
            return;
        }
        if (head.data.equals(value)) {
            head = head.link;
            if (head == null) {
                tail = null;
            }
            count--;
            return;
        }
        node current = head;
        for(int i = 0; i < size(); i++) {
        while (current.link != null && !current.link.data.equals(value)) {
            current = current.link;
        } if (current.link != null) {
            current.link = current.link.link;
            if (current.link == null) {
                tail = current;
            }
            count--;
        }
    }
    }

    @Override
    public boolean find(Object value) {
        for (node temp = head ; temp != null ; temp = temp.link) {
            if (temp.data == value){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        node temp = head ;
        while (temp == null){
            return true ;
        }
        return false;
    }

    @Override
    public void show() {
        System.out.print("[");
        for (node temp = head ; temp != null ; temp = temp.link){
            System.out.print(temp.data);
            if (temp.link != null){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
