package Data10_3;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // รับขนาดของอาร์เรย์
        int size_arr = input.nextInt();
        int[] arr = new int[size_arr];

        // รับค่าอาร์เรย์
        for (int i = 0; i < size_arr; i++) {
            arr[i] = input.nextInt();
        }

        // เรียกใช้งานฟังก์ชัน Radix Sort
        radixSort(arr);
    }

    // ฟังก์ชัน Radix Sort
    public static void radixSort(int[] arr) {
        // หาค่ามากที่สุดเพื่อดูจำนวนหลักที่ต้องจัดเรียง
        int maxNumber = findMax(arr);

        // ตัวแปรใช้ในการเก็บจำนวนหลัก
        int maxDigits = findDigits(maxNumber);

        // สร้างคิว 10 คิว (จากหลัก 0 ถึง 9)
        QueueLink[] queues = new QueueLink[10];
        for (int i = 0; i < 10; i++) {
            queues[i] = new QueueLink();
        }

        // วนลูปตามจำนวนหลัก (หลักหน่วย, สิบ, ร้อย...)
        for (int digit = 0; digit < maxDigits; digit++) {
            // จัดเก็บตัวเลขลงในคิวตามหลักของ digit นั้นๆ
            for (int num : arr) {
                int digitValue = getDigit(num, digit);
                queues[digitValue].enqueue(num);
            }

            // ดึงข้อมูลออกจากคิวกลับมาในอาร์เรย์
            int index = 0;
            for (int i = 0; i < 10; i++) {
                while (!queues[i].isEmpty()) {
                    arr[index++] = (int) queues[i].dequeue();
                }
            }

            // แสดงผลลัพธ์ในแต่ละ Step
            System.out.print("Step " + (digit + 1) + ": ");
            printArray(arr);
        }

        // แสดงผลลัพธ์สุดท้าย
        System.out.print("Result => ");
        printArray(arr);
    }

    // หาค่ามากที่สุดในอาร์เรย์
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // หาจำนวนหลักของเลขมากที่สุด
    public static int findDigits(int num) {
        return Integer.toString(num).length();
    }

    // ดึงค่าหลักที่ต้องการ เช่น หลักหน่วย, สิบ, ร้อย
    public static int getDigit(int num, int digit) {
        return (num / (int) Math.pow(10, digit)) % 10;
    }

    // ฟังก์ชันแสดงผลอาร์เรย์
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
