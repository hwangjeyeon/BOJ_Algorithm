import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 내림차순 정렬 학습용 문제 풀이.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr,Collections.reverseOrder());

        for (Integer i : arr) {
            bw.write(i+"\n");
        }

        br.close();
        bw.close();
    }

}

