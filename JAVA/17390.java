import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 오름차순 정렬 후, 누적합한 결과를 구해둔다
 * 2. 이후 그 범위만큼의 값을 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(q)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] sum = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            sum[i] = arr[i] + sum[i-1];
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            bw.write(sum[r] - sum[l-1] + "\n");
        }

        br.close();
        bw.close();
    }

}
