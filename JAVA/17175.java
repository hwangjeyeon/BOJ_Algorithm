import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 점화식: dp[i] = (dp[i-2] + dp[i-1] + 1) % 1000000007
 *
 * 해결방법:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[51];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < 51; i++) {
            dp[i] = (dp[i-2] + dp[i-1] + 1) % 1000000007;
        }

        bw.write(dp[n]+"");

        br.close();
        bw.close();
    }

}

