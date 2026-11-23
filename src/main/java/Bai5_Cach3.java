import java.io.*;
import java.util.*;

public class Bai5_Cach3 {

    private static BufferedReader br;
    private static StringTokenizer st;

    private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(next());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(next());
        }

        int m = Integer.parseInt(next());
        int[] b = new int[m];
        int minB = Integer.MAX_VALUE, maxB = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(next());
            minB = Math.min(minB, b[i]);
            maxB = Math.max(maxB, b[i]);
        }

        // Mảng đếm: chỉ số = giá trị - minB, kích thước tối đa 101
        int[] diff = new int[maxB - minB + 1];
        for (int x : b) {
            diff[x - minB]++;
        }
        // Trừ số lần xuất hiện trong A (chỉ những giá trị nằm trong khoảng B)
        for (int x : a) {
            if (x >= minB && x <= maxB) {
                diff[x - minB]--;
            }
        }

        // Duyệt theo chỉ số tăng dần để đáp án đã sắp xếp
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < diff.length; i++) {
            for (int k = 0; k < diff[i]; k++) {
                if (sb.length() > 0) sb.append(' ');
                sb.append(i + minB);
            }
        }
        System.out.println(sb);
    }
}
