import java.io.*;
import java.util.*;

public class Bai5_Cach1 {
    private static BufferedReader br;
    private static StringTokenizer st;

    // Đọc token tiếp theo, bỏ qua dòng trống và các số nằm trên nhiều dòng
    private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        // Đếm số lần xuất hiện trong A
        int n = Integer.parseInt(next());
        HashMap<Integer, Integer> countA = new HashMap<>();
        for (int i = 0; i < n; i++) {
            countA.merge(Integer.parseInt(next()), 1, Integer::sum);
        }

        // Đếm số lần xuất hiện trong B
        int m = Integer.parseInt(next());
        HashMap<Integer, Integer> countB = new HashMap<>();
        for (int i = 0; i < m; i++) {
            countB.merge(Integer.parseInt(next()), 1, Integer::sum);
        }

        // Giá trị nào có số lần trong B nhiều hơn trong A thì thuộc đáp án
        List<Integer> missing = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : countB.entrySet()) {
            int value = e.getKey();
            int cb = e.getValue();
            int ca = countA.getOrDefault(value, 0);
            if (cb > ca) {
                missing.add(value);
            }
        }

        // Sắp xếp tăng dần rồi in ra
        Collections.sort(missing);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < missing.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(missing.get(i));
        }
        System.out.println(sb);
    }
}