import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    // Enqueue: thêm phần tử vào cuối queue
    static void enqueue(int x) {
        stack1.push(x);
    }
    // Chuyển phần tử từ stack1 sang stack2 nếu cần
    static void shiftStacks() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
    // Dequeue: xóa phần tử đầu queue
    static int dequeue() {
        shiftStacks();
        return stack2.pop();
    }
    // Lấy phần tử đầu queue nhưng không xóa
    static int peek() {
        shiftStacks();
        return stack2.peek();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                int x = sc.nextInt();
                enqueue(x);
            }
            else if (type == 2) {
                dequeue();
            }
            else if (type == 3) {
                System.out.println(peek());
            }
        }

        sc.close();
    }
}