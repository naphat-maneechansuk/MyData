public class DoubleLinkedList implements Collection {

    class Node {
        Object data;
        Node link;
        Node plink;

        Node(Node pl, Object d, Node l) {
            data = d;
            link = l;
            plink = pl;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    @Override
    public void add(Object value) {
        Node newNode = new Node(null, value, null);
        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }else {
            this.tail.link = newNode;
            newNode.plink = tail;
            this.tail = newNode;
        }
        count++;
    }

    @Override
    public void add(int index, Object value) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("out of bound");
        }
        Node newNode = new Node(null, value, null);
        if (index == 0){
            newNode.link = this.head;
            this.head.plink = newNode;
            this.head = newNode;
            count++;
        }else if (index > size()){
            add(value);
        }else {
            Node ptemp = null;
            Node temp = this.head;
            for (int i = 0; i < index; i++) {
                ptemp = temp;
                temp = temp.link;
            }
            newNode.plink = ptemp;
            newNode.link = temp;
            ptemp.link = newNode;
            temp.plink = newNode;
            count++;
        }
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("out of bound");
        }
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.link;
        }
        return current.data;
    }

    @Override
    public void set(int index, Object value) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("out of bound");
        }
        Node current = this.head;
        for (int i = 0; i < index; i++) {//ไล่ไปจนกว่าจะถึง index
            current = current.link;
        }
        current.data = value;
    }

    @Override
    public void remove(Object value) {
        if (!isEmpty()) {
            Node current = this.head;
            while (current.link != null) {
                if (this.head.data == value){
                    this.head = this.head.link;
                    count--;
                    current = this.head;
                }
                if (this.tail.data == value){
                    this.tail = this.tail.plink;
                    this.tail.link = null;
                    count--;
                }
                if (current.data == value) {
                    current.plink.link = current.link;
                    current.link.plink = current.plink;
                    count--;
                }
                current = current.link;
            }
        }
    }

    @Override
    public boolean find(Object value) {
        Node current = this.head;
        while (current != null){
            if (current.data == value) return true;
            current = current.link;
        }
        return false;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void show() {
        if (isEmpty()){
            System.out.println("[]");
        }else {
            Node current = this.head;
            System.out.print("[");
            while (current != null){
                System.out.print(current.data);
                if (current.link != null){
                    System.out.print(", ");
                }
                current = current.link;
            }
            System.out.println("]");
        }
    }


    public void show_backward() {
        if (isEmpty()){
            System.out.println("[]");
        }else {
            Node current = this.tail;
            System.out.print("[");
            while (current != null){
                System.out.print(current.data);
                if (current.plink != null){
                    System.out.print(", ");
                }
                current = current.plink;
            }
            System.out.println("]");
        }
    }
}