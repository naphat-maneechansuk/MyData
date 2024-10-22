package Queue;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size_arr = input.nextInt();
        QueueArray Q_arr = new QueueArray(size_arr);
        String[] checker = new String[3];
        do {
            checker = input.nextLine().split(" ");
            if (checker.length > 0 && !checker[0].isEmpty()) {
                switch (Integer.parseInt(checker[0])) {
                    case 1: // push
                        try {
                            Q_arr.enqueue(Integer.parseInt(checker[1]));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2: // pop
                        try {
                            System.out.println(Q_arr.dequeue());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3: // peek
                        try {
                            System.out.println(Q_arr.peek());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4: // size
                        System.out.println(Q_arr.size());
                        break;
                    case 5: // show
                        Q_arr.show();
                        break;
                    case 6: // isEmpty
                        if (Q_arr.isEmpty()) {
                            System.out.println("is empty");
                        } else {
                            System.out.println("not empty");
                        }
                        break;
                    case 7: // isEmpty
                        if (Q_arr.isFull()) {
                            System.out.println("is full");
                        } else {
                            System.out.println("not full");
                        }
                        break;
                }
            }
        } while (!checker[0].equals("-99"));
        input.close();
    }
}