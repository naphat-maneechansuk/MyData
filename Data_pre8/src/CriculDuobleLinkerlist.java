public class CriculDuobleLinkerlist implements Queue{
    class node {
        Object data;
        node link;
        node plink;

        node(Object d, node l, node pl) {
            data = d;
            link = l;
            plink = pl;
        }
    }

    private node front = null;
    private node back = null;
    private int count;

    public CriculDuobleLinkerlist(){
        count = 0;
    }
    @Override
    public void enqueue(Object value) {
        node temp = new node(value,null,null);
        if(isEmpty()){
            front = back = temp;
        }
        else{
            back.link = temp;
            temp.plink = back;
            back = temp;
            back.link = front;
            front.plink = back;
        }
        count++;
    }

    @Override
    public Object dequeue() {
        Object value = front.data;
        front = front.link;
        front.plink = back;
        back.link = front;
        return value;
    }

    @Override
    public Object peek() {
        return front.data;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void show() {
        node temp = front;
        for (int i = 0; i < count; i++) {
            if(i<count-1){
                System.out.print(temp.data+",");
            }
            else{
                System.out.print(temp.data);
            }
            temp = temp.link;
        }
        System.out.println();
        node ptemp = back;
        for (int i = count-1; i >=0; i--) {
            if(i>0){
                System.out.print(ptemp.data+",");
            }
            else{
                System.out.print(ptemp.data);
            }
            ptemp = ptemp.plink;
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

}