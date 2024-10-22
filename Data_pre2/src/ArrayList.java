public class ArrayList implements Collection{
    private int capacity;
    private int count;
    private Object[] arry;

    ArrayList(int size_arr){
        this.capacity = size_arr;
        this.count = 0;
        this.arry = new Object[this.capacity];
    }
    @Override
    public void add(Object value) {
        this.add(this.count , value);
    }
    @Override
    public void add(int index, Object value) {
        if (isFull()||index > count || index < 0)
            throw new RuntimeException("Array Out of Bounds");
        for (int i = size(); i > index; i--){
            arry[i] = arry[i-1];
        }
        this.arry[index] = value;
        count++;

    }

    @Override
    public Object get(int index) {
        if (index > this.maxSize()||index < 0||index >= size()){
            throw new RuntimeException("Array Out of Bounds");
        }
        return arry[index];
    }

    @Override
    public void set(int index, Object value) {
        if (index > this.maxSize()||index < 0||index >= size()){
            throw new RuntimeException("Array Out of Bounds");
        }
        this.arry[index] = value;
    }

    @Override
    public void remove(Object value) {
        boolean found = false; 
        do {
            found = false;
            int index = indexOf(value);
            if (index != -1) {
                found = true;
                for (int i = index; i < size()-1; i++) {
                    arry[i] = arry[i + 1];//เขยิบvalue ที่อยู่หลังมันมาอยู่หน้าตั้งเเต่ตำเเหน่งที่indexอยู่
                }
                arry[size() - 1] = null;//ลบตัวสุดท้ายออก
                count--;
            }
        }while(found);
    }

    @Override
    public boolean find(Object value) {
        for (int i = 0; i < size();i++){
            if (arry[i].equals(value)){
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object value){
        for (int i = 0; i < size();i++){
            if (arry[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void show() {
        System.out.print("[");
        for (int i = 0; i < arry.length; i++) {
            if (i != arry.length-1) {
                System.out.print(i + "=>" + arry[i] + ", ");
            }else {
                System.out.print(i + "=>" + arry[i]);
            }
        }
        System.out.println("]");
    }

    @Override
    public int size() {
        return this.count;
    }

    public int maxSize(){
        return this.capacity;
    }

    @Override
    public boolean isEmpty() {
        if (this.count == 0){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if (count >= capacity){
            return true;
        }
        return false;
    }

}
