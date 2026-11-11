import java.util.Scanner;
public class AVLTree {

    // Lấy chiều cao của nút (null có chiều cao 0)
    static int height(Bai6 node) {
        return node == null ? 0 : node.height;
    }

    // Hệ số cân bằng = chiều cao con trái - chiều cao con phải
    static int balanceFactor(Bai6 node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // Cập nhật chiều cao của nút dựa trên hai con
    static void updateHeight(Bai6 node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    // Xoay phải quanh y (xử lý trường hợp LL)
    static Bai6 rotateRight(Bai6 y) {
        Bai6 x = y.left;
        Bai6 t2 = x.right;

        x.right = y;
        y.left = t2;

        updateHeight(y);
        updateHeight(x);
        return x;
    }

    // Xoay trái quanh x (xử lý trường hợp RR)
    static Bai6 rotateLeft(Bai6 x) {
        Bai6 y = x.right;
        Bai6 t2 = y.left;

        y.left = x;
        x.right = t2;

        updateHeight(x);
        updateHeight(y);
        return y;
    }

    // Chèn khóa key vào cây AVL có gốc root, trả về gốc mới của cây con
    public static Bai6 insert(Bai6 root, int key) {
        // 1. Chèn như cây BST thông thường
        if (root == null) {
            return new Bai6(key);
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        } else {
            // Khóa đã tồn tại: không chèn trùng
            return root;
        }

        // 2. Cập nhật chiều cao
        updateHeight(root);

        // 3. Kiểm tra cân bằng và xoay nếu cần
        int balance = balanceFactor(root);

        // Trường hợp LL: lệch trái, con trái lệch trái
        if (balance > 1 && key < root.left.key) {
            return rotateRight(root);
        }

        // Trường hợp RR: lệch phải, con phải lệch phải
        if (balance < -1 && key > root.right.key) {
            return rotateLeft(root);
        }

        // Trường hợp LR: lệch trái, con trái lệch phải
        if (balance > 1 && key > root.left.key) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        // Trường hợp RL: lệch phải, con phải lệch trái
        if (balance < -1 && key < root.right.key) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    // Duyệt inorder để kiểm tra kết quả (cây BST in ra tăng dần)
    static void inorder(Bai6 root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số khóa n: ");
        int n = sc.nextInt();

        Bai6 root = null;
        System.out.print("Nhập " + n + " khóa: ");
        for (int i = 0; i < n; i++) {
            int key = sc.nextInt();
            root = insert(root, key);
        }

        System.out.print("Duyệt inorder: ");
        inorder(root);
        System.out.println();
        System.out.println("Chiều cao cây: " + height(root));
        System.out.println("Gốc cây: " + root.key);

        sc.close();
    }
}