class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;
    private class Node {
        Object data;
        Node link;
        Node plink;

        Node(Object data) {
            this.data = data;
            this.link = null;
            this.plink = null;
        }
    }

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.link = newNode;
            newNode.plink = tail;
            tail = newNode;
        }
        size++;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.link;
        }
        return current.data;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            head = head.link;
            if (head != null) {
                head.plink = null;
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            tail = tail.plink;
            if (tail != null) {
                tail.link = null;
            } else {
                head = null;
            }
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.link;
            }
            current.plink.link = current.link;
            current.link.plink = current.plink;
        }
        size--;
    }

    public void show() {
        Node current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.link != null) {
                System.out.print(", ");
            }
            current = current.link;
        }
        System.out.println("]");
    }

    public int size() {
        return size;
    }
}
