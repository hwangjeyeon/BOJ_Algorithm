import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 오름차순 정렬 학습용 문제.
 * - 그냥 출력하면 시간초과가 뜬다. 따라서 StringBuilder를 사용해야한다.
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
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        
        bw.write(sb.toString());


        br.close();
        bw.close();
    }

}

