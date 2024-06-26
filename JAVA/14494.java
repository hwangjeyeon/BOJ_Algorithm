

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 점화식은 주어진대로 그냥 쉽게 뽑을 수 있다
 * 2. 한가지 주의할점은 long타입으로 dp선언하고 경우의 수를 구하는 것이라 모서리 부분은 모두 1로 통일된다는 점이다.
 *
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n*m)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] dp = new long[1001][1001];
        dp[1][1] = 1;
        for (int i = 2; i < 1001; i++) {
            dp[1][i] = dp[1][i-1];
        }

        for (int i = 2; i < 1001; i++) {
            dp[i][1] = dp[i-1][1];
        }

        for (int i = 2; i < 1001; i++) {
            for (int j = 2; j < 1001; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1] + dp[i-1][j-1]) % 1000000007;
            }
        }

        bw.write(dp[n][m]%1000000007+"");

        br.close();
        bw.close();
    }
}

