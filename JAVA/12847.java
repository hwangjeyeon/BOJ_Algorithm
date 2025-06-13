import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 슬라이딩 윈도우로 양 끝 영역 잡고, 가장 큰 값으로 갱신해나가는 작업을 하면된다
 * 2. 완성된 결과를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long ans = 0;

        int left = 0;
        int right = m-1;
        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        ans = sum;
        for (int i = m; i < n; i++) {
            sum -= arr[left++];
            sum += arr[++right];
            ans = Math.max(ans, sum);
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
