import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 다음 점화식을 이용하면 된다 dp[i] = dp[i-1] + dp[i-m]
 * 2. 단 i-m이 0보다 작을 수 있으므로 중간에 검사해서 참이라면 continue한다
 * 3. 완성된 dp[i]에 MOD로 모듈러 연산을 한다
 * 4. 완성한 dp[n]을 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */
public class Main {

    static final int MOD =1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = dp[i-1];
            if(i - m < 0 ){
                continue;
            }
            dp[i] += dp[i-m];
            dp[i] %= MOD;
        }
        bw.write(dp[n]+"");


        br.close();
        bw.close();
    }

}
