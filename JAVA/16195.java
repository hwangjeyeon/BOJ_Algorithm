import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 2차원 dp를 만들어서 해결할 수 있다
 * 2. i를 1,2,3을 더해서 만들어야하는 합의 값으로 판단하고, j를 1,2,3을 사용할 수 있는 개수를 의미한다
 * 3. 이를 이용하면, 현재 j-1에서 1,2,3을 한번 사용할 때, 그 현재 i의 값을 만들 수 있으므로 i-1,i-2,i-3 각각 에 대해 합산을 더해주면 된다
 * 4. 즉 dp[i][j] = dp[i-1][j-1] + dp[i-2][j-1] + dp[i-1][j-1]이라는 점화식이 나온다
 * 5. 이를 이용해 모든 값을 구해두면 된다
 * 6. 이후 각 입력값에 대하여 그 위치의 값을 출력하는데, 1~m까지의 위치를 합산해주고 이후 출력하면 된다
 * 7. 단 (ans + dp[n][i]) % MOD로 해줘야지 오버플로우 같은 문제가 발생하지 않는다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n*m)
 *
 */

public class Main {

    private static final int MOD = 1_000_000_009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[1001][1001];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[3][1] = 1;
        dp[2][2] = 1;
        dp[3][3] = 1;
        dp[3][2] = 2;

        for (int i = 4; i < 1001; i++) {
            for (int j = 2; j < 1001; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-2][j-1] + dp[i-3][j-1]) % MOD;
            }
        }

        while(T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long ans = 0;
            for (int i = 1; i < m+1; i++) {
                ans = (ans + dp[n][i]) % MOD;
            }
            bw.write(ans+"\n");
        }
        
        br.close();
        bw.close();
    }
}
