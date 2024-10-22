//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CriculArry Q_arr = new CriculArry(5);
        Q_arr.enqueue(1);
        Q_arr.enqueue(2);
        Q_arr.enqueue(3);
        Q_arr.enqueue(4);
        Q_arr.enqueue(5);
        Q_arr.dequeue();
        Q_arr.dequeue();
        Q_arr.dequeue();
        Q_arr.dequeue();
        Q_arr.dequeue();
        Q_arr.enqueue(1);
        Q_arr.enqueue(2);
        //Q_arr.enqueue(6);
        Q_arr.dequeue();
        Q_arr.show();
    }
}