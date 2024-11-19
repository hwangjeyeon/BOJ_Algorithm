import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. dp를 사용해서 해결한 문제다.
 * 2. 말을 잘 해석해야한다. 힘의 최대 k를 구한다음에 모든 경우의 k중 최솟값을 구해야한다
 * 3. 이 문제는 이중포문이 가능한 문제다. 왼 -> 오 형태의 징검다리 이동 문제이므로 i를 기준으로 이전 값들을 비교하여 갱신하면 될 것이다
 *
 *
 * - 문제 해결:
 * 4. 맨 처음은 0으로 초기화해준다. 어떤 경우에도 여기서는 힘을 0을 사용하기 때문이다
 * 5. 다음은 각 지점을 처음 순회할때 최댓값으로 초기화해준다. 그리고 그 이전지점을 모두 순회하며, 필요한 힘을 뽑은 다음 그 지점에 최솟값을 되어있는 k힘과 비교하여, 더 큰 값을 k에 넣는다
 * 6. 마지막으로 dp에는 최댓값 k와 비교하여 더 작은 값으로 갱신한다
 * 7. 이렇게 완성한 뒤, 마지막 위치인 n-1 위치의 값을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        long[] dp = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = Long.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                long k = (long) ((i + 1) - (j + 1)) * (1 + Math.abs(arr[i] - arr[j]));
                k = Math.max(k, dp[j]);
                dp[i] = Math.min(dp[i], k);
            }
        }

        bw.write(dp[n-1]+"");

        br.close();
        bw.close();
    }

}
