import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Insertion_Sort_Part2 {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {

        // Bắt đầu từ phần tử thứ 2
        for (int i = 1; i < n; i++) {

            // Lưu phần tử cần chèn
            int value = arr.get(i);

            // Phần tử ngay bên trái value
            int j = i - 1;

            // Dịch các phần tử lớn hơn value sang phải
            while (j >= 0 && arr.get(j) > value) {
                arr.set(j + 1, arr.get(j));
                j--;
            }

            // Chèn value vào vị trí đúng
            arr.set(j + 1, value);

            // In toàn bộ mảng
            for (int k = 0; k < n; k++) {
                System.out.print(arr.get(k) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(
                        bufferedReader.readLine()
                                .replaceAll("\\s+$", "")
                                .split(" ")
                )
                .map(Integer::parseInt)
                .collect(toList());

        Insertion_Sort_Part2.insertionSort2(n, arr);

        bufferedReader.close();
    }
}