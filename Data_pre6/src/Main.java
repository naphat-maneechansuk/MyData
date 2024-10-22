import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            try {
                // ตรวจสอบวงเล็บ
                checkBracket(input);
                // แปลง Infix เป็น Postfix
                String postfix = fiNal(input);
                //ปริ้น Postfix เเล้วจบ
                System.out.println(postfix);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    // ตรวจสอบวงเล็บ
    static void checkBracket(String i) {
        // สร้าง Stack เพื่อเก็บวงเล็บที่เปิด
        StackLink stack = new StackLink();
        for (char ch : i.toCharArray()) {
            // ถ้าเจอวงเล็บเปิดให้เก็บลง Stack
            if (ch == '(' || ch == '{' || ch == '[') {
                // เก็บวงเล็บเปิดลง Stack
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                // ถ้าเจอวงเล็บปิดต้องตรวจสอบว่าวงเล็บเปิดตรงข้ามสุดท้ายมีตรงกันหรือไม่
                if (stack.isEmpty()) {
                    // ถ้า Stack ว่างแสดงว่าไม่มีวงเล็บเปิดตรงข้าม
                    throw new RuntimeException("not found " + checkOpen(ch));
                }
                // ดึงวงเล็บเปิดตรงข้ามสุดท้ายออกจาก Stack
                char openBracket = (char) stack.pop();
                // ตรวจสอบว่าวงเล็บปิดตรงข้ามกันหรือไม่
                if (!check(openBracket, ch)) {
                    throw new RuntimeException("not found " + checkOpen(ch));
                }
            }
        }
        // ตรวจสอบว่า Stack ว่างหรือไม่
        if (!stack.isEmpty()) {
            // ถ้า Stack ไม่ว่างแสดงว่ายังมีวงเล็บเปิดที่ไม่ปิด
            char unmatchedBracket = (char) stack.pop();
            throw new RuntimeException("not found " + checkClose(unmatchedBracket));
        }
    }
    // ตรวจสอบว่าวงเล็บเปิดและปิดตรงกันหรือไม่
    static boolean check(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
    // หาวงเล็บเปิดตรงข้าม
    static char checkOpen(char close) {
        switch (close) {
            case ')': return '(';
            case '}': return '{';
            case ']': return '[';
            // ถ้าไม่เจอวงเล็บปิดให้โยนข้อความข้อผิดพลาด
            default: throw new IllegalArgumentException("not found " +  close);
        }
    }
    // หาวงเล็บปิดตรงข้าม
    static char checkClose(char open) {
        switch (open) {
            case '(': return ')';
            case '{': return '}';
            case '[': return ']';
            default: throw new IllegalArgumentException("not found " +  open);
        }
    }

    static int checkTheImportance(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    //รวมการทำงานทั้งหมด เพื่อแปลง Infix เป็น Postfix เเล้วปริ้น
    static String fiNal(String i) {
        String text = "";
        StackLink stack = new StackLink();
        for (char ch : i.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                text += ch;
            } else if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                while (!stack.isEmpty() && !check((char) stack.peek(), ch)) {
                    text+=stack.pop();
                }
                stack.pop();
            } else {
                // ตรวจสอบความสำคัญของเครื่องหมาย ว่าจะพิมออกมารึเปล่า
                while (!stack.isEmpty() && checkTheImportance(ch) <= checkTheImportance((char) stack.peek())) {
                    text += stack.pop();
                }
                // พิมเครื่องหมายลง Stack
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            text += stack.pop();
        }
        return text.toString();
    }
}
