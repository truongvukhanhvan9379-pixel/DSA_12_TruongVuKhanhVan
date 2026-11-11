import java.util.Scanner;

public class Solution {
    // Chèn một giá trị vào BST
    public static Bai4 insert(Bai4 root, int val) {
        if (root == null) {
            return new Bai4(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Tìm LCA của hai khóa p và q trong BST
    public static Bai4 lowestCommonAncestor(Bai4 root, int p, int q) {
        if (root == null) {
            return null;
        }
        if (p < root.val && q < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p > root.val && q > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nút n: ");
        int n = sc.nextInt();

        Bai4 root = null;
        System.out.print("Nhập " + n + " giá trị của cây: ");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            root = insert(root, val);
        }

        System.out.print("Nhập hai khóa p và q: ");
        int p = sc.nextInt();
        int q = sc.nextInt();

        Bai4 lca = lowestCommonAncestor(root, p, q);
        if (lca != null) {
            System.out.println("Tổ tiên chung gần nhất: " + lca.val);
        } else {
            System.out.println("Không tìm thấy tổ tiên chung.");
        }

        sc.close();
    }
}