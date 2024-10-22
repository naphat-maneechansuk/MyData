public class StackLink implements Stack{

    private DoubleLinkedList data;
    private int top ;

    public StackLink(){
        data = new DoubleLinkedList();
        this.top = -1;
    }
    class node {
        Object data;
        node link;
        node plink;

        node(node pl, Object d, node l) {
            data = d;
            link = l;
            plink = pl;
        }
    }

    @Override
    public void push(Object value) {
        data.add(value);
        top++;
    }

    @Override
    public Object pop() {
        Object current;
        if (isEmpty()){
            throw new RuntimeException("is empty");
        }else {
            current = data.get(top);
            data.remove(top);
            top--;
        }
        return current;
    }

    @Override
    public Object peek() {
        Object current;
        if (isEmpty()){
            throw new RuntimeException("is empty");
        }else {
            current = data.get(top);
        }
        return current;
    }

    @Override
    public int size() {
        return this.top +1;
    }

    @Override
    public void show() {
        data.show();
    }

    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }
}