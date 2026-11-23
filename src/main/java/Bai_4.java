import java.io.*;
import java.util.*;

public class Bai_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        HashMap<Long, Integer> count = new HashMap<>();
        int read = 0;
        while (read < n) {
            String line = br.readLine();
            if (line == null) break;
            st = new StringTokenizer(line);
            while (st.hasMoreTokens() && read < n) {
                long x = Long.parseLong(st.nextToken());
                count.merge(x, 1, Integer::sum);
                read++;
            }
        }

        // Đếm số cặp có chênh lệch đúng bằng K
        long result = 0;
        for (Map.Entry<Long, Integer> e : count.entrySet()) {
            long x = e.getKey();
            long c = e.getValue();
            if (k == 0) {
                // Các cặp (i, j), i < j, có a[i] = a[j]
                result += c * (c - 1) / 2;
            } else {
                // Mỗi x ghép với mọi số x + K
                result += c * count.getOrDefault(x + k, 0);
            }
        }

        // Output
        System.out.println(result);
    }
}