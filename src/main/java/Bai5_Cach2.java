import java.io.*;
import java.util.*;

public class Bai5_Cach2 {

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
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(next());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (j < m) {
            if (i < n && a[i] == b[j]) {
                i++;
                j++;
            } else if (i < n && a[i] < b[j]) {
                // A còn số nhỏ hơn, bỏ qua số đó
                i++;
            } else {
                // b[j] không khớp với a[i] hiện tại, nên thuộc đáp án
                if (sb.length() > 0) sb.append(' ');
                sb.append(b[j]);
                j++;
            }
        }
        System.out.println(sb);
    }
}